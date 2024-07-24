package pages.anaSayfa;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.bekle;
// locate'ler
public class boltAnaSayfa {
    public boltAnaSayfa () {
     PageFactory.initElements(Driver.getDriver(),this);


}

    @FindBy (xpath = "//div[@class='flex flex-col justify-center items-center gap-10 mb-5']")
    public WebElement boltChatAiButton;

    @FindBy (xpath = "(//*[@alt='bolt-logo-web'])[2]")
    public WebElement boltChatAiLogo;


}