package org;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class Main {
    public static  void main(String [] args ) {

        Laptop l1 = new Laptop();
                l1.setBrand("Asus");
                l1.setModel("Rog");
                l1.setRam(16);
        Developer d1 = new Developer();
        d1.setId(01);
        d1.setName("Ritankar Pal");
        d1.setTech("Java");
        d1.setLaptop(l1);


        SessionFactory  sf = new Configuration()
                .addAnnotatedClass(org.Developer.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction tn = session.beginTransaction();


//          session.remove(s1);
//        session.merge(s1);
        session.persist(d1);
        tn.commit();
        Developer d2 = session.get(Developer.class,1);
        System.out.println(d2);
        sf.close();

        session.close();
     System.out.println(d1);
    }
}
