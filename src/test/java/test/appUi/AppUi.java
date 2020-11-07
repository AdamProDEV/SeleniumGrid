package test.appUi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pages.WelcomePage;

@Component
public class AppUi {

    @Autowired
    public WelcomePage welcomePage;
}
