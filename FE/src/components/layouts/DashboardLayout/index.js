import classNames from 'classnames/bind';
import { Route, Routes } from 'react-router-dom';
import Orders from '../../../pages/DashboardPages/Orders';
import StoreProducts from '../../../pages/DashboardPages/StoreProducts';
import { dashboardRoutes } from '../../../routes';
import Header from '../DefaultLayout/Header';
import style from './DashboardLayout.module.scss';
import HeaderDB from './HeaderDB';
import Sidebar from './Sidebar';

const cx = classNames.bind(style);

function DashboardLayout() {
    return (
        <div className={cx('wrapper')}>
            {/* <Header /> */}
            <HeaderDB />

            <div className={cx('container')}>
                <div className={cx('sidebar')}>
                    <Sidebar />
                </div>
                <div className={cx('content')}>
                    <Routes>
                        {
                            dashboardRoutes.map((route, index) => {
                                const Component = route.component;
                                return (
                                    <Route path={route.path} element={<Component />} key={index} />
                                )
                            }
                            )
                        }
                        {/* <Route path="/products" element={<StoreProducts />} />
                        <Route path="/orders" element={<Orders />} /> */}
                    </Routes>
                </div>
            </div>
        </div>
    );
}

export default DashboardLayout;
