package service.dao;

import java.util.List;

public interface Dao<T> {

    //CRUD Operations

    //CREATE
    public abstract void save(T t);

    //READ de la index  si return tot
    public abstract T get(int index);
    public abstract List<T> getAll();

    //UPDATE
    public abstract void update(T t, String[] parameters);

    //DELETE pe obiect
    public abstract void delete(T t);

}
