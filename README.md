---

# Interview Panel Management System

## Overview

The **Interview Panel Management System** is a Java console application designed to streamline the process of managing interview panels, scheduling interviews, and maintaining candidate records. This application provides functionalities for creating and managing interview panels, scheduling interviews, and keeping track of candidate details.

## Features

### 1. Panel Management

- **Create Interview Panels**: Allows administrators to create new interview panels with specific members.
- **View Panels**: Enables viewing the details of existing interview panels.
- **Update Panel Members**: Allows modification of the members in a panel.

### 2. Interview Scheduling

- **Schedule Interviews**: Allows scheduling interviews for candidates with specific panels.
- **View Scheduled Interviews**: Enables viewing the details of all scheduled interviews.
- **Reschedule Interviews**: Provides functionality to modify the interview schedule.

### 3. Candidate Management
- **Add Candidate Details**: Facilitates adding new candidate information to the system.
- **View Candidate Details**: Allows viewing the details of candidates, including interview status.
- **Update Candidate Records**: Enables updating candidate information and interview status.

## Design Patterns Used

### 1. Singleton Pattern
- **PanelManager Class**: Ensures that only one instance of the PanelManager exists to coordinate the interview panels.

### 2. Factory Pattern
- **InterviewFactory Class**: Used to create different types of interviews based on specific criteria.

### 3. Observer Pattern
- **Notification System**: Implements the observer pattern to notify panel members and candidates about schedule changes.

## Data Structures Used

### 1. ArrayList
- Used to maintain dynamic lists of panels, candidates, and scheduled interviews.

## Object-Oriented Programming (OOP) Concepts

### 1. Classes and Objects
- **Panel Class**: Represents an interview panel with its members.
- **Candidate Class**: Represents a candidate with personal and interview-related details.
- **Interview Class**: Represents an interview with scheduling information.

### 2. Encapsulation
- Data fields in classes like `Panel`, `Candidate`, and `Interview` are encapsulated and accessed via getter and setter methods.

### 3. Inheritance
- **Interview Types**: Different types of interviews (e.g., technical, HR) inherit from a base `Interview` class.

### 4. Polymorphism
- Methods in the `Interview` class can be overridden in subclasses to provide specific functionality for different interview types.

### 5. Abstraction
- **Abstract Classes and Interfaces**: Used to define abstract methods that must be implemented by subclasses, ensuring a consistent interface.

## How to Run

1. **Compile the Program**: Use the following command to compile the Java program:
    ```bash
    javac InterviewPanelMain.java
    ```

2. **Run the Program**: Use the following command to run the compiled Java program:
    ```bash
    java InterviewPanelMain
    ```

## Usage

1. **Create an Interview Panel**: Follow the prompts to enter panel details and add members.
2. **Schedule an Interview**: Enter the candidate ID and panel ID to schedule an interview.
3. **Add Candidate Details**: Enter candidate information such as name, contact details, and position applied for.
4. **View Scheduled Interviews**: Display the list of all scheduled interviews with details.
5. **Update Candidate Records**: Modify candidate information and update their interview status.

## Code Structure

- **InterviewPanelMain.java**: The main file containing the implementation of the interview panel management operations.
  - **PanelManager Class**: Manages the creation and updating of interview panels.
  - **CandidateManager Class**: Manages candidate information and updates.
  - **InterviewScheduler Class**: Handles the scheduling and rescheduling of interviews.
  - **Main Class**: Facilitates user interaction and handles menu options.

## Requirements

- **Java Development Kit (JDK)**: Ensure that JDK is installed on your system to compile and run the program.

## IMAGES

**1) LOGIN**

![LoginPage](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/f2ad584a-3ab2-496f-9893-45431912acbf)

**2) LOGOUT**

![Logout](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/a545002f-6643-46f2-854b-7ea50c08233b)

**3) COMPANY SETUP**

![CompanysetUp](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/adb5aa38-5d69-4ec6-ba93-838f993a93d3)

**4) CANDIADTE ADDING**

![Adding Candidates](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/5d22f7e4-c182-4a6d-b466-789267dd627e)

**5) SEARCHING CADIDATE**

![Searching Candidate](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/a2cf4eb6-ada0-491e-acb7-0c7cc035e4a8)

**6) DISPLAYING CANDIDATE**

![DisplayingAllCandidates](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/74b98f6e-57e2-4ef9-99da-598412a9bd48)

**7) REMOVING CANDIDATES**

![Deleting Candiadtes](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/4235517a-c5bf-4afd-bfc3-8a2b26664abd)

**8) CANDIDATE SRATUS**

![CandidatesStatus](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/c0882f47-86f7-436b-970c-4bf11b79bf94)


**9) ADDING INTERVIEWERS**

![AddingInterviewers](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/561bb06a-4dad-4693-bb91-b11d27a4192d)

**10) DISPLAYING INTERVIEWER**

![DisplaynigInterviewers](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/50007f09-8c42-4294-ac4b-3b5de54386b2)

**11) SEARCHING INTERVIEWER**

![SearchingInterviewers](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/bf37bd8a-84a5-4ea9-a03f-7d8231fbd202)

**12) DELETING INTERVIEWER***

![Deleting Interviewers](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/424b509f-42f4-418a-a9ae-f3cd79d42245)

**13) CONDUCTING INTERVIEW**

![ConductingInterview](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/c2ce584e-6f07-42c5-9323-67fc03d65247)

**14) REDIRECTING TO PAGES**

![RedirectingToMainPage](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/f58c0220-dfde-4b5c-afe0-66b12c5eb7e7)

![toMainPage](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/6d0274f1-7ad3-43d4-87a4-2414915bc960)

**15) EXIT**

![LogOut Page](https://github.com/saravanan2047/InterviewPanelManagementSystem/assets/95707512/675e0643-e6cf-4cc0-863d-0ebd28ed3469)



## Contributions

Contributions are welcome! Feel free to fork the repository, submit pull requests, or open issues to discuss potential changes and improvements.

## License

This project is open-source and available under the MIT License.

---
