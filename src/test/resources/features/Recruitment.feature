Feature: Manage Candidates in OrangeHRM Recruitment Module
  As an Admin user ->
  I want to add, shortlist, and manage candidates in the Recruitment section
  So that I can verify the recruitment workflow is functioning correctly

  @Recruitment
  Scenario: Add, shortlist, and manage a candidate
    Given Navigate to the OrangeHRM demo site
    Then Login to OrangeHRM demo as Admin (use the demo credentials shown on the login page)
    Then Open Recruitment → Candidates
    Then Click Add to create a new candidate
    And Fill out the candidate form. Attach a small PDF resume if available
    Then Click Save and verify the candidate appears in the list or grid with correct values
    And Open the candidate’s details and shortlist the candidate
    Then Verify that the candidate is shortlisted
    And Schedule an Interview with two interviewers
    Then Mark interview as passed & failed
    And Search the candidates and see the result