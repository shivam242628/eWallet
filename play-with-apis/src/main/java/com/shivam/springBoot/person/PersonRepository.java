package com.shivam.springBoot.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findByMobileNumber(long mobileNumber);
}
