package tests;

import data.DataHelper;
import db.DbUtils;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @Test
    void shouldLoginSuccessfully() throws Exception {

        open("http://localhost:9999");

        var authInfo = DataHelper.getAuthInfo();

        var loginPage = new LoginPage();

        var verifyPage =
                loginPage.login(
                        authInfo.getLogin(),
                        authInfo.getPassword()
                );

        var code =
                DbUtils.getVerificationCode(
                        authInfo.getLogin()
                );

        verifyPage.verifyCode(code);
    }
}