# Doctor Application

## Overview

This Doctor Application provides a platform for doctors to register and manage their patients. The application includes functionality to add doctors and patients, associate symptoms with specialties, and suggest doctors based on patient symptoms and location.

## Technologies Used

- **Spring Boot**: For creating RESTful APIs.
- **Hibernate**: For ORM (Object Relational Mapping).
- **H2 Database**: An in-memory database for development and testing.
- **Lombok**: To reduce boilerplate code.
- **Swagger**: For API documentation.
- **Gradle**: For project build and dependency management.

## Dependencies

The project uses the following dependencies:

```groovy```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'com.h2database:h2'
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}


Running the Application
Prerequisites
Ensure you have Java Development Kit (JDK) installed.
Ensure you have Gradle installed. If not, you can use the Gradle wrapper provided in the project.
Building and Running


Clone the repository:
git clone https://github.com/iKunal1/Java-Assignment-final
cd DoctorApplication



Build the project using Gradle:
./gradlew build


Run the application:
./gradlew bootRun




API Endpoints
Doctor Endpoints
Add a Doctor

URL: /api/doctors
Method: POST
Payload:

POST : http://localhost:8080/api/doctors

/api/doctors
  {
    "name": "Kunal Singh",
    "city": "NOIDA",
    "email": "kunalsingh@example.com",
    "phoneNumber": "0987654321",
    "symptom": "Arthritis"
  }


Patient Endpoints
Add a Patient

URL: /api/patients
Method: POST

POST : http://localhost:8080/api/patients
  
  {
    "name": "Rohit Sharma",
    "city": "Gurgaon",
    "email": "RohitSharma@example.com",
    "phoneNumber": "0987654321",
    "symptom": "Arthritis"
  }



Edge Cases
No Doctor in Patient's Location:

Response: We are still waiting to expand to your location
No Doctor for Patient's Symptom in Location:

Response: There isn’t any doctor present at your location for your symptom


![image](https://github.com/iKunal1/Java-Assignment-final/assets/78819195/fe609e99-98c0-40e3-bc6f-7ca1f3acbbdd)
![image](https://github.com/iKunal1/Java-Assignment-final/assets/78819195/78974a23-ee15-45dd-8425-d35a788b6989)


