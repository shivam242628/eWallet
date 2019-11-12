package com.shivam.springBoot.entity;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public interface BaseVo<V> {

    V withId(int id);

    int getId();
}
