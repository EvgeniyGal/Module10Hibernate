package edu.goit;

import edu.goit.entity.Planet;
import edu.goit.util.HibernateUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;

public class Main {


    public static void main(String[] args) {
        final String url = "jdbc:h2:./mydb;TRACE_LEVEL_SYSTEM_OUT=3";
        final String user = "";
        final String password = "";

        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.migrate();

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet client = session.get(Planet.class, "SAT");
        session.close();

        System.out.println(client);

    }

}