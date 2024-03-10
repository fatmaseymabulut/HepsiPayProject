package com.HB.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"txtUserName\"]")
    public WebElement EpostaAlani;

    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    public WebElement GirisYapButonEmail;

    @FindBy(id = "btnEmailSelect")
    public WebElement GirisYapButonSifre;


    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div/div/form/div/div/input")
    public WebElement SifreAlani;

}
