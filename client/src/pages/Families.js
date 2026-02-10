import React, { useState, useEffect } from 'react';
import './FamilyRecords.css';

const FamilyRecords = () => {
  const [records, setRecords] = useState([]);

useEffect(() => {
    fetch("http://localhost:8081/api/families")
      .then((response) => response.json())
      .then((data) => {
        console.log("Fetched data:", data);
        setRecords(data);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  return (
    <div className="family-container">
      <div className="main-header">
        <div>
          <h2>Families Management</h2>
          <p>Manage family records and relationships</p>
        </div>
      </div>

      <div className="records-box">
        <h3>Family Records</h3>
        <table>
          <thead>
            <tr>
              <th>Village Name</th>
              <th>Children (0-18)</th>
              <th>Adults (18+)</th>
              <th>Total Members</th>
            </tr>
          </thead>
          
          <tbody>
            {Array.isArray(records) && records.length > 0 ? (
              records.map((record, index) => (
                <tr key={index}>
                  <td>{record.villageName}</td>
                  <td>{record.total_0_18}</td>
                  <td>{record.total_18_plus}</td>
                  <td>{record.totalMembers}</td>
                </tr>
              ))
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

export default FamilyRecords;
