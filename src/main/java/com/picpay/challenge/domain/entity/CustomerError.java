package com.picpay.challenge.domain.entity;

import java.time.LocalDateTime;

public record CustomerError(LocalDateTime date, Integer statusCode, String path, String message) {
}
