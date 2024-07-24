package stepDefinitions.anaSayfa;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.Driver;
import utilities.ReusableMethods;
import pages.anaSayfa.boltAnaSayfa;


public class boltChatAi {



    ReusableMethods reusableMethods = new ReusableMethods();
    boltAnaSayfa boltAnaSayfa= new boltAnaSayfa();



    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        reusableMethods.goToUrl("url");


    }
    @Given("BolchatAi butonunun goruntulendigini dogrular")
    public void bolchat_ai_butonunun_goruntulendigini_dogrular() {

        Assert.assertTrue(boltAnaSayfa.boltChatAiButton.isDisplayed());
    }

        @Given("Sayfa kapatilir")
        public void sayfa_kapatilir() {

                Driver.closeDriver();
                ReusableMethods.bekle(1);

        }
    @Given("BolchatAi butonuna tiklar")
    public void bolchat_ai_butonuna_tiklar() {
      boltAnaSayfa.boltChatAiButton.click();


    }
    @Given("BolChatAi sayfasina yonlendirildigini dogrular")
    public void bol_chat_ai_sayfasina_yonlendirildigini_dogrular() {
     Assert.assertTrue(boltAnaSayfa.boltChatAiLogo.isDisplayed());

    }


    }



