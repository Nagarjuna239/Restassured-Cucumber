Feature: GetBookingIds

  @GetBookingIds
  Scenario Outline: Verify the GetBookingIds services
    Given User prepares a Get request to perform the create Booking with the parameters:"<TestcaseName>","<URL>"
    When Get is triggered to the Endpoint:"<Endpoint>"
    And verify the booking id are present:"<bookingIDpresent1>","<bookingIDpresent2>"
    Then verify the get statuscode: "<httpstatusCode>"

    Examples: 
      | TestcaseName          | URL                                  | Endpoint | httpstatusCode | bookingIDpresent1 | bookingIDpresent2 |
      | GetBooking ids-200 ok | https://restful-booker.herokuapp.com | /booking |            200 |             19533 |             19313 |
