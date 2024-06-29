package org.abhinavgpt.workshopgpt.services.chatstatus;

import org.abhinavgpt.workshopgpt.models.ChatStatus;
import org.abhinavgpt.workshopgpt.repository.ChatStatusRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatStatusService implements IChatStatusService {

    private final ChatStatusRepository chatStatusRepository;

    public ChatStatusService(ChatStatusRepository chatStatusRepository) {
        this.chatStatusRepository = chatStatusRepository;
    }

    @Override
    public boolean chatExists(long chatId) {
        Optional<ChatStatus> chatStatus =  chatStatusRepository.findById(chatId);
        return chatStatus.isPresent();
    }
}
