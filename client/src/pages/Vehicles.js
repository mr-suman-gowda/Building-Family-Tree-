import React, { useState, useEffect } from 'react';
import './Vehicle.css';

const Vehicle = () => {
const [records, setRecords] = useState([]);

    useEffect(() => {
    fetch('http://localhost:8081/api/vehicles')
      .then(response => response.json())
      .then(data => setRecords(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);
  return (
    <div className="vehicle-container">
      <div className="main-header">
        <div>
          <h2>Vehicle Management</h2>
          <p>Manage Vehicle records </p>
        </div>
        
      </div>

      <div className="records-box">
        <h3>Vehicle Records</h3>
        <table>
          <thead>
            <tr>
              <th>Village Name</th>
              <th>Car</th>
              <th>Bike</th>
              <th>Tractor</th>
              <th>Others</th>
            </tr>
          </thead>
          <tbody>
            {records.length === 0 ? (
              <tr><td colSpan="8" className="no-data">No data available</td></tr>
            ) : (
              records.map((record, index) => (
                <tr key={index}>
                  <td>{record.villageName}</td>
                  <td>{record.car}</td>
                  <td>{record.bike}</td>
                  <td>{record.tractor}</td>
                  <td>{record.others}</td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>

      
    </div>
  );
};

export default Vehicle;
