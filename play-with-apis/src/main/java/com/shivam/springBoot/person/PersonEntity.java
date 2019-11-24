package com.shivam.springBoot.person;

import com.shivam.springBoot.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSON")
@Data
@EqualsAndHashCode(callSuper = false)
public class PersonEntity extends BaseEntity<PersonEntity> {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "ACCOUNT_BALANCE")
    private float balance;

    @Column(name = "MOBILE_NUMBER")
    private long mobileNumber;

    @Column(name = "PASSWORD")
    @Size(min = 6, message = "Minimum length of password should be 6")
    private String password;

}
