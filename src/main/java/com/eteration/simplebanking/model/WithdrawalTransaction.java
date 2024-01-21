package com.eteration.simplebanking.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    @Override
    public String getTransactionType() {
        return "Withdrawal";
    }

}


