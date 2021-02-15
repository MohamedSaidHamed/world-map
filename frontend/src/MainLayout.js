import React, {Component} from 'react';
import { Layout, Menu, Breadcrumb } from 'antd';
import './MainLayout.css'
import CountryController from "./CountryController";
import CountryController_Ant from "./CountryController_Ant";
const { Header, Content, Footer } = Layout;

class MainLayout extends Component {

    render() {
        return(
            <Layout className="layout">
                <Header>
                    <div className="logo" />
                    <Menu
                        theme="dark"
                        mode="horizontal"
                        defaultSelectedKeys={['1']}
                        style={{ lineHeight: '64px', float:"left" }}
                    >
                        <Menu.Item key="1">Home</Menu.Item>
                    </Menu>
                </Header>
                <Content style={{ padding: '0 50px' }}>
                    <div style={{height:"fit-content"}}> <h2>World Map</h2></div>
                    <div style={{ background: '#fff', padding: 24, minHeight: 280 }}>
                       <CountryController_Ant/>
                    </div>
                </Content>
                <Footer style={{ textAlign: 'center' }}>Developed by Mohamed Hamed</Footer>
            </Layout>
        )
    }


}
export default MainLayout