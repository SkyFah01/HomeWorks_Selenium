package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomeWork2 {
    @Test
    public void Task_01(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualMessage = driver.getTitle().trim();
        String expectedMessage = "Web Orders Login";
        System.out.println(actualMessage.equals(expectedMessage)?"TRUE":"FALSE");

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders";
        System.out.println(actualTitle.equals(expectedTitle)? "TITLE PASSED":"TITLE FALSE");

        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader =header.getText().trim();
        String expectedHeader = "List of All Orders";
        System.out.println(actualHeader.equals(expectedHeader)? "HEADER PASSED" : "HEADER FALSE");


    }
    @Test
    public void Task_02() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?%E2%80%9D");


        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();
        Thread.sleep(2000);


        WebElement validateViewAllProducts= driver.findElement(By.xpath("//li[2]//a"));
        validateViewAllProducts.click();
        Thread.sleep(2000);
        validateViewAllProducts= driver.findElement(By.xpath("//li[2]//a"));
        String actualViewAllProducts= validateViewAllProducts.getText();
        String expectedViewAllProducts= "View all products";
        System.out.println(actualViewAllProducts.equals(expectedViewAllProducts)?"View All Products True":"View All Products False");


        WebElement header = driver.findElement(By.xpath("//div[@class='content']//h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader="List of Products";
        System.out.println(actualHeader.equals(expectedHeader)?"HEADER PASSED":"HEADER FALSE");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="Products";
        System.out.println(driver.getCurrentUrl().contains("Products")?"Url Passed" :"Url False");




    }
    @Test
    public void Task_03(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?%E2%80%9D");

        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        loginButton.click();

        //another way to contains the link
//        WebElement viewAllOrders = driver.findElement(By.xpath("//li//a[.='View all orders']"));
//        viewAllOrders.click();
//        System.out.println(driver.getCurrentUrl().contains("Default.aspx")?"Link All order is Passed":"Link All order is False");

        System.out.println("+++++find the link++++++");

        WebElement allOrder = driver.findElement(By.xpath("//a[.='View all orders']"));
        System.out.println("The link for View all orders >>" +" "+ allOrder.getAttribute("href"));

        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        System.out.println("The link for View all products >>" + " " + allProducts.getAttribute("href"));

        WebElement Orders= driver.findElement(By.xpath("//a[.='Order']"));
        System.out.println("The link for Orders >>" +" "+Orders.getAttribute("href"));


        //Validate their href values are equals to :
        List<WebElement> hrefValues = driver.findElements(By.xpath("//li//a[@href]"));

        for(int i=0;i<hrefValues.size();i++){
            if(hrefValues.get(i).getAttribute("href").contains("Default.aspx")){
                System.out.println("Default.aspx Pass");

            }else if(hrefValues.get(i).getAttribute("href").contains("Products.aspx")){
                System.out.println("Products.aspx Passed");

            }else if(hrefValues.get(i).getAttribute("href").contains("Process.aspx")){
                System.out.println("Process.aspx Passed");
            }



        }





    }
    @Test
    public void Task_04() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?%E2%80%9D");


        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passWord = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();


        WebElement orders = driver.findElement(By.xpath("//li[3]//a[@href]"));
        orders.click();
        WebElement product = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select productChoice = new Select(product);
        Thread.sleep(2000);
        productChoice.selectByValue("ScreenSaver");


        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        Thread.sleep(2000);
        quantity.sendKeys("5");


        WebElement customerName =driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");

        WebElement street =driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 devon");

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");

        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");

        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        if(masterCard.isDisplayed()&&masterCard.isEnabled()&&!masterCard.isSelected()){
            masterCard.click();
        }
        Thread.sleep(2000);

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");

        WebElement expirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        Thread.sleep(2000);

        WebElement processButton =driver.findElement(By.xpath("//a[.='Process']"));
        processButton.click();


        WebElement text = driver.findElement(By.tagName("strong"));
        String actualText = text.getText().trim();
        String expectedText = "New order has been successfully added.";
        System.out.println(actualText.equals(expectedText)?"PASSED": "FALSE");
        System.out.println(text.isDisplayed()?"Text isDisplayed":"Text not Display");


        WebElement allOrder = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        allOrder.click();

        WebElement addName = driver.findElement(By.xpath("//td[2][.='CodeFish IT School']"));

        String actualName = addName.getText().trim();
        String expectedName ="CodeFish IT School";
        System.out.println(actualName.equals(expectedName)?"NAME PASSED" : "NAME FALSE");

       WebElement addProducts= driver.findElement(By.xpath("//tr[2]//td[.='ScreenSaver']"));
       String actualProducts = addProducts.getText().trim();
       String expectedProducts = "ScreenSaver";
        System.out.println(actualProducts.equals(expectedProducts)?"PRODUCTS PASSED" : "PRODUCTS FALSE");

        WebElement addQuantity = driver.findElement(By.xpath("//tr//td[.='5']"));
        String actualQuantity = addQuantity.getText().trim();
        String expectedQuantity ="5";
        System.out.println(actualQuantity.equals(expectedQuantity)?"QUANTITY PASSED": "QUANTITY FALSE" );

        WebElement addDate = driver.findElement(By.xpath("//tr//td[.='06/01/2023']"));
        String actualDate = addDate.getText().trim();
        String expectedDate ="06/01/2023";
        System.out.println(actualDate.equals(expectedDate)?"DATE PASSED" :" DATE FALSE");

        WebElement addStreet = driver.findElement(By.xpath("//tr//td[.='2200 devon']"));
        String actualStreet = addStreet.getText().trim();
        String expectedStreet ="2200 devon";
        System.out.println(actualStreet.equals(expectedStreet)?"STREET PASSED" : "STREET FALSE");

        WebElement addCity = driver.findElement(By.xpath("//tr//td[.='Des Plaines']"));
        String actualCity = addCity.getText().trim();
        String expectedCity = "Des Plaines";
        System.out.println(actualCity.equals(expectedCity)? "CITY PASSED" : "CITY FALSE");

        WebElement addState = driver.findElement(By.xpath("//tr[2]//td[.='Illinois']"));
        String actualState = addState.getText().trim();
        String expectedState = "Illinois";
        System.out.println(actualState.equals(expectedState)? "STATE PASSED" : "STATE FALSE");

        WebElement addZip = driver.findElement(By.xpath("//tr[2]//td[.='60018']"));
        String actualZip = addZip.getText().trim();
        String expectedZip = "60018";
        System.out.println(actualZip.equals(expectedZip)?"ZIP PASSED":"ZIP FALSE");

        WebElement addTypeCard = driver.findElement(By.xpath("//tr[2]//td[.='MasterCard']"));
        String actualCard = addTypeCard.getText().trim();
        String expectedCard = "MasterCard";
        System.out.println(actualCard.equals(expectedCard)?"CARD PASSED":"CARD FALSE");

        WebElement addCardNumber = driver.findElement(By.xpath("//tr[2]//td[.='444993876233']"));
        String actualCardNumber = addCardNumber.getText();
        String expectedCardNumber ="444993876233";
        System.out.println(actualCardNumber.equals(expectedCardNumber)? "CARD NUMBER PASSED" : "CARD NUMBER FALSE");

        WebElement addExp = driver.findElement(By.xpath("//tr[2]//td[.='03/24']"));
        String actualExp = addExp.getText().trim();
        String expectedExp = "03/24";
        System.out.println(actualExp.equals(expectedExp)?"EXP PASSED" : "EXP FALSE");











    }
}
