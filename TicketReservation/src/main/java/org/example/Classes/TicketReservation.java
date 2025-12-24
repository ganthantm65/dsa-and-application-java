package org.example.Classes;

import org.example.Model.Train;
import org.example.Model.TrainCoach;
import org.example.Model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketReservation {

    private List<User> bookedUsers;

    private List<User> usersOnRAC;

    private List<User> userOnWL;

    private List<Train> trainsInBooking;

    protected static int USER_ID_COUNTER = 1;

    public TicketReservation(){
        bookedUsers = new ArrayList<>();
        usersOnRAC = new ArrayList<>();
        userOnWL = new ArrayList<>();
        trainsInBooking = new ArrayList<>();
    }

    public void addTrain(int noOfCoaches,String name,String train_no){
        Train newTrain=new Train(noOfCoaches,name,train_no);
        trainsInBooking.add(newTrain);
    }

    public Train searchTrain(String name,String trainCCT){
        for(Train train:trainsInBooking){
            if (name.equals(train.getName()) && trainCCT.equals(train.getTrainCCT())){
                return train;
            }
        }
        return null;
    }

    public User searchUsers(int user_id){
        for (User user:bookedUsers) {
            if (user_id==user.getUser_id()){
                return user;
            }
        }
        return null;
    }

    public void displayUsers(String train_no){
        for (User user:bookedUsers){
            if(user.getBookedTrainNo().equals(train_no)){
                System.out.println("Name:"+user.getName());
                System.out.println("User ID:"+user.getUser_id());
                System.out.println("Age:"+user.getAge());
                System.out.println("Sex"+user.getSex());
                System.out.println("Coach"+user.getCoach());
                System.out.println("Seat"+ Arrays.toString(user.getSeat()));
            }
        }
    }

    public int[] findAvailableSeat(Train train) {
        for (int i = 0; i < train.getCoaches().size(); i++) {
            TrainCoach coach = train.getCoaches().get(i);
            boolean[][] seats = coach.getSeatAllocations();

            for (int j = 0; j < seats.length; j++) {
                for (int k = 0; k < seats[0].length; k++) {
                    if (!seats[j][k]) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return null;
    }

    public String displaySeats(Train train){
        String trainSeats="";
        List<TrainCoach> coaches=train.getCoaches();
        for (int i = 0; i < train.getNoOfCoaches(); i++) {
            trainSeats+=coaches.get(i).getCoachName();
            trainSeats+="\n";
            trainSeats+=coaches.get(i).displaySeats();
            trainSeats+="\n";
        }
        return trainSeats;
    }

    public List<User> getBookedUsers() {
        return bookedUsers;
    }

    public void setBookedUsers(List<User> bookedUsers) {
        this.bookedUsers = bookedUsers;
    }

    public List<User> getUsersOnRAC() {
        return usersOnRAC;
    }

    public void setUsersOnRAC(List<User> usersOnRAC) {
        this.usersOnRAC = usersOnRAC;
    }

    public List<User> getUserOnWL() {
        return userOnWL;
    }

    public void setUserOnWL(List<User> userOnWL) {
        this.userOnWL = userOnWL;
    }

    public List<Train> getTrainsInBooking() {
        return trainsInBooking;
    }

    public void setTrainsInBooking(List<Train> trainsInBooking) {
        this.trainsInBooking = trainsInBooking;
    }


}
