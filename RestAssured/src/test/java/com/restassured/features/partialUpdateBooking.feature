Feature: Verify partial Update Booking API Service

  @partialUpdateBooking
  Scenario Outline: Verify the partial Update Booking service
    Given Generate AccessToken:"<AuthURL>","<username>","<password>"
    When User prepares a Patch request to perform the create Booking with the parameters:"<TestcaseName>","<URL>","<firstname>","<lastname>"
    When Patch is triggered to the Endpoint:"<Endpoint>"
    Then verify the patch statuscode: "<httpstatusCode>"

    Examples: 
      | TestcaseName                                 | AuthURL                                   | username | password    | URL                                  | Endpoint       | firstname | lastname | httpstatusCode |
      | partialUpdateBooking-200 OK                  | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/1562  | Jame      | Browns   |            200 |
      | partialUpdateBooking-Update Firstname        | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/2459  | James     | Browns   |            200 |
      | partialUpdateBooking-200-First name is blank | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/1633  |           | Brow     |            200 |
      | partialUpdateBooking-405-Method Not Allowed  | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/19533 | James     | Browns   |            405 |
