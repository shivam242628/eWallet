package com.shivam.springBoot.transactions;

import com.shivam.springBoot.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "TRANSACTION")

@EqualsAndHashCode(callSuper = false)
public class TransactionEntity extends BaseEntity<TransactionEntity> {

    @Column(name = "FROM_NUMBER")
    private long fromNumber;

    @Column(name = "TO_NUMBER")
    private long toNumber;

    @Column(name = "AMOUNT")
    private float amount;

    @Column(name = "TIME")
    private Date time;

}
