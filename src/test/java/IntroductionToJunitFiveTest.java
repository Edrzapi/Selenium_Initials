import org.junit.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class IntroductionToJunitFiveTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all ");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each ");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

    @Test
    void testOne() {
        System.out.println("in testOne");
        Assertions.assertTrue(true);
    }

    @Test
    void testTwo() {
        System.out.println("in testTwo");
        Assertions.assertEquals(2, 1 + 1);
    }
}
