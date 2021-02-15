import React, {Component} from 'react';
 import axios from 'axios';

class WorldMap extends Component {
    state = {
        searchKey: "",
        countryRes: []
    };
    updateTextboxVal = (event) => {
        event.preventDefault();
        this.setState({searchKey: event.target.value});
    }

    retrieveCityByCode(code) {
        axios.get('http://localhost:8080/world_map_war_exploded/' + code).then(
            response => {
                this.setState({countryRes: response.data});
            })
    }

    render() {
        return (
            <div className="mainCont">
                <div className="mainCont-header">
                    <h1>World Map Welcomes You!</h1>
                </div>
                <div className="mainCont-body">
                    <input className="searchField" placeholder="Please enter the country code"
                           onChange={(event) => this.updateTextboxVal(event)}/>
                    <span> </span>
                    <button className="searchBtn" onClick={() => this.retrieveCityByCode(this.state.searchKey)}>Search</button>
                </div>
                <br/>
                <div className="result">
                    <h3></h3>

                    <table className="table">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Continent</th>
                            <th>Population</th>
                            <th>Life Expectancy</th>
                            <th>Country Language</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            <tr>
                                <td>{this.state.countryRes.name}</td>
                                <td>{this.state.countryRes.continent}</td>
                                <td>{this.state.countryRes.population}</td>
                                <td>{this.state.countryRes.lifeExpectancy}</td>
                                <td>{this.state.countryRes.country_language}</td>
                            </tr>
                        }
                        </tbody>

                    </table>
                </div>

            </div>

        )
    }
}

export default WorldMap