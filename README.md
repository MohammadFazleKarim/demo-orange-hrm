# OrangeHRM Automation Framework

This repository contains a **Selenium WebDriver + Cucumber + TestNG automation framework** for testing the **OrangeHRM demo site** ([https://opensource-demo.orangehrmlive.com/](https://opensource-demo.orangehrmlive.com/)).  
It follows **Page Object Model (POM)** and BDD approach using **Cucumber**, and generates **HTML/JSON reports**.


---

## **Table of Contents**

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Project Structure](#project-structure)  
- [Setup & Installation](#setup--installation)  
- [Execution](#execution)  
- [Test Reports](#test-reports)  
- [Screenshots](#screenshots)  
- [Assumptions & Known Issues](#assumptions-known-issues)


---

## **Features**

- Navigate and login to OrangeHRM demo site.  
- Add and shortlist candidates in the Recruitment module.  
- Uses **Page Object Model (POM)** for maintainability.  
- Reusable `ElementActions` utility class for Selenium & Actions class methods.  
- Supports file upload and few mouse & keyboard actions.  
- Generates **HTML & JSON reports**.  


---

## **Tech Stack**

- **Java 21**  
- **Selenium 4.36**  
- **Cucumber 7.x**  
- **TestNG 7.x**  
- **JUnit 5 (for Cucumber suite)**   
- **Maven 4.x**  


---

## **Project Structure**

demo-orange-hrm/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   │   └── Hooks.java                     # Setup & teardown (Before/After hooks)
│       │   │
│       │   ├── pages/                             # Page Object classes (POM)
│       │   │   ├── AddCandidatePage.java          # Handles Add Candidate form
│       │   │   ├── CandidateDetailPage.java       # Candidate detail actions (shortlist, interview)
│       │   │   ├── CandidatesPage.java            # Candidate list and verification
│       │   │   ├── DashboardPage.java             # Admin dashboard actions
│       │   │   └── LoginPage.java                 # Login page actions
│       │   │
│       │   ├── runner/
│       │   │   └── RunCucumberTest.java           # JUnit 5 Cucumber test runner
│       │   │
│       │   ├── stepDefinitions/
│       │   │   └── RecruitmentSteps.java          # Step definitions linked to Recruitment.feature
│       │   │
│       │   └── utils/                             # Utility classes (support layer)
│       │       ├── ConfigReader.java              # Reads config.properties
│       │       ├── DriverFactory.java             # WebDriver initialization (multi-browser)
│       │       └── ElementActions.java            # Reusable Selenium actions (click, type, keys)
│       │
│       └── resources/
│           ├── features/
│           │   └── Recruitment.feature             # BDD feature file for recruitment workflow
│           │
│           ├── properties/
│           │   └── config.properties               # Configuration (URL, browser, credentials)
│           │
│           └── testData/
│               └── TestSample.docx                 # Sample resume file for upload test
│
├── target/                                        # Test reports, screenshots, compiled classes
│   ├── cucumber.json
│   ├── cucumber-report.html
│   ├── screenshots/
│   └── test-classes/
│
├── .gitignore                                     # Git ignore rules
├── pom.xml                                        # Maven dependencies and plugins
└── README.md                                      # Project documentation


---

## **Setup & Installation**  

1. Clone the repository:

   ~~ bash
   git clone https://github.com/MohammadFazleKarim/demo-orange-hrm.git
   
2. Open the project in IntelliJ IDEA or Eclipse.

3. Ensure Java 21 and Maven are installed:
 
   ~~ bash
   java -version
   mvn -version


---

## **Execution**

1. Run via Maven:
   ~~ bash
   mvn clean test

2. Run specific Cucumber runner:
   ~~ bash
   mvn clean test -Dtest="runner.RunCucumberTest"

3. Or Manually run the RunCucumberTest class


---

## **Test Reports**

- HTML Report: **target/cucumber-report.html**

- JSON Report: **target/cucumber.json**


---

## **Screenshots**

You can capture screenshots on test failure using Hooks **(@AfterStep)**, and they will be stored in **target/screenshots**.


---

## **Assumptions & Known Issues**

### Assumptions
- Admin credentials (Admin / admin123) are valid and not changed.
- The Recruitment module is accessible to the Admin user.
- Admin can add a new candidate.
- Candidates list gets updated after any insertion.
- Candidate details can be viewed and shortlisted.
- Admin can schedule an interview.
- Admin can update the status of the interview as Passed / Failed.
- Admin can search and view the interview result.

### Known Issues
- Logging into demo site using username - Admin, can be used as lowercase letter like username - admin.
- While adding candidate, Contact Number field taking 25 characters.
- Under Consent to keep data showing required, but it is not.
- Email and Contact number can be reused for another candidate.
- The demo site resets data regularly, so created candidates might disappear.
- While shortlisting the initiated candidate, unexpected error occuring. Sometimes existing candidate can be shortlisted.
- The site is sometimes slow — you need explicit waits for some elements.
- As candidate cannot be shortlisted, admin cannot schedule an interview or update interview status and see the result.
- While searching by Candidate Name, first shows 'No records found' and if I forcibly search by Candidate Name, then shows invalid for Candidate Name field.


---
