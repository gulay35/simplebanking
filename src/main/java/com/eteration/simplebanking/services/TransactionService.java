package com.eteration.simplebanking.services;

import com.eteration.simplebanking.domain.entity.Pay;
import com.eteration.simplebanking.domain.repository.BankAccountRepository;
import com.eteration.simplebanking.domain.repository.PayRepository;
import com.eteration.simplebanking.domain.repository.TransactionRepository;
import com.eteration.simplebanking.enums.BillPayment;
import com.eteration.simplebanking.exception.NotFoundException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.model.request.PhonePayRequest;
import com.eteration.simplebanking.model.response.BankAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final BankAccountRepository bankAccountRepository;

    private final TransactionRepository transactionRepository;

    private final AccountService accountService;

    private final PayRepository payRepository;


    public BankAccountResponse pay(PhonePayRequest request){
        var account = bankAccountRepository.findBankAccountByAccountNumber(request.getAccountNumber())
                .orElseThrow(()->new NotFoundException("Not found account"));
        var withdrawaltransaction =  new WithdrawalTransaction(request.getAmount());
        var balance = accountService.processTransaction(withdrawaltransaction, account.getBalance());
        account.setBalance(balance);
        bankAccountRepository.save(account);
        var transaction = com.eteration.simplebanking.domain.entity.Transaction.builder()
                .account(account)
                .type(withdrawaltransaction.getTransactionType())
                .amount(balance)
                .date(new Date())
                .build();
        transactionRepository.save(transaction);
        var pay = Pay.builder()
                .amount(request.getAmount())
                .billPayment(BillPayment.PHONE)
                .payee("Vodafone")
                .build();

        payRepository.save(pay);

        return BankAccountResponse.builder()
                .approvalCode(UUID.randomUUID())
                .build();
    }
}
