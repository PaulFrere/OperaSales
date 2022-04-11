package repository;

import dto.User;

public interface UserRepo {
    User findByLogin(String login);
}
