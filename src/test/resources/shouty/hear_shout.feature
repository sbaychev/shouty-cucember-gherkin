Feature: Hear Shout

  Shouts have a range of approximately 1000m

  Scenario Outline: only hear in-range shouts
    Given Lucy is at 0, 0
    And Sean is at <Seans location>
    When Sean shouts
    Then Lucy should hear <what Lucy hears>
    Examples: some simple examples
      | Seans location | what Lucy hears |
      | 0, 900 | Sean |
      | 800, 800 | nothing |

  Scenario: Slightly Above out of range shout is not heard
    Given Lucy is at 0, 0
    And Sean is at 1001, 1001
    When Sean shouts
    Then Lucy should hear nothing

  Scenario: Slightly Below Top Range shout is heard
    Given Lucy is at 0, 0
    And Sean is at 0, 999
    When Sean shouts
    Then Lucy should hear Sean

  Scenario: Multiple shouters
    Given people are located at
      | name | x | y |
      | Lucy | 0 | 0 |
      | Sean | 0 | 500 |
      | Oscar | 1100 | 0 |
    Given Lucy is at 0, 0
    And Sean is at 0, 500
    And Oscar is at 1100, 0
    When Sean shouts
    And Oscar shouts
    Then Lucy should not hear Oscar
    But Lucy should hear Sean



  Scenario: Shouters should not hear their own shouts
    When Sean shouts
    Then Sean should not hear Sean

