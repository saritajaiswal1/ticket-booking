import { useState } from "react";
import { createBooking } from "../api/api";
import { useNavigate, useSearchParams } from "react-router-dom";

function Booking() {
  const navigate = useNavigate();
  const [params] = useSearchParams();

  const showId = params.get("showId");

  const [form, setForm] = useState({
    userName: "",
    seats: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const payload = {
        showId: Number(showId),
        userName: form.userName,
        seats: form.seats.split(","),
      };

      await createBooking(payload);

      navigate("/success");
    } catch (err) {
      console.error(err);
      alert("Booking failed");
    }
  };

  return (
    <div>
      <h2>Booking for Show ID: {showId}</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="userName"
          placeholder="Your Name"
          onChange={handleChange}
        />

        <input
          type="text"
          name="seats"
          placeholder="Seats (A1,A2)"
          onChange={handleChange}
        />

        <button type="submit">Confirm Booking</button>
      </form>
    </div>
  );
}

export default Booking;