package com.eteration.simplebanking.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Builder
@Data
public class DepositTransaction  extends Transaction {

    public DepositTransaction(double amount) {
        super(amount);

    }
    @Override
    public String getTransactionType() {
        return "Deposit";
    }

}
