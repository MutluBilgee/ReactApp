package com.reactApp.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTest_StepDefs {

    Response response=null;

    @When("user gets the array of all wells from api")
    public void userGetsTheArrayOfAllWellsFromApi() {

        this.response=given().accept(ContentType.JSON)
                .when().get("/wells");

      response.prettyPrint();

        List<Map<String,Object>> allWellsList = response.body().as(List.class);

        //print all wells
        System.out.println("allWellsList = " + allWellsList);

        //print second wellName from allWellsList
        System.out.println("Second wellName_allWellsList = " + allWellsList.get(1).get("name"));

        //save third well in a map
        Map<String,Object> well3Map = allWellsList.get(2);

        //print third well from well3Map
        System.out.println("Third well_well3Map = " + well3Map);
    }

    @Then("status code should be {int} for wells")
    public void statusCodeShouldBeForWells(int statusCode) {
        this.response=given().accept(ContentType.JSON)
                .when().get("/wells");

        Assert.assertEquals(this.response.statusCode(),statusCode);
        System.out.println("All wells statusCode = " + this.response.statusCode());


    }

    @When("user gets the array of all logs from api")
    public void userGetsTheArrayOfAllLogsFromApi() {
        this.response=given().accept(ContentType.JSON)
                .when().get("/logs");

        response.prettyPrint();

        List<Map<String,Object>> allLogsList = response.body().as(List.class);

        //print all logs
        System.out.println("allLogsList = " + allLogsList);

        //print second log from allLogsList
        System.out.println("Second log_allLogsList = " + allLogsList.get(1).get("log"));

        //print third logType from allLogsList
        System.out.println("Third logType_allLogsList = " + allLogsList.get(2).get("logType"));

        //save third log in a map
        Map<String,Object> log3Map = allLogsList.get(2);

        //print third log from well3Map
        System.out.println("Third log_log3Map = " + log3Map);
    }

    @Then("status code should be {int} for logs")
    public void statusCodeShouldBeForLogs(int statusCode) {
        this.response=given().accept(ContentType.JSON)
                .when().get("/logs");

        Assert.assertEquals(this.response.statusCode(),statusCode);
        System.out.println("All logs statusCode = " + this.response.statusCode());
    }

    @When("user gets the array of all formations from api")
    public void userGetsTheArrayOfAllFormationsFromApi() {
        this.response=given().accept(ContentType.JSON)
                .when().get("/formations");

        response.prettyPrint();

        List<Map<String,Object>> allFormationsList = response.body().as(List.class);

        //print all formations
        System.out.println("allFormationsList = " + allFormationsList);

        //print second formationName from allFormationsList
        System.out.println("Second formationName_allFormationsList = " + allFormationsList.get(1).get("name"));

        //save fifth formation in a map
        Map<String,Object> formation5Map = allFormationsList.get(4);

        //print fifth formation from formation5Map
        System.out.println("Fifth formation_formation5Map = " + formation5Map);
    }

    @Then("status code should be {int} for formations")
    public void statusCodeShouldBeForFormations(int statusCode) {
        this.response=given().accept(ContentType.JSON)
                .when().get("/formations");

        Assert.assertEquals(this.response.statusCode(),statusCode);
        System.out.println("All formations statusCode = " + this.response.statusCode());
    }

    @When("user gets the array of all plots from api")
    public void userGetsTheArrayOfAllPlotsFromApi() {

        this.response=given().accept(ContentType.JSON)
                .when().get("/plots");

        response.prettyPrint();

        List<Map<String,Object>> allPlotsList = response.body().as(List.class);

        //print all plots
        System.out.println("allPlotsList = " + allPlotsList);

        //print second plot_X_value from allPlotsList
        System.out.println("Second plot_X_value_allPlotsList = " + allPlotsList.get(1).get("x"));

        //print second plot_Y_value from allPlotsList
        System.out.println("Second plot_Y_value_allPlotsList = " + allPlotsList.get(1).get("y"));

        //save third plot in a map
        Map<String,Object> plot3Map = allPlotsList.get(2);

        //print third plot from plot3Map
        System.out.println("Third plot_plot3Map = " + plot3Map);
    }

    @Then("status code should be {int} for plots")
    public void statusCodeShouldBeForPlots(int statusCode) {

        this.response=given().accept(ContentType.JSON)
                .when().get("/plots");

        Assert.assertEquals(this.response.statusCode(),statusCode);
        System.out.println("All plots statusCode = " + this.response.statusCode());
    }

    @When("user gets the related part of array from plots with id")
    public void userGetsTheRelatedPartOfArrayFromPlotsWithId() {
        this.response=given().accept(ContentType.JSON)
                .when().get("/plots?wellId=1&wellId=2");

        response.prettyPrint();

        List<Map<String,Object>> plotsList = response.body().as(List.class);

        //print requested plots
        System.out.println("plotsList = " + plotsList);

        //print first plot_X_value from plotsList
        System.out.println("First plot_X_value_plotsList = " + plotsList.get(0).get("x"));

        //print first wellId_value from plotsList
        System.out.println("first wellId_value_plotsList = " + plotsList.get(0).get("wellId"));

        //print second plot_Y_value from plotsList
        System.out.println("Second plot_Y_value_plotsList = " + plotsList.get(1).get("y"));

        //save first plot in a map
        Map<String,Object> plot1Map = plotsList.get(0);

        //print first plot from plot1Map
        System.out.println("First plot_plot1Map = " + plot1Map);

    }

    @Then("status code should be {int} for related part")
    public void statusCodeShouldBeForRelatedPart(int statusCode) {

        this.response=given().accept(ContentType.JSON)
                .when().get("/plots?wellId=1&wellId=2");

        Assert.assertEquals(this.response.statusCode(),statusCode);
        System.out.println("Related part statusCode = " + this.response.statusCode());
    }
}
