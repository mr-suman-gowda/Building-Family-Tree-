import React, { useState } from 'react';
import axios from 'axios';
import { Network } from 'vis-network/standalone';
import 'vis-network/styles/vis-network.css';

const GraphDesign = () => {
  const [villageName, setVillageName] = useState('');
  const [familyHeadId, setFamilyHeadId] = useState('');
  const [network, setNetwork] = useState(null);
   const [hasSearched, setHasSearched] = useState(false);
  

  const drawGraph = (relations) => {
    const nodes = new Map();
    const edges = [];

    relations.forEach(rel => {
      const { source, target, type, label } = rel;

      if (!nodes.has(source)) {
        nodes.set(source, { id: source, label: source, color: '#6EC1E4' });
      }
      if (!nodes.has(target)) {
        nodes.set(target, { id: target, label: target, color: '#F6A623' });
      }

      edges.push({ from: source, to: target, label, arrows: 'to' });
    });

    const container = document.getElementById('network');
    const data = {
      nodes: Array.from(nodes.values()),
      edges: edges
    };
    const options = {
      edges: {
        font: { align: 'middle' },
        arrows: { to: { enabled: true, scaleFactor: 1 } },
        color: '#848484'
      },
      nodes: {
        shape: 'dot',
        size: 16,
        font: { size: 14, color: '#000' },
        borderWidth: 2
      },
      physics: {
        enabled: true,
        solver: 'forceAtlas2Based'
      },
      layout: {
        improvedLayout: true
      }
    };

    if (network) network.destroy();
    const newNetwork = new Network(container, data, options);
    setNetwork(newNetwork);
    setHasSearched(true);
  };

  const searchVillage = async () => {
    try {
      const res = await axios.get(`http://localhost:8081/api/villageGraph/${villageName}`);
      drawGraph(res.data);
    } catch (err) {
      console.error('Error fetching village data:', err);
    }
  };

  const searchFamily = async () => {
    try {
      const res = await axios.get(`http://localhost:8081/api/familyGraph/${familyHeadId}`);
      drawGraph(res.data);
    } catch (err) {
      console.error('Error fetching family data:', err);
    }
  };

  return (
    <div style={{
  padding: '30px',
  fontFamily: 'Arial, sans-serif',
  backgroundColor: '#f9f9f9',
  maxWidth: '1200px',
  margin: '0 auto'
}}>
      <h1 style={{ color: '#2c3e50' }}>Village Family Tree Viewer</h1>

      {!hasSearched && (
        <div style={{
          backgroundColor: '#fff',
          padding: '20px',
          borderRadius: '10px',
          boxShadow: '0 2px 10px rgba(0,0,0,0.1)',
          marginBottom: '30px'
        }}>
          <h2>What is a Family Tree?</h2>
          <p style={{ fontSize: '16px', color: '#444' }}>
            A family tree is a visual representation of relationships within a family or community.
            This system helps understand family structures, assets ownership, education background,
            and more — all linked through a dynamic, interactive graph.
          </p>
          <p style={{ fontSize: '15px', color: '#666' }}>
            Use the search options below to explore family relationships by village name or by
            individual family head’s Aadhar ID.
          </p>
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTRBhnqqbIhDUd-skK8uF4q2XgX-BTEQg1VA&s"
            alt="Family Tree Sample"
            style={{ height: '200px', marginTop: '15px' }}
          />
        </div>
      )}

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

      <div id="network" style={{ height: '600px', border: '1px solid #ccc', borderRadius: '8px' }}></div>
    </div>
  );
};

export default GraphDesign;
