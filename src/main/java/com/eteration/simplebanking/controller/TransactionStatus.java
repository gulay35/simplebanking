package com.eteration.simplebanking.controller;


// This class is a place holder you can change the complete implementation

import com.eteration.simplebanking.model.request.AmountRequest;
import com.eteration.simplebanking.model.request.PhonePayRequest;
import com.eteration.simplebanking.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "payment/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionStatus {
     private final TransactionService transactionService;

    @PostMapping(value="payee/{account-number}")
    public ResponseEntity<Object> payee(@Valid @RequestBody PhonePayRequest phonePayRequest){
        var response = transactionService.pay(phonePayRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
