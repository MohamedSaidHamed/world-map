import React, {Component} from 'react';

const dispatch = (obj) => {
    console.log(obj);
};

const checkStatus = response => {
    const hasError = (response.status < 200 || response.status >= 300)
    if (hasError) {
        throw response.text();
    }
    return response;
};

const parseJSON = response => response.json();

const fetchJSON = (url, method, data) => {
    return fetch(url, {
        method: method,
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(data)
    }).then(checkStatus).then(parseJSON);
};

class CountryController extends Component {

    state = {
        searchKey: "",
        error: null,
        errorMsg: "",
        countryRes: []
    };
    updateTextboxVal = (event) => {
        event.preventDefault();
        this.setState({searchKey: event.target.value});
    };


    retrieveCityByCode(code) {
        fetchJSON('http://localhost:8080/world_map_war_exploded/' + code,'GET')
            .then((json) => {
                this.setState({countryRes: json});
                this.setState({error: false});
                this.setState({errorMsg: ""});
                console.log("-------------"+this.state.errorMsg);
                dispatch({
                    type: 'success',
                    apiResponse: json
                })}
            ).catch((error) => {
            Promise.resolve(error).then((e) => {
                this.setState({error: true});
                this.setState({errorMsg: e.toString()});
                this.setState({countryRes: []});
                console.log("-------------"+this.state.errorMsg);
                dispatch({
                    type: 'failure',
                    apiResponse: e,
                    apiMessage: "System encountered error. Please try again later."
                });
            });
        })
    };




render(){
        return (
            <div className="mainCont">
                <div className="mainCont-header">
                    <h1>Welcome To World Map!</h1>
                </div>
                <div className="mainCont-body">
                    <input className="searchField" placeholder="Please enter the country code"
                           onChange={(event) => this.updateTextboxVal(event)}/>
                    <span> </span>
                    <button className="searchBtn" onClick={() => this.retrieveCityByCode(this.state.searchKey)}>Search</button>
                </div>
                <br/>
                <div className="result">
                    <h3 className="warning">{this.state.errorMsg}</h3>

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
export default CountryController