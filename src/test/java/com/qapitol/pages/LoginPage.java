package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class LoginPage extends BaseTest {
    public LoginPage() throws FileNotFoundException {

        PageFactory.initElements(driver,this);
    }
@FindBy(name="q")
    WebElement searchProd;
@FindBy(xpath = "//button[@type='submit']")
WebElement searchbtn;

@FindBy(css=".yKfJKb.row .KzDlHZ")
List<WebElement> productName;






    public void verifyElements(){
        searchProd.sendKeys("ipphone16");
        searchbtn.click();
      for(WebElement products:productName){
          System.out.println(products.getText());
      }



    }
}
