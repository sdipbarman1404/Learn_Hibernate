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


        Laptop l3 = new Laptop();
        l3.setL_id(110);
        l3.setBrand("HP");
        l3.setModel("EliteBook");
        l3.setRam(8);

        Developer d1 = new Developer();
        d1.setId(01);
        d1.setName("Swapnadip ");
        d1.setTech("Java");
        d1.setLaptop(Arrays.asList(l1,l2));

        Developer d2 = new Developer();
        d2.setId(02);
        d2.setName("Srja");
        d2.setTech("Azure");
        d2.setLaptop(Arrays.asList(l2,l3));

        l1.setDeveloper(Arrays.asList(d1));
        l2.setDeveloper(Arrays.asList(d1,d2));
        l3.setDeveloper((Arrays.asList(d2)));

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
        session.persist(d2);

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        tn.commit();
        System.out.println(d2);
        sf.close();

        session.close();
     System.out.println(d1);
    }
}
