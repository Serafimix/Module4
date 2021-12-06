package ua.rakhmail.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.rakhmail.entity.Race;
import ua.rakhmail.utils.HibernateUtil;

import java.util.List;

public class RaceDao extends DefaultDao {

    public Race getById(int id) {
        Race race = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            race = session.get(Race.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return race;
    }

    public List<Race> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT r FROM Race r", Race.class
            ).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Long getCountOfRace() {
        Long count = 0L;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            count = (Long) session.createQuery(
                    "SELECT count(*) FROM Race r").uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
