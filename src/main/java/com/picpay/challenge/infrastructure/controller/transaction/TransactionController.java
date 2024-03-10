package com.picpay.challenge.infrastructure.controller.transaction;

import com.picpay.challenge.application.usecase.TransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionUseCase transactionUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void payment(@RequestBody TransactionRequest request) {
        this.transactionUseCase.execute(request.value(), request.payer(), request.payee());
    }
}
