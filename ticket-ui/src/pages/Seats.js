import React, { useEffect, useState } from "react";
import { getSeats } from "../api/api";
import { useParams, useNavigate } from "react-router-dom";

export default function Seats() {
  const { showId } = useParams();
  const [seats, setSeats] = useState([]);
  const [selected, setSelected] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getSeats(showId).then(res => setSeats(res.data));
  }, [showId]);

  const toggle = (id) => {
    setSelected(prev =>
      prev.includes(id)
        ? prev.filter(s => s !== id)
        : [...prev, id]
    );
  };

  return (
    <div>
      <h2>Seats</h2>
      {seats.map(seat => (
        <button key={seat.id} onClick={() => toggle(seat.id)}>
          {seat.number}
        </button>
      ))}

      <button onClick={() =>
        navigate("/booking", { state: { showId, selected } })
      }>
        Book
      </button>
    </div>
  );
}