package org.example.Classes;

import org.example.Model.Train;
import org.example.Model.TrainCoach;
import org.example.Model.User;

import java.util.List;
import java.util.concurrent.BlockingDeque;

public class TrainTicketReservation extends TicketReservation {

    public TrainTicketReservation(TicketReservation reservation) {
        this.setBookedUsers(reservation.getBookedUsers());
        this.setUsersOnRAC(reservation.getUsersOnRAC());
        this.setUserOnWL(reservation.getUserOnWL());
        this.setTrainsInBooking(reservation.getTrainsInBooking());
    }

    public User bookSeatInTrain(User user) throws Exception {

        Train train = super.searchTrain(
                user.getBookedTrainName(),
                user.getBookedTrainNo()
        );

        if (train == null) {
            throw new Exception("Train not found");
        }

        if (train.getAvailableSeats() > 0) {

            int[] seating = super.findAvailableSeat(train);
            if (seating != null) {

                TrainCoach coach = train.getCoaches().get(seating[0]);
                boolean[][] seats = coach.getSeatAllocations();

                seats[seating[1]][seating[2]] = true;
                coach.setSeatAllocations(seats);

                user.setUser_id(USER_ID_COUNTER++);
                user.setSeat(new int[]{seating[1], seating[2]});
                user.setCoach(coach.getCoachName());

                super.getBookedUsers().add(user);
                train.setAvailableSeats(train.getAvailableSeats() - 1);
            }

        }

        else if (train.getRAC().size() < 10) {

            train.getRAC().offer(user);
            user.setSeat(null);
            user.setCoach(null);

            super.getUsersOnRAC().add(user);
        }

        else if (train.getWL().size() < 10) {

            train.getWL().offer(user);
            super.getUserOnWL().add(user);
        }
        else {
            throw new Exception("No seats available");
        }

        return user;
    }

    public void cancelTicket(int id) throws Exception {

        User bookedUser = super.searchUsers(id);
        if (bookedUser == null) {
            throw new Exception("User doesn't exist");
        }

        Train train = super.searchTrain(
                bookedUser.getBookedTrainName(),
                bookedUser.getBookedTrainNo()
        );

        for (TrainCoach coach : train.getCoaches()) {
            if (coach.getCoachName().equals(bookedUser.getCoach())) {

                int row = bookedUser.getSeat()[0];
                int col = bookedUser.getSeat()[1];
                coach.getSeatAllocations()[row][col] = false;
                train.setAvailableSeats(train.getAvailableSeats() + 1);
                break;
            }
        }

        super.getBookedUsers().remove(bookedUser);

        BlockingDeque<User> RAC = train.getRAC();
        BlockingDeque<User> WL = train.getWL();

        if (!RAC.isEmpty()) {
            User racUser = RAC.poll();
            racUser.setCoach(bookedUser.getCoach());
            racUser.setSeat(bookedUser.getSeat());
            super.getBookedUsers().add(racUser);

            if (!WL.isEmpty()) {
                RAC.offer(WL.poll());
            }
        }

        train.setRAC(RAC);
        train.setWL(WL);
    }
}
