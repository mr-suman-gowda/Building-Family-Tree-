import React, { useState , useEffect} from 'react';
import './Livestock.css';

const Livestock = () => {
  const [records, setRecords] = useState([]);
 
   useEffect(() => {
      fetch('http://localhost:8081/api/livestocks')
        .then(response => response.json())
        .then(data => setRecords(data))
        .catch(error => console.error('Error fetching data:', error));
    }, []);

  return (
    <div className="livestock-container">
      <div className="main-header">
        <div>
          <h2>Livestock Management</h2>
          <p>Manage Livestock records </p>
        </div>
        
      </div>

      <div className="records-box">
        <h3>Livestock Records</h3>
        <table>
          <thead>
            <tr>
                <th>Village Name</th>
              <th>Cow</th>
              <th>Goat</th>
              <th>Sheep</th>
              <th>Hen</th>
              <th>Total</th>
            </tr>
          </thead>
          <tbody>
            {Array.isArray(records) && records.length > 0 ? (
              records.map((record, index) => (
                <tr key={index}>
                  <td>{record.villageName}</td>
                  <td>{record.cow}</td>
                  <td>{record.goat}</td>
                  <td>{record.sheep}</td>
                  <td>{record.hen}</td>
                  <td>{record.total}</td>
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

export default Livestock;
