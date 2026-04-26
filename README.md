👨‍💻 Author
Sarita Jaiswal

A 🎬 Movie Ticket Booking System

A Spring Boot–based backend application for booking movie tickets.
It supports browsing shows, selecting seats, applying pricing strategies, and booking tickets.

🚀 Features
🎥 Browse shows by city, movie, and date
🎟️ Book seats for a show
💰 Dynamic pricing strategy (based on offer type)
🔒 Seat locking with optimistic locking
📊 REST APIs with Swagger UI
🗄️ PostgreSQL database integration
🛠️ Tech Stack
Java 17
Spring Boot 3.x
Spring Web
Spring Data JPA
PostgreSQL
Maven
Swagger (OpenAPI)
📂 Project Structure
com.ticket.booking
│── controller        # REST Controllers
│── service           # Business Logic
│── repository        # JPA Repositories
│── model             # Entity Classes
│── pricing           # Pricing Strategy Pattern
│── config            # Configurations (CORS, Swagger, etc.)