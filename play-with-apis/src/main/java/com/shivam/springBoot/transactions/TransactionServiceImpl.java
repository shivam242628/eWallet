package com.shivam.springBoot.transactions;

import com.shivam.springBoot.service.BaseDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl extends BaseDataService<TransactionEntity, TransactionVo> implements ITransactionService {

    private TransactionRepository transactionRepository;

    private  TransactionConverter transactionConverter;

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionConverter transactionConverter) {
        super(transactionRepository, transactionConverter);
        this.transactionRepository = transactionRepository;
        this.transactionConverter = transactionConverter;
    }

    @Override
    public List<TransactionVo> findBySender(long sender) {
        List<TransactionEntity> transactions = transactionRepository.findAllByFromNumber(sender);
        return transactions
                .stream()
                .map(transactionConverter::mapEntityToVo)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionVo> findByReceiver(long receiver) {
        List<TransactionEntity> transactions = transactionRepository.findAllByToNumber(receiver);
        return transactions
                .stream()
                .map(transactionConverter::mapEntityToVo)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionVo> findAllTransactions(long mobileNumber) {
        List<TransactionEntity> transactions = transactionRepository.findAllTransactions(mobileNumber);
        return transactions
                .stream()
                .map(transactionConverter::mapEntityToVo)
                .collect(Collectors.toList());
    }
}
