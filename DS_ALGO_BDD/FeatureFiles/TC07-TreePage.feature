Feature: TreePage feature file
 Scenario:  User launch home page of an dsalgo project
    Given The user is on Signin page of DS Algo portal 
    When The user enter valid "Numpysdet84" and "sdet84batch"
    And The user click on login button
    Then The user redirected to homepage

  @TS_Tree_02
  Scenario: The user is able to navigate to Tree Data Structure Page
    Given The user is on the home page after logged in 
    When The user clicks the Tree item from the drop down menu
    Then The user be directed to Tree Page

  @TS_Tree_03
  Scenario: The user is able to navigate to Tree page
    Given The user is on the Tree Page
    When The user clicks Overview of Trees link on Tree page
    Then The user should be redirected to Operations in Tree page

  @TS_Tree_04
  Scenario: The user should be directed to editor page with run button to test python code
    Given The user navigates to overview of Tress in Tree page
    When The user clicks on Tryhere link in Operations in Tree Page
    Then The user should be directed to Editor page with Run button

  @TS_Tree_05
  Scenario Outline: The user is able to run code in Editor for Overview of Trees in Tree page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_Tree_06
  Scenario Outline: The user is presented with error message for invalid code in Editor for Overview of Trees in Tree page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @TS_Tree_07
  Scenario: The user is able to navigate to Tree page and click on Implementation link
    Given The user in editor page and navigates to the Overview of Trees in Tree page
    When The user clicks on Binary Trees link
    Then The user should be redirected to Binary Tree page

  @TS_Tree_08
  Scenario: The user should be directed to editor page with run button to test python code from Binary Tree page
    Given The user is in Binary Tree page
    When The user clicks on Tryhere link on Binary Tree page
    Then The user navigates to Editor page with Run button

  @TS_Tree_09
  Scenario Outline: The user is able to run code in Editor for Binary Tree page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_Tree_10
  Scenario Outline: The user is presented with error message for invalid code in Editor for Binary Tree page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
