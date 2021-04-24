package com.notown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Performs {

    public void addPerforms(Connection connection) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the song");
        int s_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the musician ssn");
        int ssn = Integer.parseInt(sc.nextLine());

        try {

            String sql = "INSERT INTO performs (s_id, ssn)" + "VALUES(?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, s_id);
            statement.setInt(2, ssn);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Data entered successfully");
            }

        } catch (SQLException exp) {
            exp.printStackTrace();
        }

    }

}
