package database;

import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomManager roomManager = new RoomManager();
        CustomerManager customerManager = new CustomerManager();
        ReservationManager reservationManager = new ReservationManager();
        
        while (true) {
            System.out.println("Hotel Reservation System");
            System.out.println("1. Add Room");
            System.out.println("2. View Room Details");
            System.out.println("3. Register Customer");
            System.out.println("4. View Customer Details");
            System.out.println("5. Make Reservation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    roomManager.addRoom();
                    break;
                case 3:
                    customerManager.registerCustomer();
                    break;
                
                case 4:
                    reservationManager.makeReservation();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
