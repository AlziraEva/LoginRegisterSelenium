package pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    //Locators
    private By emailAdressLocator = By.id("email_create");
    private By submitBtnLocator = By.id("SubmitCreate");
    private By emailLocator = By.id("email");
    private By alertAdditionalInformationLocator = By.xpath("//*[@id=\"account-creation_form\"]/div[2]/p/span");
    // Locators - registro
    private By idGender1 = By.id("id_gender1");
    private By idGender2 = By.id("id_gender2");
    private By customerFirstname = By.id("customer_firstname");
    private By customerLastname = By.id("customer_lastname");
    private By passwd = By.id("passwd");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By newsletter= By.id("newsletter");
    private By accountCreationForm = By.id("account-creation_form");
    private By submitAccount = By.id("submitAccount");
    private By welcome = By.cssSelector("#center_column > p.info-account");

    //gerador de email
    public static String generateRandomEmail() {
        long timestamp = System.currentTimeMillis();
        return "testuser" + timestamp + "@example.com";
    }
    private static String emailRandom = generateRandomEmail();
    public String getEmailGenerate(){
        return emailRandom;
    }

    public void insertEmailToRegister(){
        if(super.isDisplayed(emailAdressLocator)){
            type(emailRandom, emailAdressLocator);
            click(submitBtnLocator);
        } else {
            System.out.println("email textbox was not present");
        }
    }

    public String getEmailNewAccount(){
        super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
        return super.getTextByAttribute(this.emailLocator, "value");
    }

    public void fillOutForm(){
        this.insertEmailToRegister();
        super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
        if(super.isDisplayed(idGender1)){
            super.click(idGender2);
            super.type("teste", customerFirstname);
            super.type("qa", customerLastname);
            super.type("123456", passwd);
            super.selectByValue(days, "12");
            super.selectByValue(months,"2");
            super.selectByValue(years,"2000");
            super.click(newsletter);
            super.click(submitAccount);
        } else{
            System.out.println("message was not found");
        }
    }

    public String getWelcomeMessage(){
        super.waitVisibilityOfElementLocated(welcome);
        return super.getText(welcome);
    }
}
