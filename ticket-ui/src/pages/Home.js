import { useEffect } from "react";

function Home() {
  useEffect(() => {
    window.location.href = "http://localhost:8080/";
  }, []);

  return <p>Redirecting to Swagger...</p>;
}

export default Home;