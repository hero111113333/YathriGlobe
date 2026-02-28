# YathriGlobe - Microservices Travel Management System

YathriGlobe is a comprehensive travel and tourism platform built using a **Microservices Architecture**. The project is designed for high scalability and modularity, leveraging the Spring Cloud ecosystem for service discovery, centralized configuration, and API routing.

## 🏗 Project Architecture

The system consists of 9 specialized services working in orchestration:

| Service Name | Port | Description |
|:--- |:--- |:--- |
| **eureka-server** | 8761 | Service Registry: Allows services to find and communicate with each other. |
| **config-server** | 8888 | Centralized Configuration: Manages external properties for all environments. |
| **api-gateway** | 8080 | Entry Point: Handles routing, security (JWT), and load balancing. |
| **auth-service** | 8081 | Identity Provider: Manages user authentication and JWT generation. |
| **user-profile-service** | 8082 | User Management: Handles personal details and preferences. |
| **Trip-service** | 8083 | Trip Management: Core logic for creating and managing travel itineraries. |
| **Booking-service** | 8084 | Reservation System: Handles bookings and payment processing. |
| **Destination-service** | 8085 | Content Service: Provides details about travel locations and spots. |
| **Review-service** | 8086 | Social Features: Manages user ratings and feedback for trips. |

---

## 🚀 Tech Stack

* **Backend:** Java 17+, Spring Boot 3.x
* **Microservices:** Spring Cloud (Eureka, Config Server, OpenFeign, Gateway)
* **Security:** Spring Security, JWT (JSON Web Tokens)
* **Build Tool:** Maven (Multi-Module Project)
* **Database:** PostgreSQL / MySQL (Per-service data isolation)

---

## 🛠 Getting Started

### Prerequisites
* Java 17 or higher
* Maven 3.8+
* IntelliJ IDEA (Recommended)

### Installation & Run
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/jeevankumardev18/YathriGlobe.git](https://github.com/jeevankumardev18/YathriGlobe.git)
   cd YathriGlobe