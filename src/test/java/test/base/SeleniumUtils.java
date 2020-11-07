package test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {

                ChromeDriver.class
        })
@Component
public class SeleniumUtils {

    @Autowired
    private WebDriver driver;

    @Bean
    private WebDriver webDriver() {

        return new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickOnElement(WebElement element) {

        element.click();
    }

    public void setTextInElement(String text, WebElement element) {

        element.clear();
        element.sendKeys(text);
    }
}
