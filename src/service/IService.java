package service;

import model.PhoneBook;

import java.util.List;

public interface IService<T> {
    List<PhoneBook> show();
    void add(T t);
    void update(T t);
    void delete(String name);
    T findByName(String name);
    void readFile(String pathName);
    void writeFile(String pathName);


}
