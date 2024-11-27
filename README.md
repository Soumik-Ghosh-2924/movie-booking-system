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


## API-Cinema Endpoints used in the project : 

### 1. Get All Cinemas
**Endpoint:** `GET /cinema`  
**Description:** Retrieves a list of all cinemas. Supports filtering by title, date, location, and genre.  
**Query Parameters (Optional):**
- `title` (String): Filter cinemas by title.
- `date` (ISO Date): Filter cinemas by release date.
- `location` (String): Filter cinemas by location.
- `genre` (String): Filter cinemas by genre.  

**Response:** Returns a list of cinemas matching the specified criteria.

---

### 2. Get Cinema by ID
**Endpoint:** `GET /cinema/{id}`  
**Description:** Retrieves details of a specific cinema by its ID.  
**Path Parameter:**
- `id` (Integer): The ID of the cinema.  

**Response:** Returns the details of the specified cinema.

---

### 3. Add a Cinema
**Endpoint:** `POST /cinema`  
**Description:** Adds a new cinema to the database.  
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
**Response:** Confirms that the cinema has been added.

---

### 4. Update a Cinema
**Endpoint:** `PUT /cinema/{cinemaId}`  
**Description:** Updates the details of an existing cinema.  
**Path Parameter:**
- `cinemaId` (Integer): The ID of the cinema to be updated.  

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
**Response:** Confirms that the cinema details have been updated.

---

### 5. Delete a Cinema
**Endpoint:** `DELETE /cinema/{cinemaId}`  
**Description:** Deletes a specific cinema by its ID.  
**Path Parameter:**
- `cinemaId` (Integer): The ID of the cinema to be deleted.  

**Response:** Confirms that the cinema has been deleted.

---

## Booking Endpoints

### 6. Book Tickets for a Cinema
**Endpoint:** `POST /cinema/booking/{cinemaId}/{quantity}/{totalPrice}`  
**Description:** Books tickets for a specific cinema.  
**Path Parameters:**
- `cinemaId` (Integer): The ID of the cinema to book tickets for.
- `quantity` (Integer): The number of tickets to book.
- `totalPrice` (Integer): The total price of the tickets.  

**Response:** Confirms that the booking has been completed.

---

### 7. View Booking History
**Endpoint:** `GET /cinema/booking/history`  
**Description:** Retrieves the history of previous bookings.  
**Response:** Returns a list of all previous bookings.

---

## Response Formats
- **Success:** `200 OK`, along with the requested data or a confirmation message.
- **Error:** Appropriate HTTP status codes (e.g., `404 Not Found`, `400 Bad Request`).

---
