package com.shivam.springBoot.person;

import com.shivam.springBoot.controller.BaseController;
import com.shivam.springBoot.transactions.ITransactionService;
import com.shivam.springBoot.transactions.TransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController extends BaseController<PersonEntity, PersonVo> {

    private IPersonService iPersonService;

    public PersonController(IPersonService iPersonService) {
        super(iPersonService);
        this.iPersonService = iPersonService;
    }

    @GetMapping(value = "/mobile/{mobileNumber}", consumes = "application/json", produces = "application/json")
    public PersonVo findByNumber(@PathVariable("mobileNumber") long mobileNumber) {
        return iPersonService.getByMobileNumber(mobileNumber);
    }

    @PutMapping(value = "/addMoney", produces = "application/json")
    public PersonVo addMoneyToWallet(@RequestParam float amount, @RequestParam long mobileNumber) {
        return iPersonService.addMoneyToWallet(amount, mobileNumber);
    }

    @PutMapping(value = "/withdrawMoney", produces = "application/json")
    public PersonVo removeMoneyFromWallet(@RequestParam float amount, @RequestParam long mobileNumber) throws Exception {
        return iPersonService.withdrawMoneyFromWallet(amount, mobileNumber);
    }

    @PutMapping(value = "/transfer")
    public PersonVo transfer(@RequestParam float amount, @RequestParam long sender, @RequestParam long receiver) throws Exception {
        return iPersonService.transfer(amount, sender, receiver);
    }

}
