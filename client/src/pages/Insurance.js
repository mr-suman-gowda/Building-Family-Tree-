import React, { useState, useEffect } from 'react';

import './Insurance.css';

const Insurance = () => {
const [records, setRecords] = useState([]);

useEffect(() => {
    fetch('http://localhost:8081/api/insurances')
      .then(response => response.json())
      .then(data => setRecords(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div className="insurance-container">
      <div className="main-header">
        <div>
          <h2>Insurance Management</h2>
          <p>Manage Insurance records </p>
        </div>
        
      </div>

      <div className="records-box">
        <h3>Insurance Records</h3>
        <table>
          <thead>
            <tr>
              <th>Village Name</th>
              <th>Total Number of Person</th>
              <th>Number of person have Insurance</th>
              <th>Total Insurance Amount</th>
            </tr>
          </thead>
          <tbody>
            {records.length === 0 ? (
              <tr><td colSpan="4" className="no-data">No data available</td></tr>
            ) : (
              records.map((record, index) => (
                <tr key={index}>
                  <td>{record.villageName}</td>
                  <td>{record.totalPersons}</td>
                  <td>{record.insuredPersons}</td>
                  <td>{record.totalInsuranceAmount}</td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>

      
    </div>
  );
};

export default Insurance;
