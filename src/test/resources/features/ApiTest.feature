@allApi
Feature: Api Test

  @wellsApi
  Scenario: Returning array of all wells
    When user gets the array of all wells from api
    Then status code should be 200 for wells

  @logsApi
  Scenario: Returning array of all logs
    When user gets the array of all logs from api
    Then status code should be 200 for logs

  @formationsApi
  Scenario: Returning array of all formations
    When user gets the array of all formations from api
    Then status code should be 200 for formations

  @plotsApi
  Scenario: Returning array of all plots
    When user gets the array of all plots from api
    Then status code should be 200 for plots

  @apiWithId
  Scenario: Returning any part of array from plots with id
    When user gets the related part of array from plots with id
    Then status code should be 200 for related part

