package com.testing.pageObjects.pages;

import static org.junit.Assert.fail;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/payment/shop")
public class PaymentShopPage extends DeliveryMethodPage{
  // Locators
  // -------------------------------------------------------------------------------------------------------------------
  public static By MY_PAYMENT_OPTIONS_TITLE = text("My Payment Options");
  public static By CONTINUE_BUTTON = css ("button[aria-label='Proceed to review']");
  public static By ADD_NEW_CARD_OPTION = css ("mat-expansion-panel-header[id='mat-expansion-panel-header-0']");
  public static By CARD_NAME_FIELD = css ("div>mat-form-field>div>div>div>input[id^='mat-input'][type='text']");
  public static By CARD_NUMBER_FIELD = css ("input[id^='mat-input'][type='number']");
  public static By EXPIRY_MONTH_FIELD = By.xpath("//div/mat-form-field[3]");
  public static By EXPIRY_YEAR_FIELD = By.xpath("//div/mat-form-field[4]");
  // Public methods
  // -------------------------------------------------------------------------------------------------------------------
  public void waitForPageToLoad(){
    getElement(MY_PAYMENT_OPTIONS_TITLE).waitUntilVisible();
    logWeAreOnPage();
  }

  public void performSelectCreditCard(DataTable data){
    String cardNumber = null;
    Boolean found = null;

    for (Map<String, String> map : dataToMap(data)) {
      found = false;
      cardNumber = map.get("Card Number");
      for (WebElement element : getElements(ROW_ITEMS)) {
        if(!element.getText().contains(cardNumber)) continue;
        element.findElement(css("mat-radio-button")).click();
        found = true;
      }
      if(found) break;
    }
    if(!found) fail("Failed to select given card number: " + cardNumber);
  }

  public void setElementValueTo(String elementName, String value) {
    switch(elementName){
      case "EXPIRY_MONTH":
        getElement(EXPIRY_MONTH_FIELD).click();
        getElement(exactText(value)).click();
        break;
      case "EXPIRY_YEAR":
        getElement(EXPIRY_MONTH_FIELD).click();
        getElement(exactText(value)).click();
        break;
      default:
        getElement(elementName).click();
        getElement(elementName).sendKeys(value);
    }
  }
}
