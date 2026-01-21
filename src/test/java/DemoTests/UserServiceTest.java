package DemoTests;

import org.junit.jupiter.api.Test;
import uk.co.devfoundry.domain.User;
import uk.co.devfoundry.repo.UserRepository;
import uk.co.devfoundry.service.FileService;
import uk.co.devfoundry.service.UserService;
import uk.co.devfoundry.util.StubUserRepository;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    void displayName_usesStubbedDatabase() {
        UserRepository stubDb = new StubUserRepository(Map.of(
            1, new User(1, "Alice"),
            2, new User(2, "Bob")
        ));

        UserService service = new UserService(stubDb);

        assertEquals("ALICE", service.displayName(1));
        assertEquals("Unknown", service.displayName(99));
    }



}
