package com.picpay.challenge.infrastructure.controller.transaction;

import java.math.BigDecimal;

public record TransactionRequest(BigDecimal value, Integer payer, Integer payee) {
}
