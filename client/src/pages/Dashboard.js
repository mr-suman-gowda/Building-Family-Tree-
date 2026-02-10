// src/pages/Dashboard.js
import React, { useState, useEffect } from "react";
import "./Dashboard.css";
import { FaUsers, FaCar, FaMapMarkedAlt } from "react-icons/fa";
import { AiOutlineHome } from "react-icons/ai";

function Dashboard() {
  const [totalPersons, setTotalPersons] = useState(null);
  const [totalFamily, setTotalFamily] = useState(null);
  const [totalLandArea, setTotalLandArea] = useState(null);
  const [totalVehicles, setTotalVehicles] = useState(null);
  const [records, setRecords] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8081/api/totalPersons")
      .then((response) => response.json())
      .then((data) => {
        if (typeof data === "object") {
          setTotalPersons(data.total || 0);
        } else {
          setTotalPersons(data);
        }
      })
      .catch((error) => {
        console.error("Error fetching totalPersons:", error);
        setError(error);
      });
  }, []);

  useEffect(() => {
    fetch("http://localhost:8081/api/totalFamilies")
      .then((response) => response.json())
      .then((data) => {
        if (typeof data === "object") {
          setTotalFamily(data.total || 0);
        } else {
          setTotalFamily(data);
        }
      })
      .catch((error) => {
        console.error("Error fetching totalFamilies:", error);
        setError(error);
      });
  }, []);

  useEffect(() => {
    fetch("http://localhost:8081/api/totalLandArea")
      .then((response) => response.json())
      .then((data) => {
        if (typeof data === "object") {
          setTotalLandArea(data.total || 0);
        } else {
          setTotalLandArea(data);
        }
      })
      .catch((error) => {
        console.error("Error fetching totalLandArea:", error);
        setError(error);
      });
  }, []);

  useEffect(() => {
    fetch("http://localhost:8081/api/totalVehicles")
      .then((response) => response.json())
      .then((data) => {
        if (typeof data === "object") {
          setTotalVehicles(data.total || 0);
        } else {
          setTotalVehicles(data);
        }
      })
      .catch((error) => {
        console.error("Error fetching totalVehicles:", error);
        setError(error);
      });
  }, []);

  useEffect(() => {
    fetch("http://localhost:8081/api/families")
      .then((response) => response.json())
      .then((data) => {
        console.log("Fetched data:", data);
        setRecords(data);
      })
      .catch((error) => {
        console.error("Error fetching family records:", error);
        setError(error);
      });
  }, []);

  return (
    <div className="dashboard">
      <h2 className="dashboard-title">Dashboard</h2>
      <p className="dashboard-subtitle">
        Overview of family records and system statistics
      </p>

      {error && (
        <div className="error-message">
          <strong>Error:</strong> {error.message || JSON.stringify(error)}
        </div>
      )}

      {/* Top Stat Cards */}
      <div className="stats">
        <div className="stat-card blue">
          <FaUsers className="icon" />
          <div>
            <h4>Total Persons</h4>
            <p>{totalPersons !== null ? totalPersons : "Loading..."}</p>
          </div>
        </div>

        <div className="stat-card green">
          <AiOutlineHome className="icon" />
          <div>
            <h4>Total Families</h4>
            <p>{totalFamily !== null ? totalFamily : "Loading..."}</p>
          </div>
        </div>

        <div className="stat-card orange">
          <FaMapMarkedAlt className="icon" />
          <div>
            <h4>Land Records</h4>
            <p>
              {totalLandArea !== null ? `${totalLandArea} Acres` : "Loading..."}
            </p>
          </div>
        </div>

        <div className="stat-card purple">
          <FaCar className="icon" />
          <div>
            <h4>Vehicles</h4>
            <p>{totalVehicles !== null ? totalVehicles : "Loading..."}</p>
          </div>
        </div>
      </div>

      {/* Bottom Cards */}
      <div className="bottom-section">
        <div className="village-distribution">
          <h3>Village Distribution</h3>
          {Array.isArray(records) && records.length > 0 ? (
            records.map((record, index) => (
              <div className="village-row" key={index}>
                <span>{record.villageName}</span>
                <div className="bar">
                  <div
                    className="fill"
                    style={{
                      width: `${
                        totalPersons && record.totalMembers
                          ? (record.totalMembers / totalPersons) * 100
                          : 0
                      }%`,
                    }}
                  ></div>
                </div>
                <span>{record.totalMembers}</span>
              </div>
            ))
          ) : (
            <div className="village-row">
              <span className="no-data">No data available</span>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
