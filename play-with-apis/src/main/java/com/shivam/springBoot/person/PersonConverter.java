package com.shivam.springBoot.person;

import com.shivam.springBoot.convertor.IConverter;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter implements IConverter<PersonEntity, PersonVo> {

    @Override
    public PersonEntity mapVoToEntity(PersonVo personVo) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setAge(personVo.getAge());
        personEntity.setId(personVo.getId());
        personEntity.setFirstName(personVo.getFirstName());
        personEntity.setLastName(personVo.getLastName());
        personEntity.setEmail(personVo.getEmail());
        personEntity.setBalance(personVo.getBalance());
        personEntity.setMobileNumber(personVo.getMobileNumber());
        personEntity.setPassword(personVo.getPassword());
        return personEntity;
    }

    @Override
    public PersonVo mapEntityToVo(PersonEntity personEntity) {
        return PersonVo.builder()
                .id(personEntity.getId())
                .firstName(personEntity.getFirstName())
                .lastName(personEntity.getLastName())
                .age(personEntity.getAge())
                .balance(personEntity.getBalance())
                .email(personEntity.getEmail())
                .password(personEntity.getPassword())
                .mobileNumber(personEntity.getMobileNumber())
                .build();
    }
}
