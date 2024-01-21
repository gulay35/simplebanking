package com.eteration.simplebanking.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name="transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction extends BaseEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = -2394316528095418135L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name="date")
    private Date date;

    @Column(name="amount")
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private BankAccount account;

    @Column(name="type")
    private String type;


}
