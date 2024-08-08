package com.aslan;

import com.aslan.Util.HibernateUtil;
import com.aslan.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Открытие сессии
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Student student = new Student("Grisha", "Polejaev", "grisha_polijaev@gmail.com", LocalDate.of(1994, 14, 9));



            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Закрытие фабрики сессий
        HibernateUtil.getSessionFactory().close();
    }
}
