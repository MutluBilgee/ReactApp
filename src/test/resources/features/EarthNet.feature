
@wip
Feature: EarthNet Functionality

  Background:

    Given user selects or deselects list items

  Scenario: User modifies Wellbore and Histogram Page

    When user navigates to The Wellbore Page by clicking Wellbore link in the header
    Then user selects at least one well from the wells list in the Wellbore Page
    Then user selects at least one log from the logs list in the Wellbore Page
    Then user selects at least one formation from the formation list in the Wellbore Page
    And the SHOW PLOT button should be enabled in the Wellbore Page
    Then user clicks the SHOW PLOT button in the Wellbore Page
    And Wells Plot should be displayed in the Wellbore Page
    Then user navigates to The Histogram Page by clicking Histogram link in the header
    And well, log and formation selections should be the same with The Wellbore Page
    When user selects at least one well from the wells list in the Histogram Page
    Then user selects at least one log from the logs list in the Histogram Page
    Then user selects at least one formation from the formation list in the Histogram Page
    And the SHOW PLOT button should be enabled in the Histogram Page
    And Wells Plot should be displayed in the Histogram Page - WellsPlot_Stack_Vertical
    Then user selects stack-horizontal
    And Wells Plot should be displayed in the Histogram Page - WellsPlot_Stack_Horizontal
    Then user selects group-horizontal
    And Wells Plot should be displayed in the Histogram Page - WellsPlot_Group_Horizontal
    Then user selects group-vertical
    And Wells Plot should be displayed in the Histogram Page - WellsPlot_Group_Vertical
    Then user navigates to The Wellbore Page again by clicking Wellbore link in the header
    And well, log and formation selections should be the same with The Histogram Page