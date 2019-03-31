package MyDAO;

import Entitu.TypeEntity;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class MyTypeCommand  {

    //@Override
    public void delete() {
        MySessionFactory.getSession().getTransaction().begin();

        System.out.print("Введите номер Id для удаления записи ");
        Scanner scan = new Scanner(System.in);
        TypeEntity typeEntity= MySessionFactory.getSession().get(TypeEntity.class,scan.nextLine());
        MySessionFactory.getSession().delete(typeEntity);
        MySessionFactory.getSession().getTransaction().commit();
        System.out.println ("Данные удалены");
    }

    //@Override
    public void add() {
        MySessionFactory.getSession().getTransaction().begin();
        System.out.print("Введите название нового типа ");
        Scanner scan = new Scanner(System.in);
        TypeEntity typeEntity= new TypeEntity();
        typeEntity.setName(scan.nextLine());
        MySessionFactory.getSession().save(typeEntity);
        MySessionFactory.getSession().getTransaction().commit();
        System.out.println ("Данные сохранены");
    }

    public  void  readAll()
    {
        MySessionFactory.getSession().beginTransaction();
        List<TypeEntity> list = MySessionFactory.getSession().createCriteria(TypeEntity.class).list();
        MySessionFactory.getSession().getTransaction().commit();

        System.out.println("Список всех типов носков"+"\n\n");
        for (TypeEntity ty: list) {
            System.out.println(ty.toString());
        }
    }
}
