package test.appUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import test.appUi.AppUi;
import test.base.TestBase;

@ComponentScan(basePackages = {
        "pages",
        "test.appUi"
})

public class AppUtils extends TestBase {

    @Autowired
    public AppUi appUi;


}
