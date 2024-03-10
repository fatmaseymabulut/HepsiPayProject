package com.HB.pages;

import com.HB.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class BasePage {
        public BasePage() {
            PageFactory.initElements(Driver.get(),this);
        }

        @FindBy(xpath = "//*[@id=\"myAccount\"]/span/span[1]")
        public WebElement GirisYapVeyaUyeOlButonMenu;

        @FindBy(xpath = "//*[@id=\"login\"]")
        public WebElement MenudenGirisYapButon;

        @FindBy(xpath = "//*[@id=\"myAccount\"]/span/a/span[1]")
        public WebElement HesabimKontrol;

        @FindBy(xpath = "//*[@id=\"SearchBoxOld_5fd28315-b5df-4b14-a327-ff23665be14d\"]/div/div/div[1]")
        public WebElement UrunArama;

        @FindBy(xpath = "//*[@id=\"SearchBoxOld_5fd28315-b5df-4b14-a327-ff23665be14d\"]/div/div/div[2]")
        public WebElement AraButon;

        @FindBy(xpath = "//*[@id=\"i0\"]/div/a/div[1]/div[1]/div/picture/img")
        public WebElement IlkUrunHoverOver;

        @FindBy(xpath = "product-info-button")
        public WebElement SepeteEkleButon;

        @FindBy(xpath = "/html/body/div[9]/div/div/div[2]/div[1]")
        public WebElement UrunSepeteEklendiYesilEtiket;

        @FindBy(xpath = "/html/body/div[9]/div/div/div[2]/div[2]/a")
        public WebElement SepeteGitYesilEtiket;

    }