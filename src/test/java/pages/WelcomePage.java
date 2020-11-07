package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.base.SeleniumUtils;
import test.pageBase.PageBase;

@Component
public class WelcomePage extends PageBase {

    @FindBy(name = "q")
    public WebElement fldSearch;

    @FindBy(name = "btnK")
    public WebElement btnSearch;

    @Autowired
    public WelcomePage(SeleniumUtils seleniumUtils){
        super(seleniumUtils.getDriver());
    }
}
