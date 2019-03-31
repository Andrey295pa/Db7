package MyDAO;

import Entitu.MaterialEntity;
import Entitu.TypeEntity;

import java.util.List;
import java.util.Scanner;

public class MyMaterialCommand {
    public void delete() {
        MySessionFactory.getSession().getTransaction().begin();

        System.out.print("Введите номер Id для удаления записи ");
        Scanner scan = new Scanner(System.in);
        MaterialEntity materialEntity= MySessionFactory.getSession().get(MaterialEntity.class,scan.nextLine());
        MySessionFactory.getSession().delete(materialEntity);
        MySessionFactory.getSession().getTransaction().commit();
        System.out.println ("Данные удалены");
    }

    //@Override
    public void add() {
        MySessionFactory.getSession().getTransaction().begin();
        System.out.print("Введите название нового типа ");
        Scanner scan = new Scanner(System.in);
        MaterialEntity materialEntity= new MaterialEntity();
        materialEntity.setName(scan.nextLine());
        MySessionFactory.getSession().save(materialEntity);
        MySessionFactory.getSession().getTransaction().commit();
        System.out.println ("Данные сохранены");
    }

    public  void  readAll()
    {
        MySessionFactory.getSession().beginTransaction();
        List<MaterialEntity> list = MySessionFactory.getSession().createCriteria(MaterialEntity.class).list();
        MySessionFactory.getSession().getTransaction().commit();

        System.out.println("Список всех типов носков"+"\n\n");
        for (MaterialEntity me: list) {
            System.out.println(me.toString());
        }
    }
}
