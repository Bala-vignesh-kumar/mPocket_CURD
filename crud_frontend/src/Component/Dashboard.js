import React from 'react';
import '../App.css';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export const Dashboard = () => {
    const [searchValue, setSearchValue] = useState("");
    const [contacts, setContacts] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchContacts = async () => {
            const response = await fetch(`http://localhost:8080/crud/search?lastName=${searchValue}`);
            const data = await response.json();
            setContacts(data.slice(0, 10));
        };
        fetchContacts();
    }, [searchValue]);
    console.log(searchValue, "search");
    console.log(contacts, 'contact');

    const handleSearchChange = (e) => {
        setSearchValue(e.target.value);
    }

    const handleDeleteContact = (id) => {
        fetch(`http://localhost:8080/crud?id=${id}`, {
            method: 'DELETE',
        })
            .then(response => {
                if (response.ok) {
                    setContacts(contacts.filter((contact) => contact.id !== id));
                } else {
                    throw new Error('Failed to delete contact');
                }
            })
            .catch(error => console.error(error));
    }

    return (
        <div className="App">
            <h1>Phone Book App</h1>
            <div className='content'>
                <h2>Contacts</h2>
                <input type='search' placeholder='Seach for contact for last name' value={searchValue} onChange={handleSearchChange} className="search-input" />
                <ul className="contact-list">
                    {contacts.map((contact) => (
                        <li key={contact.id} className="contact">
                            <div>{contact.firstName}   {contact.lastName} <br /> {contact.phNumber} </div>
                            <button onClick={() => handleDeleteContact(contact.id)}>Delete</button>
                        </li>
                    ))}
                </ul>
            </div>
            <button className='ButtonCss' onClick={() => {
                navigate('/AddContact');
                window.location.reload();
            }}>Add Contact</button>
        </div>
    );
}