package uk.co.devfoundry.repo;

import uk.co.devfoundry.domain.User;

public interface UserRepository {
    User findById(int id);
}


