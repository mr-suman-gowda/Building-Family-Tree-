import React, { useState, useEffect } from 'react';
import './Education.css';

const Education = () => {
const [records, setRecords] = useState([]);

useEffect(() => {
    fetch('http://localhost:8081/api/educations')
      .then(response => response.json())
      .then(data => setRecords(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);
  return (
    <div className="education-container">
      <div className="main-header">
        <div>
          <h2>Education Management</h2>
          <p>Manage Education records </p>
        </div>
        
      </div>

      <div className="records-box">
        <h3>Education Records</h3>
        <table>
          <thead>
            <tr>
              <th>Village Name</th>
              <th>Graduated</th>
              <th>Studing</th>
              <th>Illiterate</th>
            </tr>
          </thead>
          <tbody>
            {Array.isArray(records) && records.length > 0 ? (
              records.map((record, index) => (
                <tr key={index}>
                  <td>{record.villageName}</td>
                  <td>{record.graduated}</td>
                  <td>{record.studying}</td>
                  <td>{record.illiterate}</td>
                </tr>))
            ) : (
              <tr>
                <td colSpan="9" className="no-data">
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

export default Education;
