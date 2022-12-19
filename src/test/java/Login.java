import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

    WebDriver wd;
    @BeforeMethod
    private void preCondition(){
        // open browser
        wd = new ChromeDriver();
        // open site
        wd.get("https://telranedu.web.app/");
    }
    @Test
    public void loginSuccess(){
        // open form
        // wd find button + click
        // fill form
        // find email + click + type
        // submit form
        // find button login + click
        Assert.assertEquals("","");
        // ac == exp
    }
    @BeforeMethod
    public void postCondition(){
        // close browser
        wd.quit();
    }
}
