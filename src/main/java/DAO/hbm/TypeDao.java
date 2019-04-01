package DAO.hbm;

import Entitu.TypeEntity;
import org.apache.commons.validator.routines.IntegerValidator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class TypeDao extends BaseDao<TypeEntity, Integer> {
    private IntegerValidator Int32 = IntegerValidator.getInstance();

    public TypeDao(SessionFactory factory) {
        super(factory, TypeEntity.class);
    }

    @Override
    public Collection<TypeEntity> find(String filter) {
        Session session = factory.openSession();
        return session
                .createQuery("from Type " +
                        "where id = :id " +
                        "or name like :filter")
                .setParameter("id", Int32.validate(filter))
                .setParameter("filter", String.format("%%%s%%", filter))
                .list();
    }
}

