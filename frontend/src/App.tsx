import React from 'react';
import logo from './logo.svg';
import './App.css';
import Header from './Component/Header/Header';
import Form from './Component/Form/Form';

function App() {
  return (
    <div className="App">
      <Header title='Notification Form'></Header>
      <div className='main'>
        <Form></Form>
      </div>
    </div>
  );
}

export default App;
