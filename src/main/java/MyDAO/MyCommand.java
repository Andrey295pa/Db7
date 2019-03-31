package MyDAO;

import DAO.DAO;
import Entitu.TypeEntity;
import org.hibernate.Session;

import java.util.List;

public abstract class MyCommand <TEntyti >  implements  MyCommandDjeneric <TEntyti>  {


    public abstract   void  Delete(TEntyti obj);

    public abstract void Add( TEntyti obj);

    public  void ReadAll(TEntyti obj)
    {
//        MySessionFactory.getSession().beginTransaction();
//        List<TEntyti> list = MySessionFactory.getSession().createCriteria(TEntyti.class).list();
//
//        MySessionFactory.getSession().getTransaction().commit();
    }

}
