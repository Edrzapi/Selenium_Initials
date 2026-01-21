import org.junit.*;

public class IntroductionToJunitFourTest {

    @BeforeClass
    public static void beforeclass() {
        System.out.println(" before all ");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println(" after all ");
    }

    @Before
    public void beforeEach() {
        System.out.println(" before each ");
    }

    @After
    public void afterEach() {
        System.out.println(" after each ");
    }

    @Test
    public void testOne() {
        System.out.println(" in testOne ");
        Assert.assertTrue(true);
    }

    @Test
    public void testTwo() {
        System.out.println(" in testTwo ");
        Assert.assertEquals(2, 1 + 1);
    }
}

