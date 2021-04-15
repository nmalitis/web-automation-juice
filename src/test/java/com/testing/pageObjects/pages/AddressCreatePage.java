package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/address/create")
public class AddressCreatePage extends AddressSelectPage {
  // Locators
  // -------------------------------------------------------------------------------------------------------------------
  public static By CREATE_AN_ADDRESS_TITLE = text ("Add New Address");
  public static By COUNTRY_FIELD = By.xpath("//div/mat-form-field[1]/div/div/div/input");
  public static By NAME_FIELD = By.xpath("//div/mat-form-field[2]/div/div/div/input");
  public static By MOBILE_NUMBER_FIELD = By.xpath("//div/mat-form-field[3]/div/div/div/input");
  public static By ZIP_CODE_FIELD = By.xpath("//div/mat-form-field[4]/div/div/div/input");
  public static By ADDRESS_FIELD = By.xpath("//div/mat-form-field[5]/div/div/div/textarea");
  public static By CITY_FIELD = By.xpath("//div/mat-form-field[6]/div/div/div/input");
  public static By STATE_FIELD = By.xpath("//div/mat-form-field[7]/div/div/div/input");
  // Public methods
  // -------------------------------------------------------------------------------------------------------------------
  public void waitForPageToLoad(){
    getElement(CREATE_AN_ADDRESS_TITLE).waitUntilVisible();
    logWeAreOnPage();
  }

  public void click(String elementName){
    super.click(snakify(elementName));
    if(snakify(elementName).equals("SUBMIT_BUTTON")) getElement(SELECT_AN_ADDRESS_TITLE).waitUntilVisible();
  }
}
