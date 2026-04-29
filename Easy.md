```mermaid
classDiagram
    class User {
        <<Abstract>>
        +String id
        +String password
        +String name
        +login() boolean
    }

    class Student {
        +String studentId
        +List~Enrollment~ enrollments
        +applyForCourse(Course course)
        +viewGrades()
    }

    class Professor {
        +String professorId
        +List~Course~ managedCourses
        +registerCourse(String courseName)
        +inputGrade(Student student, Course course, int score)
    }

    class Course {
        +String courseId
        +String courseName
        +Professor instructor
        +int maxCapacity
        +int currentCapacity
        +isFull() boolean
    }

    class Enrollment {
        +Student student
        +Course course
        +int score
        +String grade
        +calculateGrade(int score) String
    }

    User <|-- Student
    User <|-- Professor
    
    Professor "1" -- "1..3" Course : manages
    Student "1" -- "3..5" Enrollment : takes
    Course "1" -- "30..35" Enrollment : has
    
    note for Enrollment "Grade Logic: \nA >= 90, B >= 80, \nC >= 70, D < 70"
    note for Course "Capacity: 30~35 students"