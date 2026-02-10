import React, { useState } from 'react';
import axios from 'axios';

const GraphTreePDF = () => {
  const [villageName, setVillageName] = useState('');
  const [familyHeadId, setFamilyHeadId] = useState('');
  const [data, setData] = useState([]);

  const searchVillage = async () => {
    try {
      const res = await axios.get(`http://localhost:8081/api/villageGraph/${villageName}`);
      setData(res.data);
    } catch (err) {
      console.error('Error fetching village data:', err);
    }
  };

  const searchFamily = async () => {
    try {
      const res = await axios.get(`http://localhost:8081/api/familyGraph/${familyHeadId}`);
      setData(res.data);
    } catch (err) {
      console.error('Error fetching family data:', err);
    }
  };

  return (
    <div style={{ padding: '20px' }}>
      <h2>Village Family Tree Report</h2>

      
      <div style={{ marginBottom: '20px' }}>
        <input
          type="text"
          value={villageName}
          onChange={(e) => setVillageName(e.target.value)}
          placeholder="Enter Village Name"
          style={{
            marginRight: '10px',
            padding: '10px',
            width: '250px',
            borderRadius: '6px',
            border: '1px solid #ccc'
          }}/>
        <button onClick={searchVillage} style={{
            padding: '10px 16px',
            border: 'none',
            backgroundColor: '#3498db',
            color: 'white',
            borderRadius: '6px',
            cursor: 'pointer'
          }}>Search Village</button>
        <input
          type="text"
          value={familyHeadId}
          onChange={(e) => setFamilyHeadId(e.target.value)}
          placeholder="Enter Family Head Aadhar ID"
         style={{
            marginRight: '10px',
            padding: '10px',
            width: '250px',
            borderRadius: '6px',
            border: '1px solid #ccc',
            marginLeft: '20px'
          }}/>
        <button onClick={searchFamily} style={{
            padding: '10px 16px',
            border: 'none',
            backgroundColor: '#2ecc71',
            color: 'white',
            borderRadius: '6px',
            cursor: 'pointer'
          }}>Search Family</button>
      </div>

      <div style={{ border: '1px solid #ccc', padding: '16px', borderRadius: '8px' }}>
        <h3>Report Preview</h3>
        {data.length === 0 ? (
          <p>No data to display. Try searching above.</p>
        ) : (
          <table style={{ width: '100%', borderCollapse: 'collapse' }}>
            <thead>
              <tr>
                <th style={{ border: '1px solid #ddd', padding: '8px' }}>Source</th>
                <th style={{ border: '1px solid #ddd', padding: '8px' }}>Relationship</th>
                <th style={{ border: '1px solid #ddd', padding: '8px' }}>Target</th>
              </tr>
            </thead>
            <tbody>
              {data.map((item, index) => (
                <tr key={index}>
                  <td style={{ border: '1px solid #ddd', padding: '8px' }}>{item.source}</td>
                  <td style={{ border: '1px solid #ddd', padding: '8px' }}>{item.label}</td>
                  <td style={{ border: '1px solid #ddd', padding: '8px' }}>{item.target}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default GraphTreePDF;
