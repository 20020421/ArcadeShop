import classNames from 'classnames/bind';
import { Route, Routes } from 'react-router-dom';
import Orders from '../../../pages/DashboardPages/Orders';
import StoreProducts from '../../../pages/DashboardPages/StoreProducts';
import Header from '../DefaultLayout/Header';
import style from './DashboardLayout.module.scss';
import Sidebar from './SidebarDashboard';

const cx = classNames.bind(style);

function DashboardLayout() {
    return (
        <div className={cx('wrapper')}>
            <Header />

            <div className={cx('container')}>
                <div className={cx('sidebar')}>
                    <Sidebar />
                </div>
                <div className={cx('content')}>
                    <Routes>
                        <Route path="/products" element={<StoreProducts />} />
                        <Route path="/orders" element={<Orders />} />
                    </Routes>
                </div>
            </div>
        </div>
    );
}

export default DashboardLayout;
