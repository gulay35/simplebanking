package com.eteration.simplebanking.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name="bankAccount")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BankAccount extends BaseEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = -2394316528095418134L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name="owner")
    private String owner;

    @Column(name="accountNumber")
    private String accountNumber;

    @Column(name="balance")
    private double balance;

}
