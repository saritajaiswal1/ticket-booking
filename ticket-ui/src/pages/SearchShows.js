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
      const res = await searchShows(city, movieId, date);
      setShows(res.data);
    } catch (err) {
      console.error(err);
      alert("Error fetching shows");
    }
  };

  const handleBook = (showId) => {
    navigate(`/booking?showId=${showId}`);
  };

  return (
    <div>
      <h2>Search Shows</h2>

      <input
        value={city}
        onChange={(e) => setCity(e.target.value)}
        placeholder="City"
      />

      <input
        value={movieId}
        onChange={(e) => setMovieId(e.target.value)}
        placeholder="Movie ID"
      />

      <input
        type="date"
        value={date}
        onChange={(e) => setDate(e.target.value)}
      />

      <button onClick={handleSearch}>Search</button>

      <hr />

      {shows.map((show) => (
        <div key={show.id}>
          <p>Theatre: {show.theatreName}</p>
          <p>Time: {show.showTime}</p>
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