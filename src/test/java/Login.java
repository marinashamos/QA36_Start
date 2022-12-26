import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Login {

    WebDriver wd;
    @BeforeMethod
    private void preCondition(){
        // open browser
        wd = new ChromeDriver();
        // open site
        wd.get("https://telranedu.web.app");
    }
    @Test
    public void findElementsOnPage() {
        // by tagName
        WebElement element = wd.findElement(By.tagName("div"));
        List<WebElement> divs = wd.findElements(By.tagName("div"));

        // By id
        WebElement el1 = wd.findElement(By.id("root"));
        // By class
        WebElement el2 = wd.findElement(By.className("container"));
        // By name
        //wd.findElement(By.name("name"));

        // By link text a href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));

    }

    @Test
    public void loginSuccess(){

        // open form
        // wd find item + click

      WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
       itemLogin.click();

        // fill form
        // find email + click + clear + type
        WebElement email = wd.findElement(By.name("email"));
       email.click();
        email.clear();
       email.sendKeys("dsa+1@gmail.com");

        // find password + click +clear + type
        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();password.sendKeys("Qq12345$");

        // submit  form
        // find button login + click
        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        WebElement buttonLogin = buttons.get(0);
        buttonLogin.click();


        // open form
        // wd find button + click
        // fill form
        // find email + click + type
        // submit form
        // find button login + click
        Assert.assertEquals("","");
        // ac == exp
    }

    @Test
    public void registrationSuccess(){

       WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
       itemLogin.click();

        // fill form
        // find email + click + clear + type
     //   WebElement email = wd.findElement(By.name("email"));
      //  email.click();
      // email.clear();
       // email.sendKeys("dsa+9@gmail.com");

        // find password + click +clear + type
       // WebElement password = wd.findElement(By.name("password"));
       // password.click();
      //  password.clear();
      //  password.sendKeys("Qq123456$");

        // submit  form
        // find button login + click
      //  List<WebElement> buttons = wd.findElements(By.tagName("button"));
      //  WebElement buttonRegistration = buttons.get(1);
      // buttonRegistration.click();

    }
    @Test
    public void ccslocatrtest() {

        wd.findElement(By.linkText("LOGIN")).click();

        // теперь мы на странице логина и тут будем тренироваться
        // На странице логин найти несколько элементов по их  tagname
        WebElement div = wd.findElement(By.tagName("div"));
        List<WebElement> divs = wd.findElements(By.tagName("div"));

        WebElement input = wd.findElement(By.tagName("input"));
        List<WebElement> inputs = wd.findElements(By.tagName("input"));

        WebElement button = wd.findElement(By.tagName("button"));
        List<WebElement> buttons = wd.findElements(By.tagName("button"));

        WebElement el1c =wd.findElement(By.cssSelector("#root"));

        WebElement el2c =wd.findElement(By.cssSelector(".container"));
        WebElement el3c =wd.findElement(By.cssSelector(".navbar-component_nav__1X_4m"));
        WebElement el4c =wd.findElement(By.cssSelector(".active"));
        WebElement el5c =wd.findElement(By.cssSelector(".login_login__3EHKB"));
        // ON Login PAGE find some elements by class

        // На странице логин найти несколько элементов по их  attribute
        WebElement el6c =wd.findElement(By.cssSelector("[placeholder = 'Email']"));
        WebElement el7c =wd.findElement(By.cssSelector("[placeholder = 'Password']"));

        //На странице логин найти  элемент с  атрибутом placeholder, значение которого начинается на "Pass"
        WebElement el8c =wd.findElement(By.cssSelector("[placeholder ^= 'Pass']"));//starts
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого  начинается на  "ass"
        WebElement el9c =wd.findElement(By.cssSelector("[placeholder *= 'ass']"));//contains
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого заканчивается на "ord"
        WebElement el10c =wd.findElement(By.cssSelector("[placeholder $= 'ord']"));//ends

        // Объединение !!
        //найти элемент div, у которого есть id со значением "root"  и класс со значением container
        WebElement el11c =wd.findElement(By.cssSelector("[id ='root']"));
        WebElement el12c =wd.findElement(By.cssSelector("[class= 'container']"));
        WebElement el13c =wd.findElement(By.cssSelector("div#root.container"));

        // найти элемент а, у которого есть атрибут href со значением /login
        WebElement el14c =wd.findElement(By.cssSelector("a[href = '/login']"));

        // найти элемент input, у которого есть атрибут name cо значением email
        WebElement el15c =wd.findElement(By.cssSelector("input[name = 'email']"));

        // найти элемент button, у которого есть атрибут name cо значением login
        WebElement el16c =wd.findElement(By.cssSelector("button[name ='login']"));

        // Поиск по дочерним элементам (* задание со звездоской)
        // Найти кнопку регистрации, как последнего ребенка элемента form

        WebElement el17c =wd.findElement(By.cssSelector("form *:last-child"));//Выполнила по аналогии в презентации, недостаточно понимания

    }
        @BeforeMethod
    public void postCondition(){
        // close browser
        //wd.quit();
    }
}
