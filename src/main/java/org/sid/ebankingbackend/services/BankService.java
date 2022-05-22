package org.sid.ebankingbackend.services;

import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.repositories.BankAccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRespository bankAccountRespository;
    public void consulter(){
        BankAccount bankAccount =
                bankAccountRespository.findById("3200a497-4b0d-4216-959d-cd8b11ec920c").orElse(null);
        if (bankAccount!=null){
            System.out.println("*****************************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreateAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount){
                System.out.println("Over Draft => "+((CurrentAccount)bankAccount).getOverDraft());
            } else if (bankAccount instanceof  SavingAccount) {
                System.out.println("Rate => "+((SavingAccount)bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperation().forEach(op -> {
                System.out.println(op.getType()+"\t"+op.getOperationDate()+"\t"+op.getAmount());
            });
        }

    }
}
