package com.shivam.springBoot.person;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.shivam.springBoot.entity.BaseVo;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Wither
@Builder(toBuilder = true)
@JsonDeserialize(builder = PersonVo.PersonVoBuilder.class)
public class PersonVo implements BaseVo<PersonVo> {

    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private float balance;

    private String password;

    private long mobileNumber;
    

}
