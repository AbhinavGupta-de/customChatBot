package org.abhinavgpt.workshopgpt.services.gpt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GptService implements IGptService {

    private final ChatClient chatClient;

    @Value("classpath:/prompts/basic_template.txt")
    private Resource basicPromptTemplateString;

    public GptService(ChatClient.Builder chatClientBuilder) {
        OpenAiChatOptions options = OpenAiChatOptions.builder().withFunction("hotelFunction").withFunction("hotelPrice").build();
        chatClientBuilder.defaultOptions(options);
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String getResponse(List<String> context) {
        PromptTemplate promptTemplate = new PromptTemplate(basicPromptTemplateString);
        Prompt prompt = promptTemplate.create(Map.of("context", context));
        return chatClient.prompt(prompt).call().content();
    }
}
