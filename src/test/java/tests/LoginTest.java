package tests;

import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.DashboardPage;
import data.DataHelper;

public class LoginTest {

    private static final String BASE_URL = "http://localhost:9999";

    @Test
    void shouldLoginSuccessfully() {
        // Открываем страницу логина
        LoginPage loginPage = new LoginPage(BASE_URL);

        var authInfo = DataHelper.getAuthInfo();

        // Валидный логин
        loginPage.validLogin(authInfo.getLogin(), authInfo.getPassword());

        // Проверка что главная страница (Dashboard) видна
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.dashboardVisible();
    }

    @Test
    void shouldShowErrorForInvalidLogin() {
        LoginPage loginPage = new LoginPage(BASE_URL);

        // Неверный пароль
        loginPage.invalidLogin("vasya", "wrongpassword");
    }
}