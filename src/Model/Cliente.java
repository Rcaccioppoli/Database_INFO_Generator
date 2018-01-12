package Model;

import java.sql.*;
import java.util.Random;

public class Cliente {
    Random rand = new Random();

    public Cliente() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:db.db");
        PreparedStatement prep = connection.prepareStatement("INSERT INTO Cliente values(?, ?, ?, ?, ?, ?);");

        for(int i = 0; i < 5; i++) {
            prep.setString(1, "a" + i);
            prep.setString(2, "Azienda_" + i);
            prep.setString(3, "Nome_" + i);
            prep.setString(4, "Cognome_" + i);
            prep.setString(5, "mail" + i + "@gmail.com");
            prep.setString(6, "a" + i);

            prep.execute();
        }
    }
}