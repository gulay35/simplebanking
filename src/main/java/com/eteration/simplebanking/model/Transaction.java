package com.eteration.simplebanking.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Transaction {

    private double amount;
    public abstract String getTransactionType();
}
