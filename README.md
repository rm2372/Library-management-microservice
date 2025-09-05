# 📚 Library Management System (LMS)

A **modular, microservices-based Library Management System** built with **Spring Boot**, **Eureka Server**, and **Feign Clients**. The project is designed with a **layered architecture** and follows **SOLID principles** to ensure maintainability, scalability, and clean code practices.  

This system is composed of three independent microservices:  
- **Book Service** 📖  
- **User Service** 👤  
- **Library Service** 🏛  

Each microservice is independently deployable, discoverable via **Eureka**, and communicates seamlessly through **Feign clients**.  

---

## 🚀 Features

- **Book Service** → Manage books (add, update, delete, retrieve).  
- **User Service** → Manage users (register, update, delete, fetch).  
- **Library Service** → Handles book-user interactions such as issuing and returning books.  
- **Eureka Server** → Service discovery and registry for all microservices.  
- **Inter-service communication** using Feign clients.  
- **Layered Architecture** → Controller, Service, Repository.  
- **Clean Code & Design Patterns** applied for enterprise-level scalability.  

---

## 🛠 Tech Stack

- **Java 17+**  
- **Spring Boot 3+**  
- **Spring Cloud Netflix Eureka** (Service Discovery)  
- **Spring Cloud OpenFeign** (Inter-service communication)  
- **Spring Data JPA & Hibernate**  
- **H2 / MySQL Database**  
- **Lombok** for boilerplate reduction  
- **Maven** for build management  

---

## 📂 Project Structure

library-management-service/
│── book-service/ # Book microservice
│── user-service/ # User microservice
│── library-service/ # Library microservice (handles book-user interaction)
│── eureka-server/ # Service registry
│── common/ # Shared utilities & configurations
│── README.md # Project documentation


---

## ⚡ Getting Started

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/library-management-service.git
cd library-management-service
2️⃣ Run Eureka Server
cd eureka-server
mvn spring-boot:run

3️⃣ Run Microservices
cd book-service
mvn spring-boot:run

cd ../user-service
mvn spring-boot:run

cd ../library-service
mvn spring-boot:run

🔗 Service Endpoints
Service	Base URL	Description
Book Service	http://localhost:8081	Manage books
User Service	http://localhost:8082	Manage users
Library Service	http://localhost:8083	Handle book-user interactions
Eureka Server	http://localhost:8761	Service discovery dashboard
🎯 Key Learnings

Designed independently scalable microservices.

Applied SOLID principles and layered architecture.

Gained experience with Eureka service discovery.

Implemented Feign clients for seamless inter-service communication.

Simulated real-world enterprise microservice orchestration with proper error handling.
