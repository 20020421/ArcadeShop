import classNames from 'classnames/bind';
import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import style from './SidebarDashboard.module.scss';
import SidebarItem from './SidebarItem';

const cx = classNames.bind(style);

const sidebars = [
    {
        id: 1,
        name: 'Store Products',
        to: '/dashboard/products',
        children: [
            {
                id: 1,
                name: 'Products',
                to: '/dashboard/products',
            },
            {
                id: 2,
                name: 'Inventory',
                to: '/dashboard/inventory',
            },
            {
                id: 3,
                name: 'Collections',
                to: '/dashboard/collections',
            },
        ],
    },
    {
        id: 2,
        name: 'Orders',
        to: '/dashboard/orders',
        children: [
            {
                id: 1,
                name: 'Orders',
                to: '/dashboard/orders',
            },
            {
                id: 2,
                name: 'Abandoned Cart',
                to: '/dashboard/abandoned_cart',
            },
        ],
    },
    {
        id: 3,
        name: 'Gift Card',
        to: '/dashboard/gift_card',
        children: [
            {
                id: 1,
                name: 'Overview',
                to: '/dashboard/gift_card',
            },
            {
                id: 2,
                name: 'Sales',
                to: '/dashboard/gift_card/sales',
            },
        ],
    },
    {
        id: 4,
        name: 'Subscriptions',
        to: '/dashboard/subscriptions',
    },
];

function Sidebar() {
    const [itemOpen, setItemOpen] = useState();
    const location = useLocation();

    useEffect(() => {
        const itemName = sidebars.find((item) => item.to === location.pathname);

        console.log(itemName);
        if (itemName !== undefined) {
            setItemOpen(itemName.name);
        } else {
            setItemOpen(sidebars[0].name);
        }
    }, [location]);

    return (
        <div className={cx('wrapper')}>
            {sidebars.map((sidebarItem, index) => (
                <div key={index} onClick={() => setItemOpen(sidebarItem.name)}>
                    <SidebarItem data={sidebarItem} isOpen={itemOpen === sidebarItem.name} />
                </div>
            ))}
        </div>
    );
}

export default Sidebar;
