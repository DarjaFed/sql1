package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement dashboardTitle =
            $("[data-test-id=dashboard]");

    public void checkDashboardVisible() {
        dashboardTitle.shouldBe(com.codeborne.selenide.Condition.visible)
                .shouldHave(com.codeborne.selenide.Condition.text("Личный кабинет"));
    }
}