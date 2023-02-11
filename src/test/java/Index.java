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
        WebElement item1 = wd.findElement(By.cssSelector("a[href='#item1']"));
        item1.click();
        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        String text = alert.getText();
        System.out.println("Text of container -->" +text);
        Assert.assertTrue(text.contains("Clicked by Item 1"));
        Assert.assertEquals(text,"Clicked by Item 1");

        // find Item3 & click() ===> assert that "div-alert" contains message  "Clicked by Item 3"
        //WebElement item3 = wd.findElement(By.xpath("//li[3]"));
        //item3.click();
        //String item3Text = item3.getText(); /// Item 3
        //message = container.getText(); // Clicked by Item 3
        //Assert.assertTrue(message.contains(item3Text));



        WebElement item3 = wd.findElement(By.cssSelector("a[href='#item3']"));
        item3.click();
        WebElement alert1= wd.findElement(By.cssSelector("#alert"));
        String text1 = alert1.getText();
        Assert.assertTrue(text1.contains("Clicked by Item 3"));
    }
    @Test
    public void formTests(){
        // fill name & fill surename & click send
        // Assert that "div-alert" contains text with name + surename
        WebElement name = wd.findElement(By.cssSelector("input[name='name']"));
        name.click();
        name.clear();
        name.sendKeys("Marina");
        // fill name & fill surename & click send
        WebElement surname = wd.findElement(By.cssSelector("input[placeholder='Type your surename']"));
        surname.click();
        surname.clear();
        surname.sendKeys("Shamos");
        // Assert that "div-alert" contains text with name + surename
        WebElement button = wd.findElement(By.cssSelector("button[class='btn']"));
        button.click();
        WebElement alert3= wd.findElement(By.cssSelector("#alert"));
        String text3 = alert3.getText();
        Assert.assertTrue(text3.contains("Marina Shamos"));
    }
    @Test
    public void formTests1(){
        // fill name & fill surename & click send
        WebElement name = wd.findElement(By.xpath("//input[1]"));
        name.click();
        name.clear();
        name.sendKeys("??????");

        String inputText = name.getAttribute("value");
        System.out.println("!!!! " +inputText);
        WebElement sureName = wd.findElement(By.xpath("//input[2]"));
        sureName.click();
        sureName.clear();
        sureName.sendKeys("First");

        wd.findElement(By.xpath("//button")).click();
        // Assert that "div-alert" contains text with name + surename
        WebElement container = wd.findElement(By.cssSelector("#alert"));
        String message = container.getText();
        //  Assert.assertEquals(message,"?????? First");
        Assert.assertTrue(message.contains(inputText));

    }
    @Test
    public void tableTest(){
        // check in table are 4 rows
        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));// actual result
        wd.findElement(By.xpath("//tr"));//xpath
        Assert.assertEquals(rows.size(),4);


        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        String text = lastRow.getText();
        System.out.println(text);

        Assert.assertTrue(text.contains("Mexico"));

        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        String str = lastCell.getText();

        boolean res = str.contains("Mexico");
        Assert.assertTrue(str.contains("Mexico"));
        //Assert.assertTrue(res);

        //print Maria Anders
        System.out.println(wd.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")));
        wd.findElement(By.xpath("//tr[2]//td[2]")); //xpath
        wd.findElement(By.xpath("//td[text() = 'Maria Anderson']")); //xpath
    }
}
