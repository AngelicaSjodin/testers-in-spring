1. Test strategy
I have used three types of tests:
Unit test, Component test and Integration test

Unit test, tests individual methods in isolation with mockito.
Component test, tests the interaction between the controller and service.
Integration test, tests the whole system is working together. 

2. Methods tested

the unit test of UserService.registerUser() checks thatno duplicate names are allowed, it was made to help users (in the future) easily find eachother
 .The unit test of UserService.GetUserByName() checks that it returns the correct user or null if the user does not exsist, it was made to ensure you got the right user you were looking for.

The Component test registerUser() and getUser() checks that the end points POST /users/register response is "user registered" and that GET /users/{name} retrieves a user by name and returns correct data. These tests were needed to check that it correctly handles HTTP requests and responses.

The intergration test teststhe registration of a user and retrieving the user from a database. It is needed to check the whole project is working and interacting with all its files.


3. Running the tests

How you run the test:

Firstly, clone the project from github.

Secondly, install the needed dependencies like jpa, mysql and spring web.

lastly, beside each test there should be a green button you could press to start taht exact test.
