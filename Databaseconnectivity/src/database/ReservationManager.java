package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ReservationManager {
    public void makeReservation() {
        try (Connection connection = Myclass.getConnection();
             Scanner scanner = new Scanner(System.in)) {
             
            System.out.println("Enter room ID:");
            int roomId = scanner.nextInt();
            
            System.out.println("Enter customer ID:");
            int customerId = scanner.nextInt();
            
            System.out.println("Enter check-in date (YYYY-MM-DD):");
            String checkInDate = scanner.next();
            
            System.out.println("Enter check-out date (YYYY-MM-DD):");
            String checkOutDate = scanner.next();
            
            String sql = "INSERT INTO Reservation (room_id, customer_id, check_in_date, check_out_date, status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, roomId);
                stmt.setInt(2, customerId);
                stmt.setString(3, checkInDate);
                stmt.setString(4, checkOutDate);
                stmt.setString(5, "reserved");
                
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("A new reservation has been made successfully.");
                    
                    // Update room status
                    String updateRoomStatus = "UPDATE Room SET status = ? WHERE room_id = ?";
                    try (PreparedStatement updateStmt = connection.prepareStatement(updateRoomStatus)) {
                        updateStmt.setString(1, "booked");
                        updateStmt.setInt(2, roomId);
                        updateStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
