package server.dao;

import server.tables.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugeny on 24.03.2016.
 */
public class PersonDAO {
    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int age = rs.getInt("age");
                String adress = rs.getString("adress");
                Person p = new Person(id,firstname,lastname,age,adress);
                persons.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return persons;
        }

    }
}
