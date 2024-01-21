package com.eteration.simplebanking.services;


import com.eteration.simplebanking.domain.entity.BankAccount;
import com.eteration.simplebanking.domain.repository.BankAccountRepository;
import com.eteration.simplebanking.domain.repository.TransactionRepository;
import com.eteration.simplebanking.exception.NotFoundException;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.model.request.AmountRequest;
import com.eteration.simplebanking.model.response.BankAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class AccountService {

    private final  BankAccountRepository bankAccountRepository;

    private final TransactionRepository transactionRepository;

    public BankAccountResponse getDebit(String accountNumber, AmountRequest amountRequest){
        var account = bankAccountRepository.findBankAccountByAccountNumber(accountNumber)
                .orElseThrow(()->new NotFoundException("Not found account"));
        var withdrawalTransaction = new WithdrawalTransaction(amountRequest.getAmount());
        var balance = processTransaction(withdrawalTransaction, account.getBalance());
        account.setBalance(balance);
        bankAccountRepository.save(account);
        var transaction = com.eteration.simplebanking.domain.entity.Transaction.builder()
                .account(account)
                .amount(balance)
                .type(withdrawalTransaction.getTransactionType())
                .date(new Date())
                .build();
        transactionRepository.save(transaction);

        return  BankAccountResponse.builder()
                .approvalCode(UUID.randomUUID())
                .build();

    }

    public BankAccountResponse getCredit(String accountNumber, AmountRequest amountRequest){
        var account = bankAccountRepository.findBankAccountByAccountNumber(accountNumber)
                .orElseThrow(()->new NotFoundException("Not found account"));
        var depositTransaction = new DepositTransaction(amountRequest.getAmount());
        var balance = processTransaction(depositTransaction, account.getBalance());
        account.setBalance(balance);
        bankAccountRepository.save(account);
        var transaction = com.eteration.simplebanking.domain.entity.Transaction.builder()
                .account(account)
                .type(depositTransaction.getTransactionType())
                .amount(balance)
                .date(new Date())
                .build();
        transactionRepository.save(transaction);

        return  BankAccountResponse.builder()
                .approvalCode(UUID.randomUUID())
                .build();

    }


    public Double processTransaction(Transaction transaction, Double balance) {
        if (transaction instanceof DepositTransaction) {
            var deposit = (DepositTransaction) transaction;
            balance += deposit.getAmount();
        } else if (transaction instanceof WithdrawalTransaction) {
            var withdrawal = (WithdrawalTransaction) transaction;
            balance -= withdrawal.getAmount();
        }
        return balance;
        }

        public BankAccount getAccount(String account){
        return bankAccountRepository.findBankAccountByAccountNumber(account)
                .orElseThrow(()->new NotFoundException("Not found account"));
    }

}
