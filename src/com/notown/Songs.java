package com.notown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Songs {

    public void addSong(Connection connection) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the song id");
        int s_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter song title");
        String s_title = sc.nextLine();
        System.out.println("Enter author");
        String author = sc.nextLine();
        System.out.println("Enter album id");
        int album_id = Integer.parseInt(sc.nextLine());

        try {

            String sql = "INSERT INTO songs (s_id, s_title, author, album_id)" + "VALUE (?, ?, ?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, s_id);
            statement.setString(2, s_title);
            statement.setString(3, author);
            statement.setInt(4, album_id);

            int rows = statement.executeUpdate();
            if(rows > 0) {
                System.out.println("Data entered successfully");
            }

        } catch (SQLException exp ) {
            exp.printStackTrace();
        }

    }

}
