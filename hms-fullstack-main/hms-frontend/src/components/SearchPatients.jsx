import React from "react";

const SearchPatients = ({
  searchType,
  setSearchType,
  searchTerm,
  setSearchTerm,
}) => {
  const handleInputChange = (e) => {
    setSearchTerm(e.target.value);
  };

  return (
    <div className="row mb-3">
      <div className="col-md-3" >
        <select
          className="form-select ms-8"
          value={searchType}
          onChange={(e) => setSearchType(e.target.value)}
          style={{ borderColor: "#34bdcc" }}
        >
          <option value="name">Search by Name</option>
          <option value="phone">Search by Phone</option>
          <option value="id">Search by Id</option> 
        </select>
      </div>
      <div className="col-md-8">
        <input
          type="text"
          className="form-control ms-6"
          placeholder={
            searchType === "name"
              ? "Search by Patient's First Name"
              : searchType === "phone"
              ? "Search by Patient's Phone Number"
              : "Search by Patient's ID" 
          }
          value={searchTerm}
          onChange={handleInputChange}
          style={{ borderColor: "#34bdcc" }}
          
        />
      </div>
    </div>
  );
};

export default SearchPatients;
