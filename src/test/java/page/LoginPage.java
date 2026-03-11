package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {


    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");


    public LoginPage(String url) {
        open(url);

        $(".Login_loginForm__1Hg13").shouldBe(visible, Duration.ofSeconds(10));
    }

    // Валидный логин
    public void validLogin(String login, String password) {
        loginField.shouldBe(visible, Duration.ofSeconds(10)).setValue(login);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();

        errorNotification.shouldNot(visible, Duration.ofSeconds(5));
    }

    // Логин с неверными данными
    public void invalidLogin(String login, String password) {
        loginField.shouldBe(visible, Duration.ofSeconds(10)).setValue(login);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();

        errorNotification.shouldBe(visible, Duration.ofSeconds(5));
    }
}