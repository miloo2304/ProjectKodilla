package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersWithAtLeastTwoPosts() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = """
        SELECT u.FIRSTNAME, u.LASTNAME, COUNT(p.ID) as POST_COUNT
        FROM USERS u
        JOIN POSTS p ON u.ID = p.USER_ID
        GROUP BY u.ID, u.FIRSTNAME, u.LASTNAME
        HAVING COUNT(p.ID) >= 2;
    """;

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        int counter = 0;
        System.out.println("Users with at least 2 posts:");
        while (rs.next()) {
            String firstName = rs.getString("FIRSTNAME");
            String lastName = rs.getString("LASTNAME");
            int postCount = rs.getInt("POST_COUNT");

            System.out.println(firstName + " " + lastName + " (" + postCount + " posts)");
            counter++;
        }

        rs.close();
        statement.close();
        assertTrue(counter > 0, "No users were found with at least 2 posts!");
    }
}

