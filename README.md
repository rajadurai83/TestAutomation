Booking.com Hotel reservation test automation in selenium webdriver with testNG

Pre-requirements installations:

It runs in Java8
All dependencies (maven, testNG, selenium webdriver) are given in pom.xml

Project folder structure:

I have created it as a multi module maven project.hotelreservation is the main folder. 

Maven modules are:
booking-base - contains selenium dependencies
booking-commonutils- contains re-usable common utility classes.
booking-pagefactory -contains the reusable web page elements.
booking-tests: where all the test steps are written.

-This project contains no validation.
-I have given all test data (cityname, prefered date, number of rooms, browser name) in testNG.xml which will be passed to the tests in booking-test module.
-Please run as TestNG suite to initiate the project. 
