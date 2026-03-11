package page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {


    private static final String DASHBOARD_CONTAINER = ".App_appContainer__3jRx1";

    public void dashboardVisible() {
        $(DASHBOARD_CONTAINER).shouldBe(visible);
    }
}