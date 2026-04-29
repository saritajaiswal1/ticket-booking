import { useEffect, useState } from "react";
import { getShows } from "../api/api";
import { useNavigate, useSearchParams } from "react-router-dom";

function Shows() {
  const [shows, setShows] = useState([]);
  const [params] = useSearchParams();
  const navigate = useNavigate();

  const movieId = params.get("movieId");

  useEffect(() => {
    if (movieId) {
      getShows(movieId)
        .then((res) => setShows(res.data))
        .catch((err) => console.error(err));
    }
  }, [movieId]);

  const handleSelect = (showId) => {
    navigate(`/booking?showId=${showId}`);
  };

  return (
    <div>
      <h2>Available Shows</h2>

      {shows.length === 0 && <p>No shows found</p>}

      {shows.map((show) => (
        <div key={show.id}>
          <p>Theatre: {show.theatreName}</p>
          <p>Time: {show.showTime}</p>
          <button onClick={() => handleSelect(show.id)}>
            Book Now
          </button>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default Shows;