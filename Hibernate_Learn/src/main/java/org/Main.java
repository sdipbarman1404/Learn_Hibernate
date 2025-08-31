package org;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static  void main(String [] args ) {

        Laptop l1 = new Laptop();
                l1.setL_id(101);
                l1.setBrand("Asus");
                l1.setModel("Rog");
                l1.setRam(16);


        Laptop l2 = new Laptop();
        l2.setL_id(105);
        l2.setBrand("Dell");
        l2.setModel("Inspiror");
        l2.setRam(16);

        Developer d1 = new Developer();
        d1.setId(01);
        d1.setName("Ritankar Pal");
        d1.setTech("Java");
        d1.setLaptop(Arrays.asList(l1,l2));

        l1.setDeveloper(d1);
        l2.setDeveloper(d1);

        SessionFactory  sf = new Configuration()
                .addAnnotatedClass(org.Developer.class)
                .addAnnotatedClass(org.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction tn = session.beginTransaction();


//          session.remove(s1);
//        session.merge(s1);
        session.persist(d1);
        session.persist(l1);
        session.persist(l2);
        tn.commit();
        Developer d2 = session.get(Developer.class,1);
        System.out.println(d2);
        sf.close();

        session.close();
     System.out.println(d1);
    }
}
