package edu.goit.service;

import edu.goit.entity.Planet;
import edu.goit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class PlanetCrudService {

    public Optional<Planet> get(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return Optional.of(session.get(Planet.class, id));
        }
    }

    public void delete(Planet Planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(Planet);
            transaction.commit();
        }
    }

    public void create(Planet Planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(Planet);
            transaction.commit();
        }
    }

    public void update(Planet Planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(Planet);
            transaction.commit();
        }
    }
}
