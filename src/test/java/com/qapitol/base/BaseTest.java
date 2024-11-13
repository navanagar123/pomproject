package com.qapitol.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static FileInputStream fis;
   public static  Properties prop;
   public static WebDriver driver;


    public BaseTest() throws FileNotFoundException {

        prop=new Properties();
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qapitol\\util\\testData.properties");
            prop.load(fis);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    @BeforeMethod
    public static void initialization(){
        String BrowserName= prop.getProperty("browser");
        String urlName = prop.getProperty("url");
        if(BrowserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if(BrowserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }
        else if (BrowserName.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();

        }
        else{
            System.out.println("no brwser found");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(urlName);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}


