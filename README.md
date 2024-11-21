# Movie-Ticket-Booking-Project
This is a project created by two students with a goal to develop a backend system for a movie ticket booking platform that allows users to search for movies, book tickets, make payment and view booking history. The project is built using Java and Spring Boot framework.

## Features
* Browse Movies: Users can view a list of available movies.
* Search and Filter: Users can search for movies based on title, date, location, genre and movie ID.
* Movie Details: Users can view detailed information about a specific movie, including title, director, description, genre, date, location, total seats, available seats, and price of ticket.
* Booking Tickets: Users can book tickets for a movie by specifying the movie ID, quantity of tickets, and total price.
* Booking History: Users can view their booking history, which includes details of movies they have booked, such as title, director, description, genre, date, location, booked tickets, and total price.
* Add/Delete/Update Movies: Admin users can add new movies, delete existing movies, and update movie information.

## Technologies
Java,
Spring Boot,
Spring Data JPA,
Postman,
PostgreSQL Database and
Docker


# API Endpoints for Cinema Booking System

## Movie Endpoints

### 1. Get All Movies
**Endpoint:** GET /movie  
**Description:** Retrieves a list of all movies. Supports filtering by title, date, location, and genre.  
**Query Parameters (Optional):**
- `title` (String): Filter movies by title.
- `date` (ISO Date): Filter movies by release date.
- `location` (String): Filter movies by location.
- `genre` (String): Filter movies by genre.  

**Response:** Returns a list of movies matching the specified criteria.

---

### 2. Get Movie by ID
**Endpoint:** GET /movie/{id}  
**Description:** Retrieves details of a specific movie by its ID.  
**Path Parameter:**
- id (Integer): The ID of the movie.  

**Response:** Returns the details of the specified movie.

---

### 3. Add a Movie
**Endpoint:** POST /movie  
**Description:** Adds a new movie to the database.  
**Request Body:**  
json
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

**Response:** Confirms that the movie has been added.

---

### 4. Update a Movie
**Endpoint:** PUT /movie/{movieId}  
**Description:** Updates the details of an existing movie.  
**Path Parameter:**
- movieId (Integer): The ID of the movie to be updated.  

**Request Body:**  
json
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
  
**Response:** Confirms that the movie details have been updated.

---

### 5. Delete a Movie
**Endpoint:** DELETE /movie/{movieId}  
**Description:** Deletes a specific movie by its ID.  
**Path Parameter:**
- movieId (Integer): The ID of the movie to be deleted.  

**Response:** Confirms that the movie has been deleted.

---

## Booking Endpoints

### 6. Book Tickets for a Movie
**Endpoint:** POST /movie/booking/{movieId}/{quantity}/{totalPrice}  
**Description:** Books tickets for a specific movie.  
**Path Parameters:**
- movieId (Integer): The ID of the movie to book tickets for.
- quantity (Integer): The number of tickets to book.
- totalPrice (Integer): The total price of the tickets.  

**Response:** Confirms that the booking has been completed.

---

### 7. View Booking History
**Endpoint:** GET /movie/booking/history  
**Description:** Retrieves the history of previous bookings.  
**Response:** Returns a list of all previous bookings.

---

## Response Formats
- **Success:** 200 OK, along with the requested data or a confirmation message.
- **Error:** Appropriate HTTP status codes (e.g., 404 Not Found, 400 Bad Request).

---
