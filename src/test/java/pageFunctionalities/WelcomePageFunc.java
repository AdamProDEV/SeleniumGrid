package pageFunctionalities;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import test.appContext.AppContext;

@Component
public class WelcomePageFunc extends AppContext {

    @Test
    public void searchSome(){

        seleniumUtils.openUrl("https://google.com");
        try {
            Thread.sleep(5000);

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        seleniumUtils.setTextInElement("test", appUi.welcomePage.fldSearch);
        seleniumUtils.clickOnElement(appUi.welcomePage.btnSearch);
    }

    @Test
    public void searchSome1(){

        seleniumUtils.openUrl("https://google.com");
        seleniumUtils.setTextInElement("test", appUi.welcomePage.fldSearch);
        try {
            Thread.sleep(5000);

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        seleniumUtils.clickOnElement(appUi.welcomePage.btnSearch);
    }
}
