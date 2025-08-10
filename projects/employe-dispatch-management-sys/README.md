# Employee Dispatch Management System

## Introduction

This is a Java Swing-based employee dispatch management system that supports multi-level permission management
(administrator, manager, supervisor, employee). The system provides functions such as employee dispatch management,
task allocation, and status tracking.

## Features

- Multi-level user permission control
- Employee dispatch task management
- Task status tracking (pending, on duty, completed, canceled)
- Intuitive graphical user interface
- Automatic initialization of test data

## System Requirements

- Java 8 (JDK 1.8)
- Maven (Optional, used for building)

## Quick Start

### Method 1：Use 'Eclipse' to import

1. Clone the repository：
   ```bash
   git clone https://github.com/wensheng-li/java-projects.git
   ```
2. Open Eclipse
3. Select File > Import > Existing Projects into Workspace
4. Select **java-projects/projects/employee-dispatch-management-system** Directory

### Method 2: Command-line build (requires Maven)

```bash
cd java-projects/projects/dispatch-system
mvn clean package
java -jar target/dispatch-system-1.0.0.jar
```

### Run Directly

```bash
cd java-projects/projects/employee-dispatch-management-system/src/main/java
javac com/company/dispatch/ui/MainGUI.java
java com.company.dispatch.ui.MainGUI
```

## Log in credentials

<table>
   <thead>
      <td>Roles</td>
      <td>Username</td>
      <td>Password</td>
   </thead>
    <tr>
        <td>Administrator</td>
        <td>admin</td>
        <td>admin123</td>
    </tr>
    <tr>
        <td>Manager</td>
        <td>manager</td>
        <td>mgr123</td>
    </tr>
    <tr>
        <td>Supervisor</td>
        <td>supervisor</td>
        <td>sup123</td>
    </tr>
    <tr>
        <td>Employee</td>
        <td>employee</td>
        <td>emp123</td>
    </tr>
</table>

## Permission Matrix

<table>
   <thead>
      <td>Features</td>
      <td>Administrator</td>
      <td>Manager</td>
      <td>Supervisor</td>
      <td>Employee</td>
   </thead>
    <tr>
        <td>Create new dispatch tasks</td>
        <td>✅</td>
        <td>✅</td>
        <td>❌</td>
        <td>❌</td>
    </tr> 
    <tr>
        <td>Change the status of all employees</td>
        <td>✅</td>
        <td>❌</td>
        <td>❌</td>
        <td>❌</td>
    </tr>
    <tr>
        <td>Check the dispatch status for all the teams</td>
        <td>✅</td>
        <td>✅</td>
        <td>✅</td>
        <td>❌</td>
    </tr>
    <tr>
        <td>Update status of tasks</td>
        <td>✅</td>
        <td>✅</td>
        <td>✅</td>
        <td>❌</td>
    </tr>
    <tr>
        <td>Check the dispatch status for individual</td>
        <td>✅</td>
        <td>✅</td>
        <td>✅</td>
        <td>✅</td>
    </tr>
    <tr>
        <td>Manage the user accounts</td>
        <td>✅</td>
        <td>❌</td>
        <td>❌</td>
        <td>❌</td>
    </tr>
</table>

## Structure of the project

dispatch-system/  
 ├── src/  
│ └── main/  
│ ├── java/  
│ │ └── com/company/dispatch/  
│ │ ├── auth/ # Authentication  
│ │ ├── employee/ # Employees & Dispatch management  
│ │ └── ui/ # User interface  
│ └── resources/ # Resource documents  
├── docs/ # Other relevant documents  
├── lib/ # Reference Library  
├── .gitignore # Git ignore rules  
├── pom.xml # Maven configurations  
└── README.md # This doc

## License
This project is released under the [MIT License](LICENSE).  
