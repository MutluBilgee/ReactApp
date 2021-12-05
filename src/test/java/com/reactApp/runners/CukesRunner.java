package com.reactApp.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt",
                "pretty"},
        features = "src/test/resources/features",
        glue = "com/reactApp/step_definitions",
        dryRun = false,
        tags = "@wip"

        //In order to run any scenario, write related tag name to "tags"

        //Tags
        //EarthNet Functionality (UI Automation) - @wip
        //All Api Test - @allApi
        //Returning array of all wells - @wellsApi
        //Returning array of all logs - @logsApi
        //Returning array of all formations - @formationsApi
        //Returning array of all plots - @plotsApi
        //Returning any part of array from plots with id - @apiWithId
)
public class CukesRunner {
}










