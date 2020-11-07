package test.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {

                SeleniumUtils.class
        })
@Component
public class TestBase { //https://junit.org/junit5/docs/snapshot/user-guide/

    @Autowired
    public SeleniumUtils seleniumUtils;


    @BeforeEach
    public void beforeTest() {
        seleniumUtils.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }


//    @PreDestroy
    private void preDestroy(){
        System.out.println("destroying....");
        seleniumUtils.getDriver().quit();
    }

    @AfterEach
    public void afterTest() {

//        seleniumUtils.getDriver().quit();
    }

}
