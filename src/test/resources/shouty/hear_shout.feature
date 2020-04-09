Feature: Hear Shout

  Shouts have a range of approximately 1000m

  Scenario: In range shout is heard
    Given Lucy is at 0, 0
    And Sean is at 0, 900
    When Sean shouts
    Then Lucy should hear Sean

  Scenario: Out of range shout is not heard
    Given Lucy is at 0, 0
    And Sean is at 3000, 3000
    When Sean shouts
    Then Lucy should hear nothing

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
    Given Lucy is at 0, 0
    And Sean is at 0, 500
    And Oscar is at 1100, 0
    When Sean shouts
    And Oscar shouts
    Then Lucy should not hear Oscar
    Then Lucy should shout at Oscar
    But Lucy should hear Sean