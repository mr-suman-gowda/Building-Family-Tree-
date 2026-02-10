// App.js
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Sidebar from "./components/sidebar";
import Dashboard from "./pages/Dashboard";
import Persons from "./pages/Persons";
import Families from "./pages/Families";
import Education from "./pages/Education";
import Vehicles from "./pages/Vehicles";
import LandRecords from "./pages/LandRecords";
import Insurance from "./pages/Insurance";
import Livestock from "./pages/Livestock";
import "./App.css";
import GraphDesign from "./pages/GraphDesign";
import GraphTreePDF from "./pages/GraphTreePDF";

function App() {
  return (
    <Router>
      <div className="app-container">
        <Sidebar />
        <div className="main-content">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/persons" element={<Persons />} />
            <Route path="/families" element={<Families />} />
            <Route path="/education" element={<Education />} />
            <Route path="/vehicles" element={<Vehicles />} />
            <Route path="/land-records" element={<LandRecords />} />
            <Route path="/insurance" element={<Insurance />} />
            <Route path="/livestock" element={<Livestock />} />
            <Route path="/garph" element={<GraphDesign />} />
            <Route path="/reports" element={<GraphTreePDF />} />
            
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;


