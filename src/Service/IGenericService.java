package Service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();
    void save(T t);
    void deleteByID(int id);
    void editByID (int id);
    T findByID (int id);
}
