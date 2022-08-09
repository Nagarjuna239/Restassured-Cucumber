Feature: GetBookingByID

  @GetBookingByid
  Scenario Outline: Verify the GetBookingbyID services
    Given User prepares a Get request to perform the create Booking with the parameters:"<TestcaseName>","<URL>"
    When Get is triggered to the Endpoint:"<Endpoint>"
    Then verify the get statuscode: "<httpstatusCode>"

    Examples: 
      | TestcaseName                   | URL                                  | Endpoint       | httpstatusCode |
      | GetBooking by id-200 OK        | https://restful-booker.herokuapp.com | /booking/2317  |            200 |
      | GetBooking by id-404 NOT Found | https://restful-booker.herokuapp.com | /booking/19313 |            404 |
      | GetBooking by id-404 NOT FOUND | https://restful-booker.herokuapp.com | /booking/19533 |            404 |
