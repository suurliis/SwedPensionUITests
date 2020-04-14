# Automation tests for Swedbank's Pension Page UI

This is a suite of automated tests for the UI of the Swedbank's Pension page. 

## Technical background

On a large scale the tests are created in Java and use Cucumber for launching them. Interaction with webelements is done using Selenium. Finally the tests use Junit for assertions. 

For making code more reusable and compact I used some Java libraries like Lombok and Jackson. 

The powerful beast to handle the entire project is Maven.

## Instructions to run the tests:

You will need:
1. Java SE Development Kit installed on your computer 
2. Some IDE (I use Intellij)
3. Driver of either Firefox or Chrome installed on your computer
Note that Selenium expects a specific location for the driver. It varies from one OS to another. For reference, please see: https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver or https://selenium.dev/selenium/docs/api/javascript/module/selenium-webdriver/firefox.html
4. Apache maven installed: https://maven.apache.org/download.cgi

For running tests:
The project can be set using multiple ways. I will not go through all of them, but introduce the way I would do it using Intellij :)
1. Open up your intellij and choose 'Get from Version Control'
2. Version control stays 'Git' and for URL insert: https://github.com/suurliis/SwedPensionUITests.git
3. Git should then notify that you have a new checkout from version control. Choose yes for opening the project
4. New project opens up with option to import changes for Maven projects. This is a Maven project, so choose 'Import changes'
5. Then go to src/test/java/com/liis/runner. There you will find a runner class 'TestRunner' that launches the tests. Right click on the TestRunner class opens a dropdown and by choosing the run the tests, you will launch the test suite. 
If all goes well you just ran your very first testsuite in Chrome. I did say that you can run it using Firefox as well, yes. With that a note on topic configuring tests.

Test configuration:
The tests are configurable by setting VM options. Go to 'Run' > 'Edit configurations'. This opens pop up to set configurations. At the moment there are two options provided: baseUrl and browser. To modify these, copy:
-DbaseUrl=https://www.swedbank.ee/private
-Dbrowser=chrome
.. these parameters to VM options. -DbaseUrl feeds any domain name to test suite. This is handy for an example when the site is deployed to some test enviroment and has a domain set for some test domain name. -dbrowser excepts either 'firefox' or 'browser' as values to launch the tests either with firefox of chrome. By default the tests always run for 'https://www.swedbank.ee/private' and use chrome. 

Reports:
Added HTML reporting for tests. After test run, this can be seen in: /target/cucumber-reports/. Click on index.html there and click to 'Open in browser' and choose the browser you use. This opens a generated html page for the test runs.
