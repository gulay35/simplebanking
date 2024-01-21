package com.eteration.simplebanking.domain.repository;

import com.eteration.simplebanking.domain.entity.BankAccount;
import com.eteration.simplebanking.domain.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepository extends CrudRepository<BaseEntity, Long> {
}
