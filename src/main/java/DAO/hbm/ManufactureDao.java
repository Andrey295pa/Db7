package DAO.hbm;

import Entitu.ManufactureEntity;
import org.apache.commons.validator.routines.IntegerValidator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class ManufactureDao extends BaseDao<ManufactureEntity, Integer> {
    private IntegerValidator Int32 = IntegerValidator.getInstance();

    public ManufactureDao(SessionFactory factory) {
        super(factory, ManufactureEntity.class);
    }

    @Override
    public Collection<ManufactureEntity> find(String filter) {
        Session session = factory.getCurrentSession();
        return session
                .createQuery("from Manufacture " +
                        "where id = :id " +
                        "or name like :filter")
                .setParameter("id", Int32.validate(filter))
                .setParameter("filter", String.format("%%%s%%", filter))
                .list();
    }
}

