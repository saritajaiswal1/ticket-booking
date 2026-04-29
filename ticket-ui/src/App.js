import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import SearchShows from "./pages/SearchShows";
import Booking from "./pages/Booking";
import Home from "./pages/Home";
import Success from "./pages/Success";
import CreateShow from "./pages/CreateShow";

function App() {
  return (
    <BrowserRouter>
      <Routes>
          {/* Default route */}
                <Route path="/" element={<Navigate to="/search" />} />

                {/* Optional home page (if you really want it) */}
                <Route path="/home" element={<Home />} />

                {/* Browse/Search shows → ShowController */}
                <Route path="/search" element={<SearchShows />} />

                {/* Booking → BookingController */}
                <Route path="/booking" element={<Booking />} />

                {/* Success page */}
                <Route path="/success" element={<Success />} />

                {/* Admin create show → ShowController */}
                <Route path="/create-show" element={<CreateShow />} />
              </Routes>
    </BrowserRouter>
  );
}

export default App;