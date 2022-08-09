Feature: Verify Delete Booking API Service

  @Deletebookingservice
  Scenario Outline: Verify the Delete Booking service
    Given Generate AccessToken:"<AuthURL>","<username>","<password>"
    When User prepares a Delete request to perform the create Booking with the parameters:"<TestcaseName>","<URL>"
    When Delete is triggered to the Endpoint:"<Endpoint>"
    Then verify the Delete statuscode and Responsemessage: "<httpstatusCode>","<Responsemessage>"

    Examples: 
      | TestcaseName             | AuthURL                                   | username | password    | URL                                  | Endpoint       | httpstatusCode | Responsemessage |
      | Deletebookingservice-201 | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/4902  |            201 | Created         |
      | Deletebookingservice-405 | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/28926 |            405 | Not Allowed     |
