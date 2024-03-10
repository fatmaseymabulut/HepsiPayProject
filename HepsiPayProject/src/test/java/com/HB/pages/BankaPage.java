package com.HB.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class BankaPage extends BasePage {

    @FindBy(xpath = "/html/body/div/div[2]/div/table/tbody/tr[1]/td[2]/b")
    public WebElement BankaEkraniOdemeTutari;

    @FindBy(xpath = "/html/body/div/button/h2")
    public WebElement AlisveriseGeriDon;
}
