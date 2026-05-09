import { useState } from "react";
import { searchShows } from "../api/api";
import { useNavigate } from "react-router-dom";

function SearchShows() {
  const [city, setCity] = useState("Bangalore");
  const [movieId, setMovieId] = useState("");
  const [date, setDate] = useState("");
  const [shows, setShows] = useState([]);

  const navigate = useNavigate();

  const handleSearch = async () => {
    try {
      console.log("Sending request:", { city, movieId, date });

      const res = await searchShows(city, movieId, date);

      const formattedShows = res.data.map((show) => ({
        id: show.id,
        theatreName: show.theatre_id,
        showTime: show.start_time
      }));

      setShows(formattedShows);
    } catch (err) {
      console.error("API Error:", err);
      alert("Error fetching shows");
    }
  };

  const handleBook = (showId) => {
    navigate(`/booking?showId=${showId}`);
  };

  return (
    <div>
      <h2>Search Shows</h2>

      {/* City */}
      <input
        value={city}
        onChange={(e) => setCity(e.target.value)}
        placeholder="City"
      />

      {/* Movie ID */}
      <input
        value={movieId}
        onChange={(e) => setMovieId(e.target.value)}
        placeholder="Movie ID (e.g. M1)"
      />

      {/* Date */}
      <input
        type="date"
        value={date}
        onChange={(e) => setDate(e.target.value)}
      />

      <button onClick={handleSearch}>Search</button>

      <hr />

      {/* No results */}
      {shows.length === 0 && <p>No shows found</p>}

      {/* Show results */}
      {shows.map((show) => (
        <div key={show.id}>
          <p><b>Theatre:</b> {show.theatreName}</p>
          <p><b>Time:</b> {new Date(show.showTime).toLocaleString()}</p>
          <button onClick={() => handleBook(show.id)}>
            Book
          </button>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default SearchShows;