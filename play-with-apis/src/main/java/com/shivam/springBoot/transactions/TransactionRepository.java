package com.shivam.springBoot.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    List<TransactionEntity> findAllByFromNumber(long sender);

    List<TransactionEntity> findAllByToNumber(long receiver);

    //JPA query
    @Query(value = "SELECT * FROM transaction t WHERE t.from_number = :mobileNumber OR t.to_number = :mobileNumber", nativeQuery = true)
    List<TransactionEntity> findAllTransactions(@Param("mobileNumber") long mobileNumber);
}
