package com.notown;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DriverClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String jdbcURL = "jdbc:mysql://localhost:3306/notown_music";
        String username = "bhaskar";
        String password = "neXa@221";

        int ch = -1;

        try {

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            do {

                System.out.println("Enter your choice");
                System.out.println("1. Enter a new Musician");
                System.out.println("2. Enter a new House");
                System.out.println("3. Enter a new Album");
                System.out.println("4. Enter a new instrument");
                System.out.println("5. Enter performance");
                System.out.println("0. Exit");

                ch = Integer.parseInt(sc.nextLine());

                switch (ch) {
                    case 1:
                        Musician musician = new Musician();
                        musician.addMusician(connection);
                        break;
                    case 2:
                        Home home = new Home();
                        home.addHome(connection);
                        break;
                    case 3:
                        Album album = new Album();
                        album.addAlbum(connection);
                        break;
                    case 4:
                        Instrument instrument = new Instrument();
                        instrument.addInstrument(connection);
                        break;
                    case 5:
                        Performs performs = new Performs();
                        performs.addPerforms(connection);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong choice");
                }
            } while (ch != 0);

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }
}
