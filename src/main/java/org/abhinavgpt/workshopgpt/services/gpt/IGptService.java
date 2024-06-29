package org.abhinavgpt.workshopgpt.services.gpt;

import java.util.List;

public interface IGptService {
    public String getResponse(List<String> context);
}
