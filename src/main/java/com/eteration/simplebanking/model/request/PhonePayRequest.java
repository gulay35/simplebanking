package com.eteration.simplebanking.model.request;

import com.eteration.simplebanking.enums.BillPayment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhonePayRequest {

      private String accountNumber;
      private Double amount;
      private String payee;
      private BillPayment billPayment;
}
