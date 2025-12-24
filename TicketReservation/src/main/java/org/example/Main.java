package org.example;

import org.example.Classes.TicketReservation;
import org.example.Classes.TrainTicketReservation;
import org.example.Model.Train;
import org.example.Model.User;

import java.util.Scanner;

public class Main {

    static TicketReservation reservation = new TicketReservation();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {   // 🔁 ASK ROLE FREQUENTLY
            System.out.print("\nEnter role (USER / ADMIN / EXIT): ");
            String role = scanner.nextLine().toUpperCase();

            if (role.equals("USER")) {

                // ⚠️ IMPORTANT: shared reservation object
                TrainTicketReservation ticketReservation =
                        new TrainTicketReservation(reservation);

                while (true) {
                    System.out.print(
                            "\nUSER MENU (1.Book  2.Cancel  3.Back): "
                    );
                    int option = scanner.nextInt();
                    scanner.nextLine();


                    if (option == 3) break; // 🔙 back to role selection

                    switch (option) {
                        case 1:
                            System.out.print("Enter user name: ");
                            String username = scanner.nextLine();

                            System.out.print("Enter age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Enter sex: ");
                            String sex = scanner.nextLine();

                            System.out.print("Enter phone no: ");
                            String phoneno = scanner.nextLine();

                            System.out.print("Enter train name: ");
                            String bookingTrain = scanner.nextLine();

                            System.out.print("Enter train no: ");
                            String bookingTrainNo = scanner.nextLine();

                            User user = new User(
                                    username, age, sex,
                                    phoneno, bookingTrain, bookingTrainNo
                            );

                            try {
                                User bookedUser =
                                        ticketReservation.bookSeatInTrain(user);

                                if (bookedUser.getSeat()!= null){
                                    System.out.println("User ID: " + bookedUser.getUser_id());
                                    System.out.println("Coach: " + bookedUser.getCoach());
                                    System.out.println("Seat: " +
                                            bookedUser.getSeat()[0] + ", " +
                                            bookedUser.getSeat()[1]);
                                }else{
                                    System.out.println("You are in RAC or WL");
                                }

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.print("Enter user ID: ");
                            int userId = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                ticketReservation.cancelTicket(userId);
                                System.out.println("Cancelled Successfully");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("Invalid option");
                    }
                }

            } else if (role.equals("ADMIN")) {

                while (true) {
                    System.out.print(
                            "\nADMIN MENU (1.Add Train  2.Search User  3.Display Users  4.Display Seats  5.Back): "
                    );
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    if (option == 5) break; // 🔙 back to role selection

                    switch (option) {
                        case 1:
                            System.out.print("Enter train name: ");
                            String trainName = scanner.nextLine();

                            System.out.print("Enter train no: ");
                            String trainNo = scanner.nextLine();

                            System.out.print("Enter number of coaches: ");
                            int coaches = scanner.nextInt();
                            scanner.nextLine();

                            reservation.addTrain(coaches, trainName, trainNo);
                            System.out.println("Train added");
                            break;

                        case 2:
                            System.out.print("Enter user ID: ");
                            int searchId = scanner.nextInt();
                            scanner.nextLine();

                            User user = reservation.searchUsers(searchId);
                            if (user != null) {
                                System.out.println("Name: " + user.getName());
                                System.out.println("Train: " + user.getBookedTrainName());
                                System.out.println("Coach: " + user.getCoach());
                            } else {
                                System.out.println("User not found");
                            }
                            break;

                        case 3:
                            System.out.print("Enter train no: ");
                            String train_no = scanner.nextLine();
                            reservation.displayUsers(train_no);
                            break;

                        case 4:
                            System.out.print("Enter train name: ");
                            String tname = scanner.nextLine();

                            System.out.print("Enter train CCT: ");
                            String cct = scanner.nextLine();

                            Train train = reservation.searchTrain(tname, cct);
                            if (train != null) {
                                System.out.println(reservation.displaySeats(train));
                            } else {
                                System.out.println("Train not found");
                            }
                            break;

                        default:
                            System.out.println("Invalid option");
                    }
                }

            } else if (role.equals("EXIT")) {
                System.out.println("Thank you for using Train Reservation System 🚆");
                break;
            } else {
                System.out.println("Invalid role");
            }
        }

        scanner.close();
    }
}
