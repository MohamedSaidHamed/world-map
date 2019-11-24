import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import WorldMap from "./WorldMap";
import CountryController from "./CountryController";
import { Helmet } from 'react-helmet';
const TITLE = 'World Map';

function App() {
  return (
    <div className="App">
        <Helmet>
            <title>{ TITLE }</title>
        </Helmet>
        <CountryController />
    </div>
  );
}

export default App;
