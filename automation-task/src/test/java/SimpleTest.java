import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class SimpleTest {

    @BeforeClass
    public void setUp() {

    }

    //@Test(groups = {"fast"}) - places the test in the fast group, which can be defined separately
    //@Test(priority = 1) - defines test priority (default = 0) and can change the test execution order
    //@Test(enabled = false) - disables the test, so it will not be executed

    @Test(priority = 1)
    public void aFastTest() {
        System.out.println("Fast Test");
    }

    @Test(priority = 0)
    public void aSlowTest() {
        System.out.println("Slow Test");
    }

}
