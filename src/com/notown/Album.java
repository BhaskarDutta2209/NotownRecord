package com.notown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Album {

    public void addAlbum(Connection connection) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Album Id");
        int album_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the album title");
        String a_title = sc.nextLine();
        System.out.println("Enter the album format");
        String album_format = sc.nextLine();
        System.out.println("Enter the album description");
        String a_desc = sc.nextLine();
        System.out.println("Enter the copyright date (dd/mm/yyyy) ");
        String date = sc.nextLine();
        Date copyright_dt = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        System.out.println("Enter the number of songs");
        int num_of_songs = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the musician ssn");
        int ssn = Integer.parseInt(sc.nextLine());

        try {
            String sql = "INSERT INTO albums (album_id, a_title, album_format, a_desc, copyright_dt, num_of_songs, ssn)" + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, album_id);
            statement.setString(2, a_title);
            statement.setString(3, album_format);
            statement.setString(4, a_desc);
            statement.setDate(5, (java.sql.Date) copyright_dt);
            statement.setInt(6, num_of_songs);
            statement.setInt(7, ssn);

            int rows = statement.executeUpdate();
            if(rows > 0) {
                System.out.println("Data entered successfully");
            }

        } catch (SQLException exp) {
            exp.printStackTrace();
        }

    }

}
