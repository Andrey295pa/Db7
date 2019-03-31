package MyDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 public final   class MySessionFactory {
   static SessionFactory sessions = new Configuration().configure().buildSessionFactory();
   static Session session = sessions.openSession();

//    static {
//         SessionFactory sessions = new Configuration().configure().buildSessionFactory();
//         Session session = sessions.openSession();
//
//    }

   static public   Session getSession() {
        return session;
    }
}
