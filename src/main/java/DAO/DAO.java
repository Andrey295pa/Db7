//package DAO;
//
//import java.util.Collection;
//
//public interface DAO<TEntyti,Tkey> {
//   // void save(Collectionection<TEntyti>entuty  );
//    void save();
//    void delete();
//    Collection<TEntyti> readAll();
//    Collection<TEntyti> find(String filter);
//}

package DAO;

import java.util.Collection;

public interface DAO<TEntity, TKey> {
    void save(Collection<TEntity> entity);

    TEntity read(TKey id);

    Collection<TEntity> readAll();

    Collection<TEntity> find(String filter);

    void delete(TKey id);
}
