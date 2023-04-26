Feature: StackPage feature file
 Scenario:  User launch home page of an dsalgo project
    Given The user is on Signin page of DS Algo portal 
    When The user enter valid "Numpysdet84" and "sdet84batch"
    And The user click on login button
    Then The user redirected to homepage

  @TS_graph_02
  Scenario: The user is able to navigate to Stack Data Structure Page
    Given The user is on the home page after logged in 
    When The user clicks the Stack item from the drop down menu
    Then The user be directed to Stack Page

  @TS_graph_03
  Scenario: The user is able to navigate to Stack page
    Given The user is on the Stack Page
    When The user clicks Operations in Stack link on Stack page
    Then The user should be redirected to Operations in Stack page

  @TS_graph_04
  Scenario: The user should be directed to editor page with run button to test python code
    Given The user navigates to Operations in Stack page
    When The user clicks on Tryhere link in Operations in Stack Page
    Then The user should be directed to Editor page with Run button

  @TS_graph_05
  Scenario Outline: The user is able to run code in Editor for Operations in Stack page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_graph_06
  Scenario Outline: The user is presented with error message for invalid code in Editor for Operations in Stack page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @TS_graph_07
  Scenario: The user is able to navigate to Stack page and click on Implementation link
    Given The user in editor page and navigates to the Operations in Stack page
    When The user clicks on Implementation link
    Then The user should be redirected to Implementation page

  @TS_graph_08
  Scenario: The user should be directed to editor page with run button to test python code from Implementation page
    Given The user is in Implementation page
    When The user clicks on Tryhere link on Implementation representations page
    Then The user navigates to Editor page with Run button

  @TS_graph_09
  Scenario Outline: The user is able to run code in Editor for Implementation page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_graph_10
  Scenario Outline: The user is presented with error message for invalid code in Editor for Implementation page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
