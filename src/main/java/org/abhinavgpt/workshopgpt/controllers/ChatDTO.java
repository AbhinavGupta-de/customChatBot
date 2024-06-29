package org.abhinavgpt.workshopgpt.controllers;

public record ChatDTO(
        String message,
        long userId,
        long chatId
) {
}
