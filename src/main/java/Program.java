import DAO.ConnectCommand;
import DAO.TypeCommand;
import Entitu.TypeEntity;
import MyDAO.MySessionFactory;
import MyDAO.MyTypeCommand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Hello71");
//
       SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

//        session.beginTransaction();
//        TypeEntity typeEntity = new TypeEntity();
//        typeEntity.setName("Light");
//        session.save(typeEntity);
//        session.getTransaction().commit();

        session.beginTransaction();
        List<TypeEntity> list = session.createCriteria(TypeEntity.class).list();



//        List<Object[]> entities = session.createSQLQuery("select * from Type ").list();
//
//
//        for (Object[] entity : entities) {
//            for (Object entityCol : entity) {
//                System.out.print(" " + entityCol);
//            }
//            System.out.println("");
//        }
//
       session.getTransaction().commit();

       session.getTransaction().begin();
       TypeEntity first=session.get(TypeEntity.class,6);
      // first.setName("Cool");
       // session.delete(first);
       session.getTransaction().commit();
       System.out.println(first.getId()+" "+ first.getName()+"вывод 5-того ");

        for (TypeEntity ty: list) {
            System.out.println(ty.getId()+" "+ty.getName());
        }

        session.close();
        sessions.close();

        System.out.println("Hello72");

        MyTypeCommand typeCommand= new MyTypeCommand();
        typeCommand.readAll();

       // MySessionFactory.getSession().getTransaction().begin();


    }
}
