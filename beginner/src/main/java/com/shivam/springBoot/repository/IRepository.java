package com.shivam.springBoot.repository;

import com.shivam.springBoot.entity.BaseEntity;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public interface IRepository<T extends BaseEntity<T>> {

    T save(T t);

    T update(int id, T t);

    List<T> findAll();

    T findById(int id);

    T deleteById(int id);

    List<T> deleteAll();

}
