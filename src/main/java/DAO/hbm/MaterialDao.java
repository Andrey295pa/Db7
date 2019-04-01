package DAO.hbm;

import Entitu.MaterialEntity;
import Entitu.TypeEntity;
import org.apache.commons.validator.routines.IntegerValidator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class MaterialDao extends BaseDao<MaterialEntity, Integer> {
    private IntegerValidator Int32 = IntegerValidator.getInstance();

    public MaterialDao(SessionFactory factory) {
        super(factory, MaterialEntity.class);
    }

    @Override
    public Collection<MaterialEntity> find(String filter) {
        Session session = factory.getCurrentSession();
        return session
                .createQuery("from Material " +
                        "where id = :id " +
                        "or name like :filter")
                .setParameter("id", Int32.validate(filter))
                .setParameter("filter", String.format("%%%s%%", filter))
                .list();
    }
}
