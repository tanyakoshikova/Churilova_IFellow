package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {
    @Test
    void usersEmptyIfNoUserAdded() {
        UserService userService = new UserService();
        java.util.List<User> users = userService.getAll();
        assertTrue(users.isEmpty(), () -> "User list should be empty");
    }
}