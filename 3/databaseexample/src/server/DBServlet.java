package server;

import server.dao.PersonDAO;
import server.tables.Person;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "DBServlet", urlPatterns = {"/persons"})
public class DBServlet extends HttpServlet {
    @Resource(mappedName = "jdbc/library")
    DataSource ds;

    PersonDAO personDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            personDAO = new PersonDAO(ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> persons = personDAO.findAll();
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/persons.jsp").forward(request, response);

    }
}
