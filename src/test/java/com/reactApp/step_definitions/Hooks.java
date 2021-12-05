package com.reactApp.step_definitions;

import com.reactApp.utilities.ConfigurationReader;
import com.reactApp.utilities.Driver;
import com.testautomationguru.ocular.Ocular;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;

public class Hooks {

    @Before
    public void setUp() throws Exception {

        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();

        MyScreenRecorder.startRecording();

        Ocular.config()
                .snapshotPath(Paths.get(".", "src/test/resources/snap"))
                .resultPath(Paths.get(".", "src/test/resources/result"));

        baseURI= ConfigurationReader.get("api_url");
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
        MyScreenRecorder.stopRecording();

    }

}