package com.HB.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class OdemePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"OtherPayTab\"]/div/a")
    public WebElement DigerOdemeSecenekleriButon;

    @FindBy(xpath = "//*[@id=\"Havale\"]")
    public WebElement AnindaHavaleRadioButon;

    @FindBy(xpath = "//*[@id=\"bankItem\"][4]")
    public WebElement KuveytTurkSecimi;

    @FindBy(xpath = "//*[@id=\"bankItem\"][5]")
    public WebElement FibaBankaSecimi;

    @FindBy(xpath = "//*[@id=\"agreement\"]")
    public WebElement FormSozlesmeOnayRadioButon;

    @FindBy(id = "continue_step_btn")
    public WebElement SiparisiOnaylaButon;

    @FindBy(id = "//*[@id=\"basket_payedPrice\"]/span")
    public WebElement SiparisEkraniOdemeTutari;

}
