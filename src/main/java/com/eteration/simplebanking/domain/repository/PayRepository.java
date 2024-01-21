package com.eteration.simplebanking.domain.repository;


import com.eteration.simplebanking.domain.entity.Pay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends CrudRepository<Pay, Long> {


}
