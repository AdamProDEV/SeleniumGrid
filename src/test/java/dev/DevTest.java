package dev;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.artsok.RepeatedIfExceptionsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

@ExtendWith(TimingExtension.class)
public class DevTest {

    static ExtentReports extent = new ExtentReports();
    static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    static ExtentTest extentTest;

    @BeforeAll
    public static void beforeAll() {
        extent.attachReporter(spark);
    }

    @AfterAll
    public static void afterAll() {
        extent.flush();
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {

        extentTest = extent.createTest(testInfo.getDisplayName());
    }


    @RepeatedIfExceptionsTest(repeats = 3)
    @DisplayName("ReTest name thread 1")
    public void reTestT1() {
        System.out.println("Thread id: " + Thread.currentThread().getId());
        System.out.println("My test fails reTest 1");
        extentTest.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
        Assertions.assertTrue(true, "This test fail");
    }

    @RepeatedIfExceptionsTest(repeats = 3)
    @DisplayName("ReTest name thread 2")
    public void reTestT2() {
        System.out.println("Thread id: " + Thread.currentThread().getId());
        System.out.println("My test fails reTest 2");
        extentTest.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
        Assertions.assertTrue(true, "This test fail");
    }

//    @Test
    @DisplayName("Display name")
    public void testGenericPass() {
        System.out.println("test");
        extentTest.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
    }

//    @Test
    @DisplayName("Display name")
    public void testGenericFail() {
        System.out.println("test");
        extentTest.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
        Assertions.fail("Some problems in test");
    }
}

class TimingExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {

        boolean testFail = extensionContext.getExecutionException().isPresent();
        if (!testFail) {
            DevTest.extentTest.log(Status.PASS, "TEST PASS, good for you");
        } else {
            DevTest.extentTest.log(Status.FAIL, extensionContext.getExecutionException().get().getMessage());
            DevTest.extentTest.log(Status.FAIL, "TEST FAIL, need to fix");
        }
        if (DevTest.extentTest.getStatus().equals(Status.FAIL) && !extensionContext.getDisplayName().contains("3 of 3"))
            DevTest.extent.removeTest(DevTest.extentTest);
    }
}
