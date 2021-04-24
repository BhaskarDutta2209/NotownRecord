package com.notown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Plays {

    public void addPlays(Connection connection) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the instrument id");
        int ins_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Musician ssn");
        int ssn = Integer.parseInt(sc.nextLine());

        try {
            String sql = "INSERT INTO plays (ins_id, ssn)" + "VALUE(?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, ins_id);
            statement.setInt(2, ssn);

        } catch (SQLException exp) {
            exp.printStackTrace();
        }

    }

}
