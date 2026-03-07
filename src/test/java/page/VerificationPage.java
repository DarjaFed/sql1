package page;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    public void verifyCode(String code) {

        $("[data-test-id=code] input").setValue(code);
        $("[data-test-id=action-verify]").click();
    }
}