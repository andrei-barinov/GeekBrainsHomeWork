
import org.testng.annotations.BeforeSuite;

public class TestManager {

    @AfterSuite
    private void finalizeMethod() {
        System.out.println("Unwinding after hard Test....");
    }

    @Test(priority = 9)
    private void fourthTestMethod() {
        System.out.println("It is the end of the Test, bye");
    }

    @Test(priority = 1)
    private void firstTestMethod() {
        System.out.println("Hello, let the Test begin");
    }

    @Test(priority = 5)
    private void secondTestMethod() {
        System.out.println("Test is running.... 30 minutes left");
    }

    @Test(priority = 5)
    private void thirdTestMethod() {
        System.out.println("Test is running.... 15 minutes left");
    }

    @BeforeSuite
    private void initializeMethod() {
        System.out.println("Stand by for Test....");
    }

    public void methodWithoutAnnotation() {
        System.out.println("I am sad, I don't have annotation");
    }
}
