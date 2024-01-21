package com.eteration.simplebanking.domain.entity;

import com.eteration.simplebanking.enums.BillPayment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Table(name="pay")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pay  extends BaseEntity<Long> implements Serializable{

    @Serial
    private static final long serialVersionUID = -3394316528095418134L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name= "amount")
    private Double amount;

    @Column(name= "bill_payment")
    private BillPayment billPayment;

    @Column(name= "payee")
    private String payee;

}
