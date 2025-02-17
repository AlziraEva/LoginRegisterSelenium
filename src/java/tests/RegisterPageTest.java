package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;

public class RegisterPageTest {
    private RegisterPage registerPage;
    private String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

    @BeforeEach
    void setUp() throws Exception {
        this.registerPage = new RegisterPage();
        this.registerPage.visit(URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.registerPage.quitWebDriver();
    }

    @Test
    void test(){
        // when
        this.registerPage.insertEmailToRegister();

        //the
        String expected = this.registerPage.getEmailGenerate();
        String actual = this.registerPage.getEmailNewAccount();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2(){
        //when
        this.registerPage.fillOutForm();

        //then
        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String actual = this.registerPage.getWelcomeMessage();
        Assertions.assertEquals(expected, actual);

        Assertions.assertFalse(this.URL.equals(this.registerPage.getCurremtUrl()));
    }
}
