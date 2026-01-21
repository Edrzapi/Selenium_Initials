package uk.co.devfoundry.util;

import uk.co.devfoundry.domain.User;
import uk.co.devfoundry.repo.UserRepository;

import java.util.Map;

public class StubUserRepository implements UserRepository {
    private final Map<Integer, User> users;

    public StubUserRepository(Map<Integer, User> users) {
        this.users = users;
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }
}
