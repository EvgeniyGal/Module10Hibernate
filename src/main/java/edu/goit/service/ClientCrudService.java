package edu.goit.service;

import edu.goit.entity.Client;
import edu.goit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class ClientCrudService {

    public Optional<Client> get(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Client.class, id));
        }
    }

    public void delete(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }

    public void create(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public void update(Client client) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }
    }
}
