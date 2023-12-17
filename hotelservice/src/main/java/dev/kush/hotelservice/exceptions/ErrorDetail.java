package dev.kush.hotelservice.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorDetail(String message, HttpStatus status, LocalDateTime timeStamp) {
}
