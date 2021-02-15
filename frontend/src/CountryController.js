import React, {Component} from 'react';
import { Button } from 'antd';
import { Input, Alert, Table, Divider, Tag } from 'antd';
const { Search } = Input;

const dispatch = (obj) => {
    console.log(obj);
};

const columns = [
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
    },
    {
        title: 'Continent',
        dataIndex: 'continent',
        key: 'continent',
    },
    {
        title: 'Population',
        dataIndex: 'population',
        key: 'population',
    },
    {
        title: 'Life Expectancy',
        dataIndex: 'lifeExpectancy',
        key: 'lifeExpectancy',
    },
    {
        title: 'Country Language',
        dataIndex: 'country_language',
        key: 'country_language',
    },
    {
        title: 'Delete',
    },
];



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
        fetchJSON('http://localhost:8080/world_map_war_exploded/' + code,'POST')
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
                this.setState({errorMsg: e});
                this.setState({countryRes: []});
                console.log("-------------"+e);
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

                <div className="mainCont-body">
                    <Search
                        style={{width:500}}
                        placeholder="Please enter country code"
                        enterButton="Search"
                        size="large"
                        onSearch={value => this.retrieveCityByCode(value)}
                    />
                </div>
                <br/>
                <div className="result">

                    <Alert
                        message="Error"
                        description={this.state.errorMsg}
                        type="error"
                        closable
                        onClose=""
                    />
                    <Table dataSource={this.state.countryRes} columns={columns} />;

                </div>

            </div>
        )
}
}
export default CountryController