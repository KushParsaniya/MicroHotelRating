package dev.kush.userservice.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorDetail(String message, HttpStatus status, LocalDateTime timeStamp) {
}
