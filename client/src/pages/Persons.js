import React, { useState, useEffect } from "react";
import axios from "axios";
import "./Persons.css";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const Persons = () => {
  const [showModal, setShowModal] = useState(false);
  const [dob, setDob] = useState(null);
  const [vehicleInsuranceExpiry, setVehicleInsuranceExpiry] = useState(null);
const [formData, setFormData] = useState({
  // Personal Information
  name: "",
  gender: "",
  fatherName: "",
  maritalStatus: "",
  dob: null,
  bloodGroup: "",
  Ishead: "",
  headAadharId: "", // Changed from aadhar to headAadharId for clarity
  aadhar: "",           // Used twice; ensure it doesn’t conflict
  // Identity Documents
  pan: "",
  voterId: "",
  udid: "",
  // Contact Information
  pollingStation: "",
  mobile: "",
  permanentAddress: "",
  // Economic Status (Family Head only)
  aplStatus: "",
  bplStatus: "",
  // Employment
  employmentStatus: "",
  selfemployed: "",
  businessType: "",
  // Education
  educationLevel: "",
  graduated: "",
  institutionName: "",
  institutionAddress: "",
  // Family Details (Family Head only)
  familyBleow18: "",
  familyAbove18: "",
  houseStatus: "",
  // Vehicle Details
  vehicleHave: "",
  vehicleType: "",
  registrationNo: "",
  vehicleInsuranceNo: "",
  VehicleInsuranceProvider: "",
  vehicleInsuranceExpiry: null,
  insurancePremium: "",
  // Land Details
  landHave: "",
  landServeyNo: "",
  landVillageName: "",
  acres: "",
  gunta: "",
  waterSource: "",
  // Crop Details
  cropHave: "",
  cropName: "",
  tools: "",
  fertilizers: "",
  fishery: "",
  cropInsurance: "",
  // Livestock
  silkWorm: "",
  cows: "",
  goats: "",
  sheeps: "",
  hen: "",
  // Loan Details
  membershipType: "",
  loanFrequency: "",
  loanAmount: "",
  // Health Insurance
  hasHealthInsurance: "",
  insuranceAmount: "",
  healthInsurer: "",
  healthIssues: ""
});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSave = async () => {
try {
const formattedDob = dob ? dob.toISOString().split("T")[0] : null;
const formattedVehicleExpiry = vehicleInsuranceExpiry ? vehicleInsuranceExpiry.toISOString().split("T")[0] : null;

const payload = {
  ...formData,
  dob: formattedDob,
  vehicleInsuranceExpiry: formattedVehicleExpiry
};
console.log("Payload to save:", payload);
const response = await axios.post("http://localhost:8081/api/add", payload);

console.log("Saved successfully:", response.data);
alert("Person data saved successfully!");

setShowModal(false);

// // Refresh list of persons
// const refreshed = await axios.get("http://localhost:8081/api/persons");
// setRecords(refreshed.data);
} catch (error) {
console.error("Error saving person:", error);
alert("Failed to save person data. Please check console/logs.");
}
};
  // const handleSave = () => {
  //   console.log("Saved Person:", { ...formData, dob, vehicleInsuranceExpiry   });
  //   setShowModal(false);
  // };

  const [records, setRecords] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/api/persons")
      .then((response) => response.json())
      .then((data) => {
        console.log("Fetched data:", data);
        setRecords(data);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const isFamilyHead = formData.Ishead === "Yes";
  const employmentStatus = formData.employmentStatus === "Unemployed";
  const vehicleHave = formData.vehicleHave === "Yes";
  const landHave = formData.landHave === "Yes";
  const cropHave = formData.cropHave === "Yes";
  const hasHealthInsurance = formData.hasHealthInsurance === "Yes";
  const apl = formData.aplStatus === "Yes";

  return (
    <div className="person-page">
      <div className="person-header">
        <div>
          <h2>Persons Management</h2>
          <p>Manage person records and information</p>
        </div>
        <button className="add-person-btn" onClick={() => setShowModal(true)}>
          + Add Person
        </button>
      </div>

      <div className="person-table-card">
        <h3>Person Records</h3>
        <table className="person-table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Aadhar ID</th>
              <th>Gender</th>
              <th>Mobile</th>
              <th>Date of Birth</th>
              <th>Education</th>
              <th>Employment</th>
              <th>Address</th>
            </tr>
          </thead>
          <tbody>
            {Array.isArray(records) && records.length > 0 ? (
              records.map((record, index) => (
                <tr key={index}>
                  <td>{record.name}</td>
                  <td>{record.aadharId}</td>
                  <td>{record.gender}</td>
                  <td>{record.mobile}</td>
                  <td>{record.dob}</td>
                  <td>{record.education}</td>
                  <td>{record.employment}</td>
                  <td>{record.address}</td>
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

      {showModal && (
        <div className="modal-overlay">
          <div className="modal-content">
            <div className="modal-header">
              <h3>Add New Person</h3>
              <button onClick={() => setShowModal(false)}>✕</button>
            </div>

            <form className="person-form">
              <div className="form-section">
                <h4>Personal Information</h4>
                <div className="form-grid">
                  <input
                    name="name"
                    placeholder="Name *"
                    onChange={handleChange}
                  />
                  <select name="gender" onChange={handleChange}>
                    <option value="">Select Gender *</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="others">Other</option>
                  </select>
                  <input
                    name="fatherName"
                    placeholder="Father/Husband Name"
                    onChange={handleChange}
                  />
                  <select name="maritalStatus" onChange={handleChange}>
                    <option value="">Select Status</option>
                    <option value="Single">Single</option>
                    <option value="Married">Married</option>
                    <option value="Divorced">Divorced</option>
                  </select>
                  <DatePicker
                    selected={dob}
                    onChange={(date) => setDob(date)}
                    placeholderText="Date of Birth *"
                    className="datepicker"
                    dateFormat="dd-MM-yyyy"
                  />
                  <select name="bloodGroup" onChange={handleChange}>
                    <option value="">Select Blood Group</option>
                    <option value="A+">A+</option>
                    <option value="B+">B+</option>
                    <option value="A-">A-</option>
                    <option value="B-">B-</option>
                    <option value="O+">O+</option>
                    <option value="O-">O-</option>
                    <option value="AB+">AB+</option>
                    <option value="AB-">AB-</option>
                  </select>
                  <select name="Ishead" onChange={handleChange}>
                    <option value="">Family Head</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <input
                    name="headAadharId"
                    placeholder="Head Aadhar Number *"
                    onChange={handleChange}
                  />
                </div>
              </div>

              <div className="form-section">
                <h4>Identity Documents</h4>
                <div className="form-grid">
                  <input
                    name="aadhar"
                    placeholder="Aadhar Number *"
                    onChange={handleChange}
                  />
                  <input
                    name="pan"
                    placeholder="PAN Number"
                    onChange={handleChange}
                  />
                  <input
                    name="voterId"
                    placeholder="Voter ID"
                    onChange={handleChange}
                  />
                  <select name="udid" onChange={handleChange}>
                    <option value="">Special UDID</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                </div>
              </div>

              <div className="form-section">
                <h4>Contact Information</h4>
                <div className="form-grid">
                  <input
                    name="pollingStation"
                    placeholder="Polling Station No"
                    onChange={handleChange}
                  />
                  <input
                    name="mobile"
                    placeholder="Mobile Number"
                    onChange={handleChange}
                    typeof="number"
                    max={10}
                    min={10}
                  />
                  <textarea
                    name="permanentAddress"
                    placeholder="Permanent Address"
                    rows="2"
                    onChange={handleChange}
                  ></textarea>
                  
                </div>
              </div>

              <div className="form-section">
                <h4>Economic Status</h4>
                <div className="form-grid">
                  <select name="aplStatus" onChange={handleChange} 
                    disabled={!isFamilyHead} >
                    <option value="">APL Status</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <select name="bplStatus" onChange={handleChange}
                    disabled={!isFamilyHead || apl}>
                    <option value="">BPL Status</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                </div>
              </div>

              <div className="form-section">
                <h4>Employment</h4>
                <div className="form-grid">
                  <select name="employmentStatus" onChange={handleChange}>
                    <option value="">Employment Status</option>
                    <option value="Employed">Employed</option>
                    <option value="Unemployed">Unemployed</option>
                  </select>
                  <select name="selfemployed" onChange={handleChange}
                    disabled={!employmentStatus}>
                    <option value="">selfemployed</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <select name="businessType" onChange={handleChange} disabled={!employmentStatus}>
                    <option value="">Business Type</option>
                    <option value="Tailoring">Tailoring</option>
                    <option value="Shop">Shop</option>
                    <option value="Farming">Farming</option>
                    <option value="Industry">Industry</option>
                    <option value="FormHouse">FormHouse</option>
                    <option value="Others">Others</option>
                  </select>
                </div>
              </div>

              <div className="form-section">
                <h4>Education</h4>
                <div className="form-grid">
                  <select name="educationLevel" onChange={handleChange}>
                    <option value="">Education Level</option>
                    <option value="Primary">Primary</option>
                    <option value="Secondary">Secondary</option>
                    <option value="Higher Secondary">Higher Secondary</option>
                    <option value="Graduate">Graduate</option>
                    <option value="Post Graduate">Post Graduate</option>
                  </select>
                  <select name="graduated" onChange={handleChange}>
                    <option value="">Graduated</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <input
                    name="institutionName"
                    placeholder="Institution Name"
                    onChange={handleChange}
                  />
                  <input
                    name="institutionAddress"
                    placeholder="Institution Address"
                    onChange={handleChange}
                  />
                </div>
              </div>

              <div className="form-section">
                <h4>Family Details</h4>
                <div className="form-grid">
                  <input
                    name="familyBleow18"
                    placeholder="No Of Childers"
                    type="number"
                    onChange={handleChange}
                    disabled={!isFamilyHead}
                  />
                  <input
                    name="familyAbove18"
                    placeholder="No of Adults"
                    type="number"
                    onChange={handleChange}
                    disabled={!isFamilyHead}
                  />
                  <select name="houseStatus" onChange={handleChange} disabled={!isFamilyHead}>
                    <option value="">House Status</option>
                    <option value="Rent">Rent</option>
                    <option value="Lease">Lease</option>
                    <option value="Own">Own</option>
                  </select>
                  
                </div>
              </div>

              <div className="form-section">
                <h4>Vehicle Details</h4>
                <div className="form-grid">
                  <select name="vehicleHave" onChange={handleChange} >
                    <option value="">Having Vehicle</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <select name="vehicleType" onChange={handleChange} disabled={!vehicleHave}>
                    <option value="">Vehicle Type</option>
                    <option value="Car">Car</option>
                    <option value="Bike">Bike</option>
                    <option value="Tractor">Tractor</option>
                    <option value="Bus">Bus</option>
                    <option value="Truck">Truck</option>
                    <option value="Others">Others</option>
                    <option value="None">None</option>
                  </select>
                  <input
                    name="registrationNo"
                    placeholder="Registration Number"
                    onChange={handleChange}
                    disabled={!vehicleHave}
                  />
                  <input
                    name="vehicleInsuranceNo"
                    placeholder="Vehicle Insurance Number"
                    onChange={handleChange}
                    disabled={!vehicleHave}
                  />
                  <input
                    name="VehicleInsuranceProvider"
                    placeholder="Vehicle Insurance Provider"
                    onChange={handleChange}
                    disabled={!vehicleHave}
                  />
                  <DatePicker
                    selected={vehicleInsuranceExpiry}
                    onChange={(date) => setVehicleInsuranceExpiry(date)}
                    placeholderText="Vehicle Insurance Expiry Date"
                    className="datepicker"
                    dateFormat="dd-MM-yyyy"
                    disabled={!vehicleHave}
                  />
                  <input
                    name="insurancePremium"
                    placeholder="Insurance Premium"
                    type="number"
                    onChange={handleChange}
                    disabled={!vehicleHave}
                  />
                </div>
              </div>

              <div className="form-section">
                <h4>Land Details</h4>
                <div className="form-grid">
                  <select name="landHave" onChange={handleChange} >
                    <option value="">Having LandRecords</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select> 
                  <input
                    name="landServeyNo"
                    placeholder="Land Servey Number"
                    type="number"
                    onChange={handleChange}
                    disabled={!landHave}
                  />
                  <input
                    name="landVillageName"
                    placeholder="Village Name"
                    onChange={handleChange}
                    disabled={!landHave}
                  />
                  <input
                    name="acres"
                    placeholder="Acres"
                    type="number"
                    onChange={handleChange}
                    disabled={!landHave}
                  />
                  <input
                    name="gunta"
                    placeholder="Gunta"
                    type="number"
                    onChange={handleChange}
                    disabled={!landHave}
                  />
                  <select name="waterSource" onChange={handleChange} 
                    disabled={!landHave}>
                    <option value="">Water Source</option>
                    <option value="Canal">Canal</option>
                    <option value="Rain">Rain</option>
                    <option value="Borewell">Borewell</option>
                    <option value="Well">Well</option>
                    <option value="River">River</option>
                    <option value="Lake">Lake</option>
                    <option value="None">None</option>
                  </select>
                </div>
              </div>

              <div className="form-section">
                <h4>Crops Details</h4>
                <div className="form-grid">
                  <select name="cropHave" onChange={handleChange} >
                    <option value="">Having Crops</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <input
                    name="cropName"
                    placeholder="Crop Name"
                    onChange={handleChange}
                    disabled={!cropHave}
                  />
                  <input
                    name="tools"
                    placeholder="Tools Used"
                    onChange={handleChange}
                    disabled={!cropHave}
                  />
                  <input
                    name="fertilizers"
                    placeholder="Fertilizers"
                    onChange={handleChange}
                    disabled={!cropHave}
                  />
                  <select name="fishery" onChange={handleChange} >
                    <option value="">Feshery</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <select name="cropInsurance" onChange={handleChange}
                    disabled={!cropHave}>
                    <option value="">Crop Insurance</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                </div>
              </div>

              <div className="form-section">
                <h4>Livestock Details</h4>
                <div className="form-grid">
                  <select name="silkWorm" onChange={handleChange}>
                    <option value="">Slik Worm</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <input
                    name="cows"
                    placeholder="Cows"
                    type="number"
                    onChange={handleChange}
                  />
                  <input
                    name="goats"
                    placeholder="Goats"
                    type="number"
                    onChange={handleChange}
                  />
                  <input
                    name="sheeps"
                    placeholder="Sheeps"
                    type="number"
                    onChange={handleChange}
                  />
                  <input
                    name="hen"
                    placeholder="Hen"
                    type="number"
                    onChange={handleChange}
                  />
                  
                </div>
              </div>

              <div className="form-section">
                <h4>Loan Details</h4>
                <div className="form-grid">
                  <select name="membershipType" onChange={handleChange}>
                    <option value="">Member Ship Type</option>
                    <option value="Co-operative">Co-operative</option>
                    <option value="SHG">SHG</option>
                    <option value="None">None</option>
                  </select>
                  <select name="loanFrequency" onChange={handleChange}>
                    <option value="">Loan Frequency</option>
                    <option value="Monthly">Monthly</option>
                    <option value="Co-Quarterly">Co-Quarterly</option>
                    <option value="Yearly">Yearly</option>
                    <option value="None">None</option>
                  </select>
                  <input
                    name="loanAmount"
                    placeholder="Loan Amount"
                    type="number"
                    onChange={handleChange}
                  />
                </div>
              </div>

              <div className="form-section">
                <h4>Health Insurance Details</h4>
                <div className="form-grid">
                  <select name="hasHealthInsurance" onChange={handleChange}>
                    <option value="">Health Insurance</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                  </select>
                  <input
                    name="insuranceAmount"
                    placeholder="Insurance Amount"
                    type="number"
                    onChange={handleChange}
                    disabled={!hasHealthInsurance}
                  />
                  <input
                    name="healthInsurer"
                    placeholder="Health Insurer"
                    onChange={handleChange}
                    disabled={!hasHealthInsurance}
                  />
                  <input
                    name="healthIssues"
                    placeholder="Health Issues"
                    onChange={handleChange}
                    disabled={!hasHealthInsurance}
                  />
                </div>
              </div>

              <div className="modal-actions">
                <button type="button" className="save-btn" onClick={handleSave}>
                  Save
                </button>
                <button
                  type="button"
                  className="cancel-btn"
                  onClick={() => setShowModal(false)}
                >
                  Cancel
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};

export default Persons;
