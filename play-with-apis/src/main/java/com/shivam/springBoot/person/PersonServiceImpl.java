package com.shivam.springBoot.person;

import com.shivam.springBoot.exception.RecordNotFoundException;
import com.shivam.springBoot.service.BaseDataService;
import com.shivam.springBoot.transactions.ITransactionService;
import com.shivam.springBoot.transactions.TransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseDataService<PersonEntity, PersonVo> implements IPersonService {

    private PersonRepository personRepository;

    private PersonConverter personConverter;

    @Autowired
    private ITransactionService transactionService;

    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        super(personRepository, personConverter);
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @Override
    public PersonVo getByMobileNumber(long mobileNumber) {
        PersonEntity personEntity = personRepository.findByMobileNumber(mobileNumber);
        if (personEntity == null) {
            throw new RecordNotFoundException("No record with number " + mobileNumber + " found in database");
        } else {
            return personConverter.mapEntityToVo(personEntity);
        }
    }

    @Override
    public PersonVo addMoneyToWallet(float amount, long mobileNumber) throws RecordNotFoundException {
        PersonVo personVo = getByMobileNumber(mobileNumber);
        PersonEntity personEntity = personConverter.mapVoToEntity(personVo);
        personEntity.setBalance(personEntity.getBalance() + amount);
        personRepository.save(personEntity);
        personVo = personConverter.mapEntityToVo(personEntity);
        transactionService.save(TransactionVo
                .builder()
                .fromNumber(mobileNumber)
                .amount(amount)
                .build());
        return personVo;
    }

    @Override
    public PersonVo withdrawMoneyFromWallet(float amount, long mobileNumber) throws Exception {
        PersonVo personVo = getByMobileNumber(mobileNumber);
        PersonEntity personEntity = personConverter.mapVoToEntity(personVo);
        if (personEntity.getBalance() >= amount) {
            personEntity.setBalance(personEntity.getBalance() - amount);
            personRepository.save(personEntity);
            personVo = personConverter.mapEntityToVo(personEntity);
            transactionService.save(TransactionVo.builder()
                    .fromNumber(mobileNumber)
                    .amount(amount)
                    .build());
            return personVo;
        }
        throw new Exception("Insufficient Funds.");
    }

    @Override
    public PersonVo transfer(float amount, long sender, long receiver) throws Exception {
        PersonVo personSenderVo = getByMobileNumber(sender);
        PersonEntity personSenderEntity = personConverter.mapVoToEntity(personSenderVo);
        if (personSenderEntity.getBalance() >= amount) {
            personSenderEntity.setBalance(personSenderEntity.getBalance() - amount);
            PersonVo personReceiverVo = getByMobileNumber(receiver);
            PersonEntity personReceiverEntity = personConverter.mapVoToEntity(personReceiverVo);
            personReceiverEntity.setBalance(personReceiverEntity.getBalance() + amount);
            personRepository.save(personSenderEntity);
            personRepository.save(personReceiverEntity);
            transactionService.save(TransactionVo.builder()
                    .fromNumber(sender)
                    .toNumber(receiver)
                    .amount(amount)
                    .build());
            return personSenderVo;
        }
        throw new Exception("Insufficient Funds.");
    }


}
