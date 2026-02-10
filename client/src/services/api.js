const API_BASE = "http://localhost:8081/api";

export const fetchFamiliesByVillage = async (village) => {
  const response = await fetch(`${API_BASE}/families/${village}`);
  if (!response.ok) throw new Error("Failed to fetch family records");
  return response.json();
};
