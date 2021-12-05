package com.reactApp.step_definitions;
import com.reactApp.pages.Histogram;
import com.reactApp.pages.Title;
import com.reactApp.pages.WellBore;
import com.reactApp.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class earthNet_stepDefs {

    Title title=new Title();
    WellBore wellBore=new WellBore();
    Histogram histogram=new Histogram();

    List<String>selectItem=new ArrayList<>();
    List<String>selectWell=new ArrayList<>();
    List<String>selectLog=new ArrayList<>();
    List<String>selectFormation=new ArrayList<>();
    List<String>wellborePageInitialSelectedText=new ArrayList<>();
    List<String>wellborePageFinalSelectedText=new ArrayList<>();
    List<String>histogramPageInitialSelectedText=new ArrayList<>();
    List<String>histogramPageFinalSelectedText=new ArrayList<>();

    @Given("user selects or deselects list items")
    public void user_selects_or_deselects_list_items() throws InterruptedException {

        //Add item to "list of select" in order to select
        selectItem.add("item-2");

        for(String item:selectItem){
            title.selectItem(item);
        }
    }

    @When("user navigates to The Wellbore Page by clicking Wellbore link in the header")
    public void user_navigates_to_The_Wellbore_Page_by_clicking_Wellbore_link_in_the_header() {

      wellBore.wellboreLink.click();

    }

    @Then("user selects at least one well from the wells list in the Wellbore Page")
    public void user_selects_at_least_one_well_from_the_wells_list_in_the_Wellbore_Page() {

        //Add well(s) to "list of select" in order to select
        selectWell.add("well2");
        selectWell.add("well7");

        for(String well:selectWell){
            wellBore.selectWells(well);
        }

    }

    @Then("user selects at least one log from the logs list in the Wellbore Page")
    public void user_selects_at_least_one_log_from_the_logs_list_in_the_Wellbore_Page() {

        //Add log(s) to "list of select" in order to select
        selectLog.add("AI");
        selectLog.add("AI_DEMO");

        for(String log:selectLog){
            wellBore.selectLogs(log);
        }
    }

    @Then("user selects at least one formation from the formation list in the Wellbore Page")
    public void user_selects_at_least_one_formation_from_the_formation_list_in_the_Wellbore_Page() {

        //Add formation(s) to "list of select" in order to select
        selectFormation.add("BALDER FM");
        selectFormation.add("VALE FM");

        for(String formation:selectFormation){
            wellBore.selectFormations(formation);
        }

        String selectedLocator="//li[@class='MuiListItem-root EsaList-listItem-49 MuiListItem-gutters Mui-selected']";
        List<WebElement>wellborePageSelectedElement=Driver.get().findElements(By.xpath(selectedLocator));

        for(WebElement selectedElement:wellborePageSelectedElement){
            wellborePageInitialSelectedText.add(selectedElement.getText());
        }

        System.out.println("wellborePageInitialSelectedText = " + wellborePageInitialSelectedText.toString());
    }

    @And("the SHOW PLOT button should be enabled in the Wellbore Page")
    public void the_SHOW_PLOT_button_should_be_enabled_in_the_Wellbore_Page() {
        Assert.assertTrue(wellBore.showPlotButton.isEnabled());
    }

    @Then("user clicks the SHOW PLOT button in the Wellbore Page")
    public void user_clicks_the_SHOW_PLOT_button_in_the_Wellbore_Page() {

        wellBore.showPlotButton.click();
    }

    @Then("Wells Plot should be displayed in the Wellbore Page")
    public void wells_Plot_should_be_displayed_in_the_Wellbore_Page() throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("document.body.style.zoom = '0.8'");

        Thread.sleep(1000);
        Assert.assertTrue(wellBore.verifyWellsPlotChart());

        JavascriptExecutor executor2 = (JavascriptExecutor)Driver.get();
        executor2.executeScript("document.body.style.zoom = '1'");
    }

    @Then("user navigates to The Histogram Page by clicking Histogram link in the header")
    public void user_navigates_to_The_Histogram_Page_by_clicking_Histogram_link_in_the_header() {
       histogram.histogramLink.click();
    }

    @Then("well, log and formation selections should be the same with The Wellbore Page")
    public void well_log_and_formation_selections_should_be_the_same_with_The_Wellbore_Page(){

        String selectedLocator="//li[@class='MuiListItem-root EsaList-listItem-49 MuiListItem-gutters Mui-selected']";
        List<WebElement>histogramPageInitialSelectedElement=Driver.get().findElements(By.xpath(selectedLocator));

        for(WebElement selectedElement:histogramPageInitialSelectedElement){
            histogramPageInitialSelectedText.add(selectedElement.getText());
        }

        System.out.println("wellborePageInitialSelectedText = " + wellborePageInitialSelectedText.toString());
        System.out.println("histogramPageInitialSelectedText = " + histogramPageInitialSelectedText.toString());


        for(int i=0; i<histogramPageInitialSelectedText.size(); i++){
            Assert.assertEquals(wellborePageInitialSelectedText.get(i),histogramPageInitialSelectedText.get(i));
        }
    }

    @When("user selects at least one well from the wells list in the Histogram Page")
    public void user_selects_at_least_one_well_from_the_wells_list_in_the_Histogram_Page() {
        //Add well(s) to "list of select" in order to select
        selectWell.add("well4");
        selectWell.add("well9");

        for(String well:selectWell){
            histogram.selectWells(well);
        }
    }

    @Then("user selects at least one log from the logs list in the Histogram Page")
    public void user_selects_at_least_one_log_from_the_logs_list_in_the_Histogram_Page() {
        //Add log(s) to "list of select" in order to select
        selectLog.add("CALI");
        selectLog.add("CALI_DEMO");

        for(String log:selectLog){
            histogram.selectLogs(log);
        }
    }

    @Then("user selects at least one formation from the formation list in the Histogram Page")
    public void user_selects_at_least_one_formation_from_the_formation_list_in_the_Histogram_Page() {
        //Add formation(s) to "list of select" in order to select
        selectFormation.add("HIDRA FM");
        selectFormation.add("TOR FM");

        for(String formation:selectFormation){
            histogram.selectFormations(formation);
        }

        String selectedLocator="//li[@class='MuiListItem-root EsaList-listItem-49 MuiListItem-gutters Mui-selected']";
        List<WebElement>histogramPageFinalSelectedElement=Driver.get().findElements(By.xpath(selectedLocator));

        for(WebElement selectedElement:histogramPageFinalSelectedElement){
            histogramPageFinalSelectedText.add(selectedElement.getText());
        }

        System.out.println("histogramPageFinalSelectedText= " + histogramPageFinalSelectedText.toString());
    }

    @Then("the SHOW PLOT button should be enabled in the Histogram Page")
    public void the_SHOW_PLOT_button_should_be_enabled_in_the_Histogram_Page() {
        Assert.assertTrue(histogram.showPlotButton.isEnabled());
    }


    @Then("Wells Plot should be displayed in the Histogram Page - WellsPlot_Stack_Vertical")
    public void wells_Plot_should_be_displayed_in_the_Histogram_Page() {
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("document.body.style.zoom = '0.8'");

        Assert.assertTrue(histogram.verifyWellsPlotChart_Stack_Vertical());

        JavascriptExecutor executor2 = (JavascriptExecutor)Driver.get();
        executor2.executeScript("document.body.style.zoom = '1'");
    }

    @Then("user selects stack-horizontal")
    public void userSelectsStackHorizontal() {
        histogram.vertical_1.click();
        histogram.horizontal_2.click();
    }

    @And("Wells Plot should be displayed in the Histogram Page - WellsPlot_Stack_Horizontal")
    public void wellsPlotShouldBeDisplayedInTheHistogramPageWellsPlot_Stack_Horizontal(){
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("document.body.style.zoom = '0.8'");

        Assert.assertTrue(histogram.verifyWellsPlotChart_Stack_Horizontal());

        JavascriptExecutor executor2 = (JavascriptExecutor)Driver.get();
        executor2.executeScript("document.body.style.zoom = '1'");

    }

    @Then("user selects group-horizontal")
    public void userSelectsGroupHorizontal() {
        histogram.stack_1.click();
        histogram.group_2.click();
    }

    @And("Wells Plot should be displayed in the Histogram Page - WellsPlot_Group_Horizontal")
    public void wellsPlotShouldBeDisplayedInTheHistogramPageWellsPlot_Group_Horizontal() {

        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("document.body.style.zoom = '0.8'");

        Assert.assertTrue(histogram.verifyWellsPlotChart_Group_Horizontal());

        JavascriptExecutor executor2 = (JavascriptExecutor)Driver.get();
        executor2.executeScript("document.body.style.zoom = '1'");
    }

    @Then("user selects group-vertical")
    public void userSelectsGroupVertical() {

        histogram.horizontal_1.click();
        histogram.vertical_2.click();

    }

    @And("Wells Plot should be displayed in the Histogram Page - WellsPlot_Group_Vertical")
    public void wellsPlotShouldBeDisplayedInTheHistogramPageWellsPlot_Group_Vertical(){
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("document.body.style.zoom = '0.8'");

        Assert.assertTrue(histogram.verifyWellsPlotChart_Group_Vertical());

        JavascriptExecutor executor2 = (JavascriptExecutor)Driver.get();
        executor2.executeScript("document.body.style.zoom = '1'");
    }

    @Then("user navigates to The Wellbore Page again by clicking Wellbore link in the header")
    public void user_navigates_to_The_Wellbore_Page_again_by_clicking_Wellbore_link_in_the_header() {
      wellBore.wellboreLink.click();
    }

    @Then("well, log and formation selections should be the same with The Histogram Page")
    public void well_log_and_formation_selections_should_be_the_same_with_The_Histogram_Page() throws InterruptedException {

        String selectedLocator="//li[@class='MuiListItem-root EsaList-listItem-49 MuiListItem-gutters Mui-selected']";
        List<WebElement>wellborePageFinalSelectedElement=Driver.get().findElements(By.xpath(selectedLocator));

        for(WebElement selectedElement:wellborePageFinalSelectedElement){
            wellborePageFinalSelectedText.add(selectedElement.getText());
        }

        System.out.println("wellborePageFinalSelectedText = " + wellborePageFinalSelectedText.toString());
        System.out.println("histogramPageFinalSelectedText = " + histogramPageFinalSelectedText.toString());

        for(int i=0; i<histogramPageFinalSelectedText.size(); i++){
            Assert.assertEquals(wellborePageFinalSelectedText.get(i),histogramPageFinalSelectedText.get(i));
        }
    }


}
