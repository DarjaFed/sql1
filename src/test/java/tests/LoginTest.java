package tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import data.DataHelper;
import data.DbUtils;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @AfterAll
    static void cleanDB() throws Exception {
        DbUtils.cleanDatabase();
    }

    @Test
    void shouldLoginSuccessfully() throws Exception {

        open("http://localhost:9999");

        var authInfo = DataHelper.getAuthInfo();

        var loginPage = new LoginPage();

        var verificationPage =
                loginPage.validLogin(
                        authInfo.getLogin(),
                        authInfo.getPassword()
                );

        var code =
                DbUtils.getVerificationCode(
                        authInfo.getLogin()
                );

        var dashboardPage =
                verificationPage.verify(code);

        dashboardPage.dashboardVisible();
    }
}