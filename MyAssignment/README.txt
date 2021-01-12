Steps to run the Employee CRUD operation tests.

Prerequisites:
Installed MYSQl server.
Java8
Eclipse/STS IDE

1) Unzip and import the project as Maven into IDE.
2) Right click imported project(MyAssignment) and Run As -> Maven install.
3) Start the spring boot service (MyAssignment) and note the port number.
4) Update port number in TestBase class if it is different from 8080.
5) Run EmployeeControllerTest as JUnit Test (choose JUnit 5 as test runner)

Tests are executed in the order - creates new employee and use the same employee id for the remaining operations.