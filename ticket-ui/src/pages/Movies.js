import { useNavigate } from "react-router-dom";

function Movies() {
  const navigate = useNavigate();

  const goToShows = (movieId) => {
    navigate(`/shows?movieId=${movieId}`);
  };

  return (
    <div>
      <h2>Select Movie</h2>

      <button onClick={() => goToShows(1)}>Movie 1</button>
      <button onClick={() => goToShows(2)}>Movie 2</button>
    </div>
  );
}

export default Movies;