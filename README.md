Motel Management System - Microservices Architecture
A modular system built with Spring Boot, Docker, and microservices

📌 Overview
This project is a motel management application decomposed into 7 interconnected microservices using Spring Boot, Docker, Kafka, and multiple databases (MongoDB, PostgreSQL).

🚀 Key Features
✅ Guest registration via Guest-Service
✅ Room management (types, availability) via Room-Service
✅ Booking system via Book-Service
✅ Automated invoicing via Invoice-Service
✅ Centralized configuration with Server-Config
✅ Dynamic service discovery via Discovery-Service (Eureka)
✅ Smart routing via Gateway-Service (Spring Cloud Gateway)

📦 Microservices Architecture
Microservice	    Technology	   Database	             Port	          Description
Guest-Service	    Spring Boot    MongoDB	             8070	          Guest management
Room-Service	    Spring Boot	   PostgreSQL	           8050	          Room management
Book-Service	    Spring Boot	   PostgreSQL	           8066	          Booking system
Invoice-Service	  Spring Boot	   MongoDB	             8084	          Invoicing
Server-Config	    Spring Cloud   Config	               8888           Local
Discovery-Service	Spring Cloud   Eureka Server	-	     8761	          Service registry
Gateway-Service	  Spring Cloud   Gateway	             8777	          API routing

⚙️ Tools & Technologies
Backend: Spring Boot, Spring Cloud (Gateway, Config, Eureka)

Databases: MongoDB (Invoice/Guest), PostgreSQL (Room/Book)

Messaging: Kafka (async communication)

Observability: Zipkin (tracing), Actuator (metrics)

Containerization: Docker, Docker Compose

CI/CD: (Optional) GitHub Actions / Jenkins


🚀 Setup & Running
1. Prerequisites
Java 17+

Docker & Docker Compose

Git









