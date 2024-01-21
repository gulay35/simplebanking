package com.eteration.simplebanking.domain.repository;

import com.eteration.simplebanking.domain.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    Optional<BankAccount> findBankAccountByAccountNumber(String accountNumber);
}
