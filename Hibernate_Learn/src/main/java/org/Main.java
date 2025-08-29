package org;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class Main {
    public static void main(String [] args ) {
        Students s1 = new Students();
        s1.setRoll(12);
        s1.setName("Ritankar Pal");
        s1.setScore(100);




//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.Students.class);
//        cfg.configure();
//        SessionFactory  sf = cfg.buildSessionFactory();
        // below code is the segregated way

        SessionFactory  sf = new Configuration()
                .addAnnotatedClass(org.Students.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction tn = session.beginTransaction();


          session.remove(s1);
//        session.merge(s1);
        tn.commit();
        sf.close();

        session.close();
     System.out.println(s1);
    }
}
