import React, { useState } from "react";
import '../App.css';

export const AddContact = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [phNumber, setPhoneNumber] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = {
            firstName,
            lastName,
            phNumber,
        };
        console.log("Data:", data);

        fetch('http://localhost:8080/crud', {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(data),
        })
            .then((response) => response.json())
            .then((data) => {
                console.log("Success:", data);
                alert("Created Successfully");
                window.location.reload();
            })
    };

    return (
        <div className="panelbox">
            <h1 className="tittlename">Add Contact</h1>
            <form className="formarea" onSubmit={handleSubmit}>
                <label className="textboxname">First Name:</label>
                <input type="text" placeholder='First Name' required value={firstName}
                    onChange={(event) => setFirstName(event.target.value)} className="textbox" />
                <label className="textboxname">Last Name:</label>
                <input type="text" placeholder='Last Name' required value={lastName}
                    onChange={(event) => setLastName(event.target.value)} className="textbox" />
                <label className="textboxname">Phone Number:</label>
                <input type="text" placeholder="Phone Number" required value={phNumber}
                    onChange={(event) => setPhoneNumber(event.target.value)} className="textbox" />
                <b><button type="submit" className="savebtn">Save</button></b>
            </form>
        </div>

    )
}