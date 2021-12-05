package com.reactApp.pages;

import com.reactApp.utilities.Driver;
import org.openqa.selenium.By;

public class Title extends BasePage{

    public void selectItem(String itemName){
        String item="//span[.='"+itemName+"']";
        Driver.get().findElement(By.xpath(item)).click();

    }


 
}
