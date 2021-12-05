package com.reactApp.pages;

import com.reactApp.utilities.Driver;

import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }




}
