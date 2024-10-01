// src/components/MessageComponent.js

import React, { useEffect, useState } from 'react';
import { getMessages, saveMessage } from '../services/apiService'; // Überprüfe diesen Pfad

const MessageComponent = () => {
  const [messages, setMessages] = useState([]);

  useEffect(() => {
    const fetchMessages = async () => {
      const response = await getMessages();
      setMessages(response.data);
    };

    fetchMessages();
  }, []);

  const handleSaveMessage = async (message) => {
    await saveMessage(message);
    // ... weitere Logik
  };

  return (
    <div>
      <h2>Nachrichten</h2>
      {messages.map((msg) => (
        <div key={msg.id}>{msg.text}</div>
      ))}
    </div>
  );
};

export default MessageComponent;
