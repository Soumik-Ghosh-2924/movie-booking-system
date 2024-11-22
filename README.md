# Movie-Booking-System
The project is built using Java and Spring Boot framework.

## Key Features

### 🎥 **Movie Browsing**
- Explore a curated list of movies available for viewing and booking.

### 🔍 **Search and Filter**
- Easily search for movies by:
  - **Title**
  - **Date**
  - **Location**
  - **Genre**
  - **Movie ID**

### 📄 **Detailed Movie Information**
- Access comprehensive details for each movie, including:
  - **Title**  
  - **Director**  
  - **Description**  
  - **Genre**  
  - **Release Date**  
  - **Location**  
  - **Total Seats**  
  - **Available Seats**  
  - **Ticket Price**

### 🎟️ **Ticket Booking**
- Seamlessly book tickets by:
  - Providing the **Movie ID**
  - Specifying the **Number of Tickets**
  - Viewing the **Total Price**

### 📜 **Booking History**
- Review your booking history with details for each movie, including:
  - **Title**  
  - **Director**  
  - **Description**  
  - **Genre**  
  - **Date**  
  - **Location**  
  - **Tickets Booked**  
  - **Total Price**

### 🛠️ **Admin Controls**
- Admin users have additional privileges to:
  - **Add New Movies**
  - **Update Movie Information**
  - **Delete Existing Movies**

## Technologies
* Java,
* Spring Boot,
* Spring Data JPA,
* Postman,
* PostgreSQL Database and
* Docker - have created an image in Docker-Hub.


# API Endpoints for Cinema Booking System

## Movie Endpoints

### 1. Get All Movies
**Endpoint:** `GET /movie`  
**Description:** Retrieves a list of all movies. Supports filtering by title, date, location, and genre.  
**Query Parameters (Optional):**
- `title` (String): Filter movies by title.
- `date` (ISO Date): Filter movies by release date.
- `location` (String): Filter movies by location.
- `genre` (String): Filter movies by genre.  

**Response:** Returns a list of movies matching the specified criteria.

---

### 2. Get Movie by ID
**Endpoint:** `GET /movie/{id}`  
**Description:** Retrieves details of a specific movie by its ID.  
**Path Parameter:**
- `id` (Integer): The ID of the movie.  

**Response:** Returns the details of the specified movie.

---

### 3. Add a Movie
**Endpoint:** `POST /movie`  
**Description:** Adds a new movie to the database.  
**Request Body:**  
```json
{
  "title": "String",
  "director": "String",
  "description": "String",
  "genre": "String",
  "date": "ISO Date",
  "location": "String",
  "totalSeats": "Integer",
  "price": "Integer"
}
```  
**Response:** Confirms that the movie has been added.

---

### 4. Update a Movie
**Endpoint:** `PUT /movie/{movieId}`  
**Description:** Updates the details of an existing movie.  
**Path Parameter:**
- `movieId` (Integer): The ID of the movie to be updated.  

**Request Body:**  
```json
{
  "title": "String",
  "director": "String",
  "description": "String",
  "genre": "String",
  "date": "ISO Date",
  "location": "String",
  "totalSeats": "Integer",
  "price": "Integer"
}
```  
**Response:** Confirms that the movie details have been updated.

---

### 5. Delete a Movie
**Endpoint:** `DELETE /movie/{movieId}`  
**Description:** Deletes a specific movie by its ID.  
**Path Parameter:**
- `movieId` (Integer): The ID of the movie to be deleted.  

**Response:** Confirms that the movie has been deleted.

---

## Booking Endpoints

### 6. Book Tickets for a Movie
**Endpoint:** `POST /movie/booking/{movieId}/{quantity}/{totalPrice}`  
**Description:** Books tickets for a specific movie.  
**Path Parameters:**
- `movieId` (Integer): The ID of the movie to book tickets for.
- `quantity` (Integer): The number of tickets to book.
- `totalPrice` (Integer): The total price of the tickets.  

**Response:** Confirms that the booking has been completed.

---

### 7. View Booking History
**Endpoint:** `GET /movie/booking/history`  
**Description:** Retrieves the history of previous bookings.  
**Response:** Returns a list of all previous bookings.

---

## Response Formats
- **Success:** `200 OK`, along with the requested data or a confirmation message.
- **Error:** Appropriate HTTP status codes (e.g., `404 Not Found`, `400 Bad Request`).

---
