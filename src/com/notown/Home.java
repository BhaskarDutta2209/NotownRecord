package com.notown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Home {

    public void addHome(Connection connection) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter house id");
        int h_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter address");
        String address = sc.nextLine();
        System.out.println("Enter phone number");
        String phone = sc.nextLine();

        try {

            String sql = "INSERT INTO home (h_id, address, phone)" + "VALUE (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, h_id);
            statement.setString(2, address);
            statement.setString(3, phone);

            int rows = statement.executeUpdate();
            if(rows > 0) {
                System.out.println("Data entered successfully");
            }

        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
}
