package org.abhinavgpt.workshopgpt.services;

import org.springframework.stereotype.Service;

@Service
public interface IChatService {
    public String chat(String message, long userId, long chatId) throws Exception;
}
