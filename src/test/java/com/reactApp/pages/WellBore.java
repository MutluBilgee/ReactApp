package com.reactApp.pages;

import com.reactApp.utilities.Driver;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WellBore extends BasePage{


    public Map<String, String> map;

    @FindBy(xpath = "//span[contains(text(),'Wellbore')]")
    public WebElement wellboreLink;

    public WellBore() {

        PageFactory.initElements(Driver.get(), this);

        map = new HashMap<String, String>();
        map.put("WellsPlot", "WellsPlot.png");
    }

    public void selectWells(String wellsName){
        String well="//span[.='"+wellsName+"']";
        Driver.get().findElement(By.xpath(well)).click();
    }

    public void selectLogs(String logsName){
        String log="//span[.='"+logsName+"']";
        Driver.get().findElement(By.xpath(log)).click();
    }

    public void selectFormations(String formationsName){
        String formation="//span[.='"+formationsName+"']";
        Driver.get().findElement(By.xpath(formation)).click();
    }

    @FindBy(xpath = "//span[.='Show Plot']")
    public WebElement showPlotButton;

    @FindBy(xpath = "//div[@class='js-plotly-plot']/div/div")
    public WebElement WellsPlot;

    public boolean verifyChart(String fileName, WebElement element) {

        Path path = Paths.get(fileName);

        OcularResult result = Ocular.snapshot()
                .from(path)
                .sample()
                .using(Driver.get())
                .element(element)
                .compare();

        return result.isEqualsImages();
    }

    public boolean verifyWellsPlotChart() {
        return this.verifyChart(map.get("WellsPlot"), WellsPlot);
    }



}
