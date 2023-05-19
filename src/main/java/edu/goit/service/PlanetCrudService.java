package edu.goit.service;

import edu.goit.entity.Planet;
import edu.goit.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class PlanetCrudService {

    public Optional<Planet> get(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return Optional.of(session.get(Planet.class, id));
        }
    }

    public void delete(Planet Planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.remove(Planet);
        }
    }

    public void create(Planet Planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.persist(Planet);
        }
    }

    public void update(Planet Planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.merge(Planet);
        }
    }
}
