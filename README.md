## 👩‍💻 Author
**Sarita Jaiswal**

------------------------

Acces UI : http://localhost:8080/swagger-ui/index.html#

# 🎬 Movie Ticket Booking System

A Spring Boot–based backend application for booking movie tickets.  
It supports browsing shows, selecting seats, applying pricing strategies, and booking tickets.

---

## 🚀 Features
- 🎥 Browse shows by city, movie, and date  
- 🎟️ Book seats for a show  
- 💰 Dynamic pricing strategy (based on offer type)  
- 🔒 Seat locking with optimistic locking  
- 📊 REST APIs with Swagger UI  
- 🗄️ PostgreSQL database integration  

---

## 🛠️ Tech Stack
- Java 17  
- Spring Boot 3.x  
- Spring Web  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Swagger (OpenAPI)  

---

## 📂 Project Structure

com.ticket.booking

│── controller # REST Controllers

│── service # Business Logic

│── repository # JPA Repositories

│── model # Entity Classes

│── pricing # Pricing Strategy Pattern

│── config # Configurations (CORS, Swagger, etc.)


---

## ▶️ How to Run
```bash
mvn clean install
mvn spring-boot:run

=======================================================================
# 🎟️ Ticket Booking React UI

This React application provides a UI for browsing shows, booking tickets, and creating shows.
It integrates with a Spring Boot backend.

---

# ⚙️ Tech Stack

* React
* Axios (API calls)
* React Router (navigation)

---

# 🚀 How to Run

### 1. Start Backend

Make sure your Spring Boot app is running on:

```
http://localhost:8080
```

---

### 2. Start React App

```bash
npm install
npm start
```

App runs on:

```
http://localhost:3000
```

---

# 🔗 Frontend Routes

| Route               | Description                    |
| ------------------- | ------------------------------ |
| `/`                 | Redirects to search page       |
| `/search`           | Search shows (Browse shows)    |
| `/booking` | Book tickets for selected show |
| `/success`          | Booking confirmation page      |
| `/create-show`      | Create a new show (admin)      |
| `/home`             | Optional home page             |

---

# 🔌 Backend API Mapping

## 1. Search Shows

**Controller:** ShowController
**Endpoint:**

```
GET /api/v1/shows/search
```

**Query Params:**

* `city` (default: Bangalore)
* `movieId` (required)
* `date` (optional: yyyy-MM-dd or yyyy-MM-ddTHH:mm:ss)

**Example:**

```
http://localhost:8080/api/v1/shows/search?city=Bangalore&movieId=1&date=2025-01-01
```

**React Usage:**

```js
searchShows(city, movieId, date);
```

---

## 2. Create Show

**Endpoint:**

```
POST /api/v1/shows/createShow
```

**Request Body:**

```json
{
  "movieId": "1",
  "theatreName": "PVR",
  "city": "Bangalore",
  "showTime": "2025-01-01T18:00:00"
}
```

---

## 3. Booking Tickets

**Controller:** BookingController

**Endpoint:**

```
POST /api/bookings
```

**Request Body:**

```json
{
  "showId": 10,
  "userName": "John",
  "seats": ["A1", "A2"]
}
```

---

# 🔄 Application Flow

```
/search → fetch shows → select show  
→ /booking → submit booking  
→ /success
```

---

# 📁 Project Structure

```
src/
 ├── api/
 │    └── api.js
 ├── pages/
 │    ├── SearchShows.js
 │    ├── Booking.js
 │    ├── Success.js
 │    ├── CreateShow.js
 │    └── Home.js
 ├── App.js
```

---

# ⚠️ Common Issues

### 1. Blank Screen

* Ensure `/` redirects to `/search`
* Check browser console for errors

---

### 2. API Not Working

* Verify backend is running on port `8080`
* Ensure correct base URL in `api.js`:

```js
baseURL: "http://localhost:8080"
```

---

### 3. 404 Errors

* Use correct API paths:

  * `/api/v1/shows/search`
  * `/api/bookings`

---

### 4. Booking Failure

* Ensure request format:

```json
{
  "showId": number,
  "userName": string,
  "seats": array
}
```

---

# 🧠 Notes

* React routes are **not backend endpoints**
* API calls are handled via Axios inside components
* Query parameters (`movieId`, `showId`) are passed via URL

---

# ✅ Future Enhancements

* Movie dropdown instead of manual `movieId`
* Seat selection UI (grid)
* Authentication & user login
* UI styling (Material UI / Bootstrap)

---

Ticket Booking UI - React Integration with Spring Boot

