Feature: Verify Create Booking API Service

  @CreateBooking
  Scenario Outline: Verify the CreateBooking service
    Given User prepares a Post request to perform the create Booking with the parameters:"<TestcaseName>","<URL>","<firstname>","<lastname>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
    When Post is triggered to the Endpoint:"<Endpoint>"
    Then verify the post statuscode: "<httpstatusCode>"

    Examples: 
      | TestcaseName                       | URL                                  | Endpoint  | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | httpstatusCode |
      | Create Booking-200 OK              | https://restful-booker.herokuapp.com | /booking  | Jim       | Brown    |        111 | true        | 2018-01-01 | 2019-01-01 | Breakfast       |            200 |
      | Create Booking-200-Total Price-OK  | https://restful-booker.herokuapp.com | /booking  | Jim       | Brown    |        123 | true        | 2018-01-01 | 2019-01-01 | Breakfast       |            200 |
      | Create Booking-200-deposit Paid-OK | https://restful-booker.herokuapp.com | /booking  | Jim       | Brown    |        134 | false       | 2018-01-01 | 2019-01-01 | Breakfast       |            200 |
      | Create Booking-404-NOT FOUND       | https://restful-booker.herokuapp.com | /booking1 | Jim       | Brown    |        134 | false       | 2018-01-01 | 2019-01-01 | Breakfast       |            404 |
