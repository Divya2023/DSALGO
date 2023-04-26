Feature: Array Page feature file

Scenario: User launch home page of an dsalgo project
    Given  The user is on Signin page of DS Algo portal 
    When The user enter valid "Numpysdet84" and "sdet84batch"
    And The user click on login button
    Then The user redirected to homepage
    
@TS_AR1
Scenario: User navigated to "Arrays" Data Structure Page
Given The user is on the home page after logged in 
When The user selecting Arrays from the drop down menu
Then The user should be directed to "Arrays" Page
    
@TS_AR2
Scenario: The user is able to navigate to Arrays in Python page 
Given The user is on the Array page after logged in
When The user clicks Arrays in Python button 
Then The user should be directed to ArraysinPython 

@TS_AR3
Scenario: The user is able to navigate to a page having an tryEditor from Arrays in Python page
Given The user is on the Arrays in Python page after logged in 
When The user clicks Try Here button on Arrays in Python page
Then The user should be redirected to a page having an tryEditor with a Run button to test

@TS_AR4
Scenario Outline: The user is able run code in tryEditor for Arrays in Python page
Given The user is in a page having an tryEditor with a Run button to test
When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
And The user clicks on run button 
Then The user should be presented with Run result
Examples: 
| Sheetname | RowNumber |
| pythonCode | 0 |

@TS_AR5
Scenario Outline: The user is able run code in tryEditor for Arrays in Python page
Given The user is in a page having an tryEditor with a Run button to test
When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
And The user clicks on run button 
Then The user should be presented with error message
Examples: 
| Sheetname | RowNumber |
| pythonCode | 1 |

@TS_AR6
Scenario: The user is able to navigate to Arrays Using List page
Given The user is on the Array page after logged in
When The user clicks Arrays Using List link
Then The user should be redirected to Arrays Using List page 
@TS_AR7
Scenario: The user is able to navigate to a page having an tryEditor from Arrays Using List page
Given The user is on the Arrays Using List page after logged in 
When The user clicks Try Here button on the Arrays Using List page 
Then The user should be redirected to a page having an tryEditor with a Run button to test 
@TS_AR8
Scenario Outline: The user is able run code in tryEditor for Arrays Using List page
Given The user is in a page having an tryEditor with a Run button to test
When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
And The user clicks on run button 
Then The user should be presented with Run result
Examples: 
| Sheetname | RowNumber |
| pythonCode | 0 |

@TS_AR9
Scenario Outline: The user is able run code in tryEditor for Arrays Using List page page
Given The user is in a page having an tryEditor with a Run button to test
When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
And The user clicks on run button 
Then The user should be presented with error message
Examples: 
| Sheetname | RowNumber |
| pythonCode | 1 |

  @TS_array_10
  Scenario: The user is able to navigate to Practice page
    Given The user is on the Arrays in Python page after logged in
    When The user clicks Practice Questions link
    Then The user should be redirected to Practice page

  @TS_array_11
  Scenario: The user is able to navigate to Question page from Search the array link
    Given The user is on the Practice page after logged in
    When The user clicks the Search the array link
    Then The user should be redirected to question page contains an tryEditor with Run and Submit buttons

  @TS_array_12
  Scenario Outline: The user is able to run code in tryEditor for Search the array link
    Given The user is on Question page of Search the array after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button
    Then The user should be presented with Run result

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |        0 |
   
    @TS_array_13
  Scenario Outline: The user is able to run code in tryEditor for Search the array link
    Given The user is on Question page of Search the array after logged in
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button
    Then The user should be presented with Run result

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         2 |
   




    
 
    
  
  
  
      
