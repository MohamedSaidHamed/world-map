import React, {Component} from 'react';
import { Input, Alert, Table, Divider, Tag } from 'antd';
import reqwest from 'reqwest';
const { Search } = Input;



const columns = [
    {
        title: 'Name',
        dataIndex: 'name',
        rowKey: 'name',
    },
];


class CountryController_Ant extends Component{

    state = {
        data: [],
        pagination: {},
        loading: false,
    };

    componentDidMount() {
        this.fetch();
    }

    handleTableChange = (pagination, filters, sorter) => {
        const pager = { ...this.state.pagination };
        pager.current = pagination.current;
        this.setState({
            pagination: pager,
        });
        this.fetch({
            results: pagination.pageSize,
            page: pagination.current,
            sortField: sorter.field,
            sortOrder: sorter.order,
            ...filters,
        });
    };

    fetch = (params = {}) => {
        console.log('params:', params);
        this.setState({ loading: true });
        reqwest({
            url: 'http://localhost:8080/world_map_war_exploded/EGY',
            method: 'get',
            data: {
                results: 10,
                ...params,
            },
            type: 'json',
        }).then(data => {
            const pagination = { ...this.state.pagination };
            // Read total count from server
            // pagination.total = data.totalCount;
            pagination.total = 200;
            debugger;
            console.log('-------------'+data);
            this.setState({
                loading: false,
                data: data,
                pagination,
            });
        });
    };



    render() {
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
                    <Table dataSource={this.state.data}
                           columns={columns}
                    loading={this.state.loading}/>;

                </div>

            </div>

        )
    }
}
export default CountryController_Ant