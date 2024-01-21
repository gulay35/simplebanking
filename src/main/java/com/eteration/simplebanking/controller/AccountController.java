package com.eteration.simplebanking.controller;


import com.eteration.simplebanking.model.request.AmountRequest;
import com.eteration.simplebanking.services.AccountService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "account/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private final AccountService accountService;

    @PostMapping(value="debit/{account-number}")
    public ResponseEntity<Object> debit(@PathVariable("account-number") String accountNumber,
                                        @Valid @RequestBody AmountRequest amountRequest){
        var response = accountService.getDebit(accountNumber, amountRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value="credit/{account-number}")
    public ResponseEntity<Object> credit(@PathVariable("account-number") String accountNumber,
                                        @Valid @RequestBody AmountRequest amountRequest){
        var response = accountService.getCredit(accountNumber, amountRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "credit/{account-number}")
    public ResponseEntity<Object> getAccount(@PathVariable("account-number") String accountNumber){
        var response = accountService.getAccount(accountNumber);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}