package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerManager {
    public void registerCustomer() {
        try (Connection connection = Myclass.getConnection();
             Scanner scanner = new Scanner(System.in)) {
             
            System.out.println("Enter customer name:");
            String name = scanner.nextLine();
            
            System.out.println("Enter customer email:");
            String email = scanner.nextLine();
            
            System.out.println("Enter customer phone number:");
            String phoneNumber = scanner.nextLine();
            
            System.out.println("Enter customer address:");
            String address = scanner.nextLine();
            
            String sql = "INSERT INTO Customer (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, phoneNumber);
                stmt.setString(4, address);
                
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("A new customer has been registered successfully.");
                }
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}

