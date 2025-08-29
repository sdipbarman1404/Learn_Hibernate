package org;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class Main {
    public static void main(String [] args ) {
        Students s1 = new Students();
        s1.setRoll(11);
        s1.setName("Deba Pal");
        s1.setScore(66);


        Students s2 = null;

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
       s2 = session.get(Students.class, 3);
//        Transaction tr = session.beginTransaction(); r  // required only when we do transaction
        session.persist(s1);
//        tr.commit();   //since transaction is commented it is also the same
        System.out.println(s2);
        sf.close();

        session.close();

    }
}
