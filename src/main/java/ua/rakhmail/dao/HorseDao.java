package ua.rakhmail.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.rakhmail.entity.Horse;
import ua.rakhmail.utils.HibernateUtil;

import java.util.List;

public class HorseDao extends DefaultDao {

    public Horse getByID(int id) {
        Horse horse = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            horse = session.get(Horse.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return horse;
    }

    public List<Horse> getChosenHorses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT h FROM Horse h WHERE h.isChosen = true", Horse.class
            ).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Horse> getAllHorseByRaceId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Horse WHERE race_id =" + id, Horse.class
            ).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Long getCountOfHorses() {
        Long count = 0L;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            count = (Long) session.createQuery(
                    "SELECT count(*) FROM Horse h").uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            return count;
    }

    public Long getCountOfHorsesByIdRace(int id){
        Long count = 0L;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            count = (Long) session.createQuery(
                    "SELECT count(*) FROM Horse WHERE race_id =" + id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public List<Horse> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT h FROM Horse h", Horse.class
            ).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
