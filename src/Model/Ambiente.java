package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Ambiente {
    Random rand = new Random();
    ArrayList<Integer> list = new ArrayList<>();
    Boolean isEmpty = false;

    public Ambiente() throws SQLException {
        for(int i = 0; i < 5; i++) {
            list.add(i);
        }

        System.out.println(list.size());

        Connection connection = DriverManager.getConnection("jdbc:sqlite:db.db");
        PreparedStatement prep = connection.prepareStatement("INSERT INTO Ambiente values(?, ?, ?);");

        while(!list.isEmpty()){
            Integer index = rand.nextInt(5);
            int counter = 0;

            if(list.contains(index))
                list.remove(index);

            String a = "a" + index;
            prep.setString(1, a);

            String b = "IDa_" + counter;
            prep.setString(2, b);

            String c = "Variabile_" + rand.nextInt(4);
            prep.setString(3, c);

            System.out.println(a);
            System.out.println(b);
            System.out.println(c + "\n");

            prep.execute();

            counter++;
        }
    }
}