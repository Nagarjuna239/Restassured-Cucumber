Feature: Verify Update Booking API Service

  @UpdateBooking
  Scenario Outline: Verify the Update Booking service
    Given Generate AccessToken:"<AuthURL>","<username>","<password>"
    When User prepares a Put request to perform the create Booking with the parameters:"<TestcaseName>","<URL>","<firstname>","<lastname>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
    When Put is triggered to the Endpoint:"<Endpoint>"
    Then verify the put statuscode: "<httpstatusCode>"

    Examples: 
      | TestcaseName                          | AuthURL                                   | username | password    | URL                                  | Endpoint       | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | httpstatusCode |
      | UpdateBooking-200 OK                  | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/2505  | Jim       | Brown    |        111 | false       | 2018-01-01 | 2019-01-01 | Breakfast       |            200 |
      | UpdateBooking-200 OK                  | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/1278  | Jim       | Brown    |        123 | false       | 2018-01-01 | 2019-01-01 | Breakfast       |            200 |
      | UpdateBooking-405- Method not allowed | https://restful-booker.herokuapp.com/auth | admin    | password123 | https://restful-booker.herokuapp.com | /booking/19533 | Jim       | Brown    |        134 | false       | 2018-01-01 | 2019-01-01 | Breakfast       |            405 |
