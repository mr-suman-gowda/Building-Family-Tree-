import React from "react";
import { Link, useLocation } from "react-router-dom";
import "./sidebar.css";

function Sidebar() {
  const { pathname } = useLocation();

  const navSections = [
    {
      title: "DATA MANAGEMENT",
      items: [
        { name: "Dashboard", path: "/", icon: "🧮" },
        { name: "Persons", path: "/persons", icon: "👤" },
        { name: "Families", path: "/families", icon: "🏠" },
        { name: "Education", path: "/education", icon: "🎓" },
        { name: "Vehicles", path: "/vehicles", icon: "🚗" },
        { name: "Land Records", path: "/land-records", icon: "🗺️" },
        { name: "Insurance", path: "/insurance", icon: "🛡️" },
        { name: "Livestock", path: "/livestock", icon: "🐄" },
      ],
    },
    {
      title: "REPORTS & ANALYTICS",
      items: [
        { name: "Custom Queries", path: "/garph", icon: "📦" },
        { name: "Reports", path: "/reports", icon: "📊" },
      ],
    // },
    // {
    //   title: "ACCOUNT",
    //   items: [
    //     { name: "Profile", path: "/profile", icon: "👤" },
    //     { name: "Settings", path: "/settings", icon: "⚙️" },
    //   ],
    },
  ];

  return (
    <div className="sidebar">
      <div className="sidebar-header">
        <h2>Family Records Management</h2>

        {/* <div className="search-box">
          <select>
            <option>Search by Aadhar</option>
          </select>
          <input type="text" placeholder="Enter search value" />
          <button>🔍 Search</button>
        </div> */}
      </div>

      {navSections.map((section) => (
        <div key={section.title} className="nav-section">
          <p className="section-title">{section.title}</p>
          <ul>
            {section.items.map((item) => (
              <li key={item.name} className={pathname === item.path ? "active" : ""}>
                <Link to={item.path}>
                  <span className="icon">{item.icon}</span> {item.name}
                </Link>
              </li>
            ))}
          </ul>
        </div>
      ))}
    </div>
  );
}

export default Sidebar;
