package Model;

import java.sql.*;
import java.util.Random;

public class Sensore {
    Random rand = new Random();

    public Sensore() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:db.db");
        PreparedStatement prep = connection.prepareStatement("INSERT INTO Sensore values(?, ?, ?);");

        for(int i = 0; i < 10; i++) {
            prep.setString(1, "ID_" + i);
            prep.setString(2, "Marca_" + rand.nextInt(3));
            prep.setString(3, "Tipo_" + rand.nextInt(4));

            prep.execute();
        }
    }
}
