# 🏨 Motel Management System - Microservices Architecture

A modular **motel management platform** built using **Spring Boot**, **Kafka**, and **Docker**, organized into multiple microservices with separate databases and event-driven communication.

> This system manages guests, rooms, bookings, and invoicing with scalability, modularity, and modern cloud-native practices.

---

## 📌 Overview

This application is split into **7 independent microservices** communicating asynchronously via **Apache Kafka**, using both **MongoDB** and **PostgreSQL** for persistence, and leveraging Spring Cloud components for service discovery, configuration, and routing.

---

## ✅ Key Features

- 🧑 **Guest Registration** — via `Guest-Service`
- 🛏️ **Room Management** — via `Room-Service`
- 📅 **Booking System** — via `Book-Service`
- 💰 **Automated Invoicing** — via `Invoice-Service`
- ⚙️ **Centralized Config** — via `Server-Config`
- 📡 **Service Discovery** — via `Discovery-Service (Eureka)`
- 🚪 **Smart Routing** — via `Gateway-Service (Spring Cloud Gateway)`

---

## 📦 Microservices Overview

| Microservice      | Tech Stack         | Database     | Port | Description           |
|-------------------|--------------------|--------------|------|-----------------------|
| **Guest-Service** | Spring Boot        | MongoDB      | 8070 | Guest management      |
| **Room-Service**  | Spring Boot        | PostgreSQL   | 8050 | Room management       |
| **Book-Service**  | Spring Boot        | PostgreSQL   | 8066 | Booking system        |
| **Invoice-Service** | Spring Boot      | MongoDB      | 8084 | Invoicing system      |
| **Server-Config** | Spring Cloud Config| N/A          | 8888 | Centralized config    |
| **Discovery-Service** | Eureka Server  | N/A          | 8761 | Service registry      |
| **Gateway-Service** | Spring Cloud Gateway | N/A      | 8777 | API routing gateway   |

---

## ⚙️ Tools & Technologies

- **Backend**: Spring Boot, Spring Cloud (Gateway, Config, Eureka)
- **Messaging**: Apache Kafka (async communication)
- **Databases**:
  - MongoDB (for Guest & Invoice Services)
  - PostgreSQL (for Room & Book Services)
- **Observability**:
  - Spring Boot Actuator (metrics)
  - Zipkin (distributed tracing)
- **Containerization**: Docker, Docker Compose
- **CI/CD** *(optional)*: GitHub Actions / Jenkins

---

## 🚀 Setup & Running

### 🔧 Prerequisites

- Java 17+
- Docker & Docker Compose
- Git

### 🛠️ Running the App

1. **Clone the repository**

```bash
git clone https://github.com/your-username/motel-management-system.git
cd motel-management-system










