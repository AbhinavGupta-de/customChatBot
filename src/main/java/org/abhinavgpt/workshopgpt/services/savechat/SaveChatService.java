package org.abhinavgpt.workshopgpt.services.savechat;

import org.abhinavgpt.workshopgpt.models.Chat;
import org.abhinavgpt.workshopgpt.models.ChatStatus;
import org.abhinavgpt.workshopgpt.models.Status;
import org.abhinavgpt.workshopgpt.models.User;
import org.abhinavgpt.workshopgpt.repository.ChatRepository;
import org.abhinavgpt.workshopgpt.repository.ChatStatusRepository;
import org.abhinavgpt.workshopgpt.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaveChatService implements ISaveChatService {

    private final ChatStatusRepository chatStatusRepository;
    private final ChatRepository chatRepository;

    public SaveChatService(ChatStatusRepository chatStatusRepository, ChatRepository chatRepository) {
        this.chatStatusRepository = chatStatusRepository;
        this.chatRepository = chatRepository;
    }

    @Override
    public long startChat() {
        ChatStatus chatStatus = new ChatStatus(Status.ONGOING);
        return chatStatusRepository.save(chatStatus).getChatId();
    }

    @Override
    public void saveChat(String message, long chatId, long userId) throws Exception {
        Chat chat = new Chat(chatId, message, userId);
        chatRepository.save(chat);
    }

    @Override
    public List<String> getChat(long chatIds) {
        List<Chat> chats = chatRepository.findAllById(Collections.singleton(chatIds));
        return chats.stream()
                .map(Chat::getMessage)
                .collect(Collectors.toList());
    }
}
