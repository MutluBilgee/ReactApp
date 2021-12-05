package com.reactApp.pages;

import com.reactApp.utilities.Driver;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Histogram extends BasePage{

    public Map<String, String> map;

    @FindBy(xpath = "//span[contains(text(),'Histogram')]")
    public WebElement histogramLink;

    public Histogram() {

        PageFactory.initElements(Driver.get(), this);

        map = new HashMap<String, String>();
        map.put("WellsPlot_Stack_Vertical", "WellsPlot_Stack_Vertical.png");
        map.put("WellsPlot_Stack_Horizontal", "WellsPlot_Stack_Horizontal.png");
        map.put("WellsPlot_Group_Horizontal", "WellsPlot_Group_Horizontal.png");
        map.put("WellsPlot_Group_Vertical", "WellsPlot_Group_Vertical.png");

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

    @FindBy(xpath = "//div[contains(text(),'vertical')]")
    public WebElement vertical_1;

    @FindBy(xpath = "//li[contains(text(),'vertical')]")
    public WebElement vertical_2;

    @FindBy(xpath = "//div[contains(text(),'horizontal')]")
    public WebElement horizontal_1;

    @FindBy(xpath = "//li[contains(text(),'horizontal')]")
    public WebElement horizontal_2;

    @FindBy(xpath = "//div[contains(text(),'stack')]")
    public WebElement stack_1;

    @FindBy(xpath = "//li[contains(text(),'stack')]")
    public WebElement stack_2;

    @FindBy(xpath = "//div[contains(text(),'group')]")
    public WebElement group_1;

    @FindBy(xpath = "//li[contains(text(),'group')]")
    public WebElement group_2;

    @FindBy(xpath = "//div[@class='js-plotly-plot']/div/div")
    public WebElement WellsPlot_Stack_Vertical;

    @FindBy(xpath = "//div[@class='js-plotly-plot']/div/div")
    public WebElement WellsPlot_Stack_Horizontal;

    @FindBy(xpath = "//div[@class='js-plotly-plot']/div/div")
    public WebElement WellsPlot_Group_Vertical;

    @FindBy(xpath = "//div[@class='js-plotly-plot']/div/div")
    public WebElement WellsPlot_Group_Horizontal;

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

    public boolean verifyWellsPlotChart_Stack_Vertical() {
        return this.verifyChart(map.get("WellsPlot_Stack_Vertical"), WellsPlot_Stack_Vertical);
    }

    public boolean verifyWellsPlotChart_Stack_Horizontal() {
        return this.verifyChart(map.get("WellsPlot_Stack_Horizontal"), WellsPlot_Stack_Horizontal);
    }

    public boolean verifyWellsPlotChart_Group_Horizontal() {
        return this.verifyChart(map.get("WellsPlot_Group_Horizontal"), WellsPlot_Group_Horizontal);
    }

    public boolean verifyWellsPlotChart_Group_Vertical() {
        return this.verifyChart(map.get("WellsPlot_Group_Vertical"), WellsPlot_Group_Vertical);
    }

}
