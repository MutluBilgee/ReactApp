REACT APP ASSESSMENT

GENERAL INFORMATION

	- The framework is built with maven - build automation tool which has pom.xml file that allows me to manage my dependencies/versions easily.

	- BDD approach is implemented to simplify reading and understanding my framework for the non-technical teammates.

	- Test case is written in Gherkin language in my feature files in order to be understandable for users perspective .

	- JAVA-SELENIUM-JUNIT are implemented the actual coding logic with inside of the step_definitions package and it their own respective/related classes.
  
  - Page Object Model is used to simplify managing and maintaining the framework.
  
  - Singleton Design Pattern is used in the "Driver Class" to allow the framework to pass the same instance of the webdriver in one session.
  
  - "configuration.properties" type of file is created in order to keep the important test data about the framework and some personal data.
  
  -  "The ConfigurationReader Class" is created from existing java library to read from property file.
  
  - Hooks class is created in order to implement some cucumber annotations such as Before, After, beforestep, afterstep to create outline for the scenarios.
  
  - The "maven-cucumber-reporting" plugin is used for creating "cucumber-html-reports" under target folder. 
  
It includes pie-charts, matrixes on which tests are passing and failing. Even has the option to show what percentage of which tags are failing and passing.
  
HOW TO RUN THE FRAMEWORK

In The Local PC

With The IDE Tool

1) Clone the project in the IDE Tool (INTELLIJ is reccomended)
2) Go to src\test\java\com\reactApp\runners\CukesRunner 
3) In order to run any scenario:
Write related tag name to "tags” and click green play icon near to class name

 	//Tags
        //EarthNet Functionality (UI Automation) - @wip
        //All Api Test - @allApi
        //Returning array of all wells - @wellsApi
        //Returning array of all logs - @logsApi
        //Returning array of all formations - @formationsApi
        //Returning array of all plots - @plotsApi
        //Returning any part of array from plots with id - @apiWithId


 or
 
1) Go to INTELLIJ TERMINAL
2) Type "mvn test" or "mvn verify" and hit the enter

or

1) Click Maven menu at the right up corner and extend "Lifecycle"
2) Click "test" or "verify"
Once the process is finised go to "Target" folder (orange folder) and extend it.
3) Extend the "cucumber-html-reports" and right click "overview-features.html"
4) Hover Open in go to Browser and select any browser.
5) Check the report details

Without IDE Tool

- You should download maven and install the maven from that link: https://maven.apache.org/download.cgi then,
1) Open your Terminal or Powershell in your PC
2) Type this command: cd "the directory of the project folder" and hit the enter. (be sure that current working directory is the project folder)
3) Type "mvn test" or "mvn verify" and hit the enter


In The EC2 Machine
- If you have an AWS account you should write down your IP Address
- You need a Jenkins Account (it could be any other CI/CD Tools as well)

1) Login your Jenkins Account
2) Go to "Dashboard"
3) Click New Item
4) Enter job name
5) Choose Freestyle Project and click OK
6) Do not touch General Part
7) Provide the repository URL to related inputbox in the "Source Code Management"
8) You can schedule the build id needed in "Build Triggers" part. But for one build you don't need.
9) Go to "Build section" and click "Add build step" then choose "Invoke top-level Maven targets"
10) Type "test" in to the "Goals" inputbox
11) Click Add post build action in the Post Build Actions and choose "Cucumber reports"

- In order to get the results in the email, you need some extra actions

12) Click Add Post build action and choose Editable Email Notification
13) Add emails what you want to send report
14) Change content type and subject
15) Add some content to email make sure you include report

<a href="http://3.90.249.23:8081//job/REACT_APP_Assessment/$
{BUILD_NUMBER}/cucumber-html-reports/overview-features.
html">REACT APP Test Results</a>

- This is link for your report, you have to change your ip
address and job name based on your information.

- Once you have done the setup go to the Dashboard and Click your project name
- Then Click "Build Now"
- Once you click the build number build window opens and you can observe the output by clicking "Console Output"
- When the build is finished, you can go back to the build window and find the "Cucumber reports"
Click the "Cucumber reports" and check the result

Mutlu Bilge – Software Development Engineer in Test
