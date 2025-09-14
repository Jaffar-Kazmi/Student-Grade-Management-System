# Student Grade Management System

## Overview
This is a console-based Java application developed as the first assignment for the **Advanced Computer Programming** course. The system allows users to manage student records including their IDs, names, and marks for three subjects.

## Features

### Core Functionalities
1. **Add Student** - Register new students with unique IDs, names, and marks for 3 subjects
2. **Update Marks** - Modify existing student marks for any subject
3. **Remove Student** - Delete student records from the system
4. **View All Students** - Display complete information for all registered students
5. **Search Student** - Find and display specific student information by ID
6. **Highest Scorer** - Identify student(s) with the highest total marks
7. **Class Average** - Calculate and display average marks per subject across all students

### Data Validation
- Student IDs must be unique
- Marks must be within the range of 0-100
- Prevents duplicate student entries
- Input validation for menu choices and subject numbers

## Technical Specifications

### System Constraints
- **Maximum Students**: 50
- **Subjects per Student**: 3 (fixed)
- **Mark Range**: 0-100
- **Data Storage**: Arrays (in-memory, non-persistent)

### Data Structures Used
- `String[] studentName` - Stores student names
- `int[] studentId` - Stores unique student IDs  
- `double[][] marks` - 2D array storing marks for 3 subjects per student
- `int studentCount` - Tracks current number of students

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Compilation and Execution
```bash
# Compile the program
javac Main.java

# Run the program
java Main
```

### Using the System
1. Run the program
2. Choose from the menu options (1-8)
3. Follow the on-screen prompts
4. Use option 8 to exit the system

## Menu Options

| Option | Function | Description |
|--------|----------|-------------|
| 1 | Add Student | Register new students with ID, name, and 3 subject marks |
| 2 | Update Marks | Modify marks for existing students |
| 3 | Remove Student | Delete student records |
| 4 | View All Students | Display all registered students |
| 5 | Search Student | Find student by ID |
| 6 | Highest Scorer | Show student(s) with highest total marks |
| 7 | Class Average | Calculate average marks per subject |
| 8 | Exit | Close the application |

## Sample Usage

```
Welcome to Student Grade Management System

1. Add Student.
2. Update Marks.
3. Remove Student.
4. View All Students.
5. Search Student by Id.
6. Highest Scorer.
7. Class Average.
8. Exit

Enter your choice: 1

Enter student's Id: 111
Enter students's name: Jaffar Kazmi
Enter marks for subject 1 (0–100): 85
Enter marks for subject 2 (0–100): 92
Enter marks for subject 3 (0–100): 78

Student Added.
Do you want to add another student(yes/no): n
```

## Code Structure

### Main Class Components
- **Static Variables**: Global arrays and counters for data storage
- **addStudent()**: Handles new student registration
- **viewAllStudents()**: Displays all student records
- **updateMarks()**: Updates existing student marks
- **removeStudent()**: Removes student from records
- **searchStudent()**: Searches for specific student
- **highestScorer()**: Finds top-performing student(s)
- **classAverage()**: Calculates subject-wise class averages
- **main()**: Program entry point with menu system

## Limitations

### Current Constraints
- **No Data Persistence**: All data is lost when the program terminates
- **Fixed Subject Count**: Limited to exactly 3 subjects
- **Array Size Limit**: Maximum of 50 students
- **No File I/O**: Cannot import/export student data
- **Console Interface Only**: No graphical user interface

### Potential Improvements
- Add file-based data persistence
- Implement dynamic subject management
- Create a GUI interface
- Add grade calculation and GPA features
- Include data export functionality

## Error Handling
- Duplicate ID prevention
- Mark range validation (0-100)
- Invalid menu choice handling
- Empty dataset checks
- Subject number validation (1-3)

## Assignment Context
This project was developed as part of the **Advanced Computer Programming** course to demonstrate:
- Object-oriented programming concepts
- Array manipulation and data structures
- Input validation and error handling
- Menu-driven program design
- Method organization and modular programming

## Author
Syed Jaffar Raza Kazmi
Created for Advanced Computer Programming Course - Assignment 1

---
*This project serves as a foundation for understanding console-based application development and data management in Java.*
