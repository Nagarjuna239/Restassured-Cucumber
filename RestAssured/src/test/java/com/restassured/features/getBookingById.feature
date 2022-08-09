Feature: GetBookingByID

  @GetBookingByid
  Scenario Outline: Verify the GetBookingbyID services
    Given User prepares a Get request to perform the create Booking with the parameters:"<TestcaseName>","<URL>"
    When Get is triggered to the Endpoint:"<Endpoint>"
    Then verify the get statuscode: "<httpstatusCode>"

    Examples: 
      | TestcaseName            | URL                                  | Endpoint       | httpstatusCode |
      | GetBooking by id-200 OK | https://restful-booker.herokuapp.com | /booking/8586  |            200 |
      | GetBooking by id-200 OK | https://restful-booker.herokuapp.com | /booking/19313 |            200 |
      | GetBooking by id-200 OK | https://restful-booker.herokuapp.com | /booking/19533 |            200 |
