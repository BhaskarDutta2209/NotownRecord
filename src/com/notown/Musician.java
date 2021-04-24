package com.notown;

import java.sql.*;
import java.util.Scanner;

public class Musician {

    public void addMusician(Connection connection) {

        Scanner sc  = new Scanner(System.in);

        System.out.println("Enter musician name");
        String m_name = sc.nextLine();
        System.out.println("Enter email address");
        String m_email = sc.nextLine();
        System.out.println("Enter annual income");
        int annual_income = Integer.parseInt(sc.nextLine());
        System.out.println("Enter phone number");
        String phone = sc.nextLine();
        System.out.println("Enter Home Id");
        int h_id = Integer.parseInt(sc.nextLine());

        try {
            String sql = "INSERT INTO musicians (m_name, m_email, annual_income, phone, h_id)" + "VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, m_name);
            statement.setString(2, m_email);
            statement.setInt(3, annual_income);
            statement.setString(4, phone);
            statement.setInt(5, h_id);

            int rows = statement.executeUpdate();
            if(rows > 0) {
                System.out.println("Data entered successfully");
            }

        } catch (SQLException exp) {
            exp.printStackTrace();
        }

    }

}
