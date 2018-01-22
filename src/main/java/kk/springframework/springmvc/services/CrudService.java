package kk.springframework.springmvc.services;

import java.util.List;

public interface CrudService<T> {
    List<?> listAll();

    T getById(Integer id);

    T createOrUpdate(T input);

    void delete(Integer id);}
