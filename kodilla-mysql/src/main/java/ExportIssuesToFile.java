import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportIssuesToFile {
    public static void main(String[] args) {
        // Parametry połączenia z bazą danych
        String jdbcURL = "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=UTC";
        String dbUser = "kodilla_user";
        String dbPassword = "password";

        // Dynamiczne ustawienie ścieżki do folderu kodilla-mysql
        String modulePath = System.getProperty("user.dir");
        if (!modulePath.endsWith("kodilla-mysql")) {
            modulePath += "/kodilla-mysql";
        }
        String resourcesPath = modulePath + "/src/main/resources/issues.txt";

        Connection connection = null;

        try {
            // Ładowanie sterownika JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Nawiązanie połączenia z bazą danych
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            if (connection != null) {
                System.out.println("Connection with database successful!");
            } else {
                System.out.println("I can't connect to database");
                return;
            }

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM issues");
                 BufferedWriter writer = new BufferedWriter(new FileWriter(resourcesPath))) {

                // Zapis nagłówków do pliku
                writer.write("ID\tISSUESLIST_ID\tSUMMARY\tDESCRIPTION\tUSER_ID_ASSIGNEDTO");
                writer.newLine();

                // Przetwarzanie wyników zapytania
                boolean hasResults = false;
                while (resultSet.next()) {
                    hasResults = true;

                    int id = resultSet.getInt("ID");
                    String summary = resultSet.getString("SUMMARY");
                    String description = resultSet.getString("DESCRIPTION");
                    int issuesListId = resultSet.getInt("ISSUESLIST_ID");
                    int userId = resultSet.getInt("USER_ID_ASSIGNEDTO");

                    // Obsługa null
                    summary = (summary != null) ? summary : "Brak podsumowania";
                    description = (description != null) ? description : "Brak opisu";

                    // Zapisanie danych
                    writer.write(id + "\t" + issuesListId + "\t" + summary + "\t" + description + "\t" + userId);
                    writer.newLine();
                }

                if (!hasResults) {
                    System.out.println("Zapytanie SQL nie zwróciło żadnych danych.");
                }
                System.out.println("Dane wyeksportowano do: " + resourcesPath);

            } catch (SQLException e) {
                System.err.println("Błąd podczas zapytań do bazy danych: " + e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Nie znaleziono sterownika JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Błąd połączenia z bazą danych.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Połączenie z bazą danych zamknięte.");
                } catch (SQLException e) {
                    System.err.println("Błąd zamykania połączenia: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}