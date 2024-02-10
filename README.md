
# Selenium with Java Example_Page tests

First Selenium with Java tests. Using a test page: https://automationintesting.com/selenium/testpage/

This project uses:
- assertJ 3.25.2 for Assertions 

- webdrivermanager 5.6.3 for automatic drivers maintenance 

- Selenium 4.12.0







## Running Tests

Currently you can run the test using an IDE (I recommend Intellij IDEA - community edition)

Make sure you have JDK installed on your machine. 

After pulling/downloading the project and opening it in Intellij IDEA (or any other IDE) make sure to change the project's SDK:

Go to File --> Project Structure --> SDK --> Choose Amazon- corretto 19 (it may take a while to install it, so please be patient).

After that the you should be able to just tap the green run button or hit ctrl + R

Tests were developed for Google Chrome, in case, you don't feel like running tests on Chrome, you can use Mozilla Firefox, but, that requires a simple change in the Main class:

@BeforeAll
 static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    chromedriver --> firefoxdriver   

@BeforeEach
     void setup(){
        driver = WebDriverManager.chromedriver().create(); 
    }

    chromedriver --> firefoxdriver 



This should allow you to run those tests with Firefox. 

## Project Status

This project is still a WIP.

In the not so distant future I will probably rewrite the code using POM.

To add: 
Test Runner - mainly to export test results to an HTML format--> I am still doing research

## Authors

- [@martakunszt](https://github.com/martakunszt)

