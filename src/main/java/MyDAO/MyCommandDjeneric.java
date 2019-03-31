package MyDAO;

public interface MyCommandDjeneric <TEntity> {
    public void ReadAll(TEntity obj);
    public  void Delete(TEntity obj,Integer integer);
    public  void  Add(TEntity obj);
}
