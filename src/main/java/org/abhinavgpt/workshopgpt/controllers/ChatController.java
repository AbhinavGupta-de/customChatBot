package org.abhinavgpt.workshopgpt.controllers;

import org.abhinavgpt.workshopgpt.services.IChatService;
import org.abhinavgpt.workshopgpt.services.savechat.ISaveChatService;
import org.abhinavgpt.workshopgpt.services.user.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ChatController {

    private final IChatService chatService;
    private final ISaveChatService saveChatService;
    private final IUserService userService;

    public ChatController(IChatService chatService, ISaveChatService saveChatService, IUserService userService) {
        this.chatService = chatService;
        this.saveChatService = saveChatService;
        this.userService = userService;
    }

    @GetMapping("/startChat")
    public long startChat() {
        return saveChatService.startChat();
    }

    @GetMapping("/createUser")
    public long createUser(@RequestParam String name) {
        return userService.createUser(name);
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatDTO chatDTO) throws Exception {
        return chatService.chat(chatDTO.message(), chatDTO.userId(), chatDTO.chatId());
    }
}
