package org.abhinavgpt.workshopgpt.repository;

import org.abhinavgpt.workshopgpt.models.ChatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatStatusRepository extends JpaRepository<ChatStatus, Long> {

}
