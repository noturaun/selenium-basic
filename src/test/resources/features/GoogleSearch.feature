Feature: Test Search feature
  Scenario Outline: Search for certain keyword
    Given '<actor>' on Google homepage
    When s?he enter search '<keyword>'
    Then s?he should be redirected to result page for '<keyword>' or '<alt>'
    Examples:
      | actor | keyword | alt   |
      | Budi  | Panda   | panda |