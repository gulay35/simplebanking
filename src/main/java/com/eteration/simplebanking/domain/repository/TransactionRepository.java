package com.eteration.simplebanking.domain.repository;

import com.eteration.simplebanking.domain.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
