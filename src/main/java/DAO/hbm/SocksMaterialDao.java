package DAO.hbm;

import Entitu.ManufactureEntity;
import Entitu.SocksMaterialEntity;
import org.apache.commons.validator.routines.IntegerValidator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class SocksMaterialDao extends BaseDao<SocksMaterialEntity, Integer> {
    private IntegerValidator Int32 = IntegerValidator.getInstance();

    public SocksMaterialDao(SessionFactory factory) {
        super(factory, SocksMaterialEntity.class);
    }

    @Override
    public Collection<SocksMaterialEntity> find(String filter) {
        Session session = factory.getCurrentSession();
        return session
                .createQuery("from SocksMaterial " +
                        "where id = :id " +
                        "or name like :filter")
                .setParameter("id", Int32.validate(filter))
                .setParameter("filter", String.format("%%%s%%", filter))
                .list();
    }

}
