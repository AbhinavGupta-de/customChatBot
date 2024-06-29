package org.abhinavgpt.workshopgpt.services.user;

import org.abhinavgpt.workshopgpt.models.User;

public interface IUserService {
    public long createUser(String name);
    public User getUser(long userId) throws Exception;
}
