# _Wildlife Tracker_

#### _September, 30th, 2016_

#### By _**Yusuf Qedan**_

## Description

_This is a web page of my wildlife tracker project written in Java using the Spark web application framework and PostgreSQL._

## Setup/Installation Requirements
#### Run the following commands to set up this project:
* In psql: # CREATE DATABASE wildlife_tracker;
* In the shell: $ psql wildlife_tracker < wildlife_tracker.sql
* In psql: # CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
* To test: $ gradle test
* To run: $ gradle run

## Specifications

* Behavior: Park rangers can keep track of animals:
  * **Example input:** "Bald Eagle" "Endangered", "Okay", "Adult"
  * **Example output:** Bald Eagle endangered	adult	okay

* Behavior: Park rangers can keep track of sightings and view them:
  * **Example input:** "Bald Eagle endangered	adult	okay", "Yusuf", "Next to the stream"
  * **Example output:** 12	bald eagle	endangered	newborn	okay	Somewhere	Friday, September 30 2016 04:54 PM

## Known Bugs

_None_

## Support and contact details

_Any issues email me at yusuf9191@gmail.com_

## Technologies Used

_Java, Gradle, Junit, Spark, Velocity, Bootstrap, CSS, HTML, PostgreSQL, sql2o, JavaScript, JQuery_

### License

*This software is licensed under the MIT license*

Copyright (c) 2016 **_Yusuf Qedan_**
