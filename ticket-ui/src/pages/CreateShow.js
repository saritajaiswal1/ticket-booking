import { useState } from "react";
import { createShow } from "../api/api";

function CreateShow() {
  const [form, setForm] = useState({
    movieId: "",
    theatreName: "",
    city: "",
    showTime: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await createShow(form);
      alert("Show created successfully");
    } catch (err) {
      console.error(err);
      alert("Error creating show");
    }
  };

  return (
    <div>
      <h2>Create Show</h2>

      <form onSubmit={handleSubmit}>
        <input
          name="movieId"
          placeholder="Movie ID"
          onChange={handleChange}
        />

        <input
          name="theatreName"
          placeholder="Theatre"
          onChange={handleChange}
        />

        <input
          name="city"
          placeholder="City"
          onChange={handleChange}
        />

        <input
          type="datetime-local"
          name="showTime"
          onChange={handleChange}
        />

        <button type="submit">Create</button>
      </form>
    </div>
  );
}

export default CreateShow;