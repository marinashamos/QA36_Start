import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Index {
    WebDriver wd;
    @BeforeMethod
    public void start(){
        wd = new ChromeDriver();
        wd.get("file:///C:/Users/Marina/Downloads/index.html");
        wd.manage().window().maximize();// nastroika okna max
    }
    @Test
    public void itemsTests(){
        // find Item1 & click() ===> assert that "div-alert" contains message  "Clicked by Item 1"
        // find Item3 & click() ===> assert that "div-alert" contains message  "Clicked by Item 3"
    }
    @Test
    public void formTests(){
        // fill name & fill surename & click send
        // Assert that "div-alert" contains text with name + surename
    }
    @Test
    private void tableTest(){

        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        Assert.assertEquals(rows.size(),4);


        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        String text = lastRow.getText();
        System.out.println(text);

        Assert.assertTrue(text.contains("Mexico"));

        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        String str = lastCell.getText();

        boolean res = str.contains("Mexico");
        Assert.assertTrue(str.contains("Mexico"));
        Assert.assertTrue(res);

    }
}
