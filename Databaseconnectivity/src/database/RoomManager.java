package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RoomManager {
    public void addRoom() {
        try (Connection connection = Myclass.getConnection();
             Scanner scanner = new Scanner(System.in)) {
             
            System.out.println("Enter room number:");
            String roomNumber = scanner.nextLine();
            
            System.out.println("Enter room type:");
            String type = scanner.nextLine();
            
            System.out.println("Enter price per night:");
            double pricePerNight = scanner.nextDouble();
            
            System.out.println("Enter room status (available/booked):");
            String status = scanner.next();
            
            String sql = "INSERT INTO Room (room_number, type, price_per_night, status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, roomNumber);
                stmt.setString(2, type);
                stmt.setDouble(3, pricePerNight);
                stmt.setString(4, status);
                
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("A new room has been added successfully.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void viewRoomDetails() {
        try (Connection connection = Myclass.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Room")) {
             
            while (rs.next()) {
                System.out.println("Room ID: " + rs.getInt("room_id"));
                System.out.println("Room Number: " + rs.getString("room_number"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Price per Night: " + rs.getDouble("price_per_night"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}