package test.regression;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import test.appContext.AppContext;

@SpringBootTest
public class Regression extends AppContext {

    @Test
    public void searchTest(){

        welcomePageFunc.searchSome();
    }


}
