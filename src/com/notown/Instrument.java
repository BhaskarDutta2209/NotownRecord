package com.notown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Instrument {

    public void addInstrument(Connection connection) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the instrument id");
        int ins_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the instrument name");
        String ins_name = sc.nextLine();
        System.out.println("Enter the musical key");
        String musical_key = sc.nextLine();

        try {
            String sql = "INSERT INTO instruments (ins_id, ins_name, musical_key) " + "VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, ins_id);
            statement.setString(2, ins_name);
            statement.setString(3, musical_key);

            int rows = statement.executeUpdate();
            if(rows > 0) {
                System.out.println("Data entered successfully");
            }

        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

}
