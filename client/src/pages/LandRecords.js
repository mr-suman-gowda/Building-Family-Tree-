import React, { useState, useEffect } from 'react';
import './LandRecords.css';

const LandRecords = () => {
const [records, setRecords] = useState([]);

useEffect(() => {
    fetch('http://localhost:8081/api/lands')
      .then(response => response.json())
      .then(data => setRecords(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div className="landRecords-container">
      <div className="main-header">
        <div>
          <h2>LandRecords Management</h2>
          <p>Manage LandRecords records </p>
        </div>
        
      </div>

      <div className="records-box">
        <h3>LandRecords Records</h3>
        <table>
          <thead>
            <tr>
              <th>Servey Number</th>
              <th>Village</th>
              <th>Area(Acres)</th>
              <th>Area(Gunta)</th>
              <th>Water Source</th>
              <th>Total Area</th>
            </tr>
          </thead>
          <tbody>
            {Array.isArray(records) && records.length > 0 ? (
              records.map((record, index) => (
                <tr key={index}>
                  <td>{record.surveyNumber}</td>
                  <td>{record.village}</td>
                  <td>{record.acres}</td>
                  <td>{record.gunta}</td>
                  <td>{record.waterSource}</td>
                  <td>{record.totalArea}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="6" className="no-data">
                  No data available
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      
    </div>
  );
};

export default LandRecords;
