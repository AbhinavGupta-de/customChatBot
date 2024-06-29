package org.abhinavgpt.workshopgpt.services;

import org.abhinavgpt.workshopgpt.services.chatstatus.IChatStatusService;
import org.abhinavgpt.workshopgpt.services.gpt.IGptService;
import org.abhinavgpt.workshopgpt.services.savechat.ISaveChatService;
import org.abhinavgpt.workshopgpt.services.user.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
final class ChatService implements IChatService{

    private final IChatStatusService chatStatusService;
    private final ISaveChatService saveChatService;
    private final IUserService userService;
    private final IGptService gptService;

    public ChatService(IChatStatusService chatStatusService, ISaveChatService saveChatService, IUserService userService, IGptService gptService) {
        this.chatStatusService = chatStatusService;
        this.saveChatService = saveChatService;
        this.userService = userService;
        this.gptService = gptService;
    }

    @Override
    public String chat(String message, long userId, long chatId) throws Exception {
//            check if the chat exists or not
        if(!chatStatusService.chatExists(chatId)) throw new Exception("No chat exists with the following id.");
//            check if the user exists or not... no need for now
//        userService.getUser(userId);

//        store the message in the chat
        saveChatService.saveChat(message, chatId, userId);

//        get the chat for context and call the gpt service
        List<String> context = saveChatService.getChat(chatId);

        return gptService.getResponse(context);

    }

}
