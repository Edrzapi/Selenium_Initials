package uk.co.devfoundry.service;

import uk.co.devfoundry.domain.User;
import uk.co.devfoundry.repo.UserRepository;

public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String displayName(int id) {
        User u = repo.findById(id);
        if (u == null) return "Unknown";
        return u.name().toUpperCase();
    }
}
