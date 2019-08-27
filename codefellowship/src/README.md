#CodeFellowship Application
## Challenge Summary
* Run the Spring app
* Create hello world route /hello
* Create a route that turns words into UPPER CASE
* Create a route that reverse the order
* Write a helper method for reverse the order test



Build an app that allows users to create their profile on CodeFellowship.

* splash page at the root route (/) that contains basic information about the site, 
* as well as a link to the “sign up” page.
* An ApplicationUser should have a username, password ( hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.
* The site should allow users to create an ApplicationUser on the “sign up” page.
* The Controller should have an @Autowired 
* The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.
* Include a default profile picture, which is the same for every user, and their basic information.
* Upon logging in, users should be taken to a /myprofile route that displays their information.
* Ensure that user registration also logs users into your app automatically.
* The site should be reasonably styled. (This can be using CSS that you did not create yourself.)
* The site should contain integration testing. At a minimum, there should be tests to ensure basic functionality for the splash page and the sign up page.
## Challenge Description
* Set up html inside templates for router
* Set up Homecontrol.java to add your router functionality

## Approach & Efficiency

#songr
* This repo holds a "RESTful" spring server with multiple get routes.


## Main Files

### config
* UserDetailsServicelmpl
* WebSecurityConfig

### controllers
* HomeController.java
* ApplicationUserController.java


### models
* ApplicationUser
* ApplicationUserRepository
* CodefellowshipApplication

### templates
* login.html
* root.html



### Usage
* git clone repo

* Open terminal, and run this command: ./gradlew bootRun
Routes
* /: will return Home Stub Route
* /login: will take you to login page
* /myprofile: will take you to profile page

* includes POST route to add new albums to the database and redirects to /albums to display

### Reference 
* Class Demo https://github.com/codefellows/seattle-java-401d5/tree/master/class-16/demo/dinosaur