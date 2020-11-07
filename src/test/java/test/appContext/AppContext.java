package test.appContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import pageFunctionalities.WelcomePageFunc;
import test.appUtils.AppUtils;

@ContextConfiguration(classes = {

        WelcomePageFunc.class
})
@Component
public class AppContext extends AppUtils  {

    @Autowired
    protected WelcomePageFunc welcomePageFunc;
}
