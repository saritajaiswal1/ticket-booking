import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080",
});

export const createBooking = (data) =>
  API.post("/api/bookings", data);

// GET /api/shows?movieId=1
export const getShows = (movieId) =>
  API.get("/api/shows", { params: { movieId } });

  // GET /api/v1/shows/search
  export const searchShows = (city, movieId, date) =>
    API.get("/api/v1/shows/search", {
      params: { city, movieId, date },
    });

  // POST /api/v1/shows/createShow
  export const createShow = (data) =>
    API.post("/api/v1/shows/createShow", data);

//export const getMovies = () => API.get("/api/v1/shows/search");

/**export const searchShows = (city, movieId, date) =>
  API.get("/api/v1/shows/search", { params: { city, movieId, date } });

export const getMovies = () => API.get("/api/v1/shows/search");
export const createBooking = (data) => API.post("/api/bookings", data);

export const getSeats = (showId) =>
  API.get(`/api/shows/${showId}/seats`);**/

/**export const searchShows = (city, movieId, date) =>
  API.get("/shows/search", { params: { city, movieId, date } });



export const createBooking = (data) =>
  API.post("api/bookings", data);**/