package com.shivam.springBoot.transactions;

import com.shivam.springBoot.service.IDataService;

import java.util.List;

public interface ITransactionService extends IDataService<TransactionVo> {
    List<TransactionVo> findBySender(long sender);

    List<TransactionVo> findByReceiver(long receiver);

    List<TransactionVo> findAllTransactions(long mobileNumber);
}
