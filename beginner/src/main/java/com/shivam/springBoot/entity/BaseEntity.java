package com.shivam.springBoot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity<T> implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
}
