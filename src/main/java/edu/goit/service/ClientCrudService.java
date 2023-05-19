package edu.goit.service;

import edu.goit.entity.Client;
import edu.goit.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class ClientCrudService {

    public Optional<Client> get(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return Optional.of(session.get(Client.class, id));
        }
    }

    public void delete(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.remove(client);
        }
    }

    public void create(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.persist(client);
        }
    }

    public void update(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.merge(client);
        }
    }
}
