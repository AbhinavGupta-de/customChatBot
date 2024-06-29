package org.abhinavgpt.workshopgpt.services.savechat;

import java.util.List;

public interface ISaveChatService {
    public long startChat();
    public void saveChat(String chat, long chatId, long userId) throws Exception;
    public List<String> getChat(long chatId);
}
