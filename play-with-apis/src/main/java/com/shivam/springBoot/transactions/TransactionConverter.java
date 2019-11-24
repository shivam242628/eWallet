package com.shivam.springBoot.transactions;

import com.shivam.springBoot.convertor.IConverter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionConverter implements IConverter<TransactionEntity, TransactionVo> {
    @Override
    public TransactionEntity mapVoToEntity(TransactionVo transactionVo) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(transactionVo.getId());
        transactionEntity.setFromNumber(transactionVo.getFromNumber());
        transactionEntity.setToNumber(transactionVo.getToNumber());
        transactionEntity.setAmount(transactionVo.getAmount());
        transactionEntity.setTime(new Date());
        return transactionEntity;
    }

    @Override
    public TransactionVo mapEntityToVo(TransactionEntity transactionEntity) {
        return TransactionVo.builder()
                .id(transactionEntity.getId())
                .fromNumber(transactionEntity.getFromNumber())
                .toNumber(transactionEntity.getToNumber())
                .amount(transactionEntity.getAmount())
                .time(transactionEntity.getTime())
                .build();
    }
}
