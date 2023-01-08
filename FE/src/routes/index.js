import HomePage from '../pages/HomePage';
import routes from '../configs/routes';
import DefaultLayout from '../components/layouts/DefaultLayout';

import ProductsLayout from '../components/layouts/ProductsLayout';
import ProductsPage from '../pages/ProductsPage';
import ProductPage from '../pages/ProductPage';
import { ACCESSORIESID, allProduct, CONSOLEID, CONTROLLERID, GAMEID, onSale, products, soldHigh } from '../fakeApi';

import ContactPage from '../pages/ContactPage';
import NoMatchPage from '../pages/NoMatchPage';
import CRUD from '../pages/CRUD';
import CRUDPage from '../pages/CRUD/CRUDPage';
import LoginPage from '../pages/LoginPage';
import { Fragment } from 'react';
import DashboardLayout from '../components/layouts/DashboardLayout';
import StoreProducts from '../pages/DashboardPages/StoreProducts';
import Orders from '../pages/DashboardPages/Orders';

const collectionPages = [
    {
        title: 'Games',
        path: routes.games_page,
        data: allProduct.filter((product) => product.typeId === GAMEID),
    },
    {
        title: 'Best Sellers',
        path: routes.best_sellers_page,
        data: allProduct.filter((product) => product.sold >= soldHigh),
    },
    {
        title: 'Consoles',
        path: routes.consoles_page,
        data: allProduct.filter((product) => product.typeId === CONSOLEID),
    },
    {
        title: 'Controllers',
        path: routes.controllers_page,
        data: allProduct.filter((product) => product.typeId === CONTROLLERID),
    },
    {
        title: 'Accessories',
        path: routes.accessories_page,
        data: allProduct.filter((product) => product.typeId === ACCESSORIESID),
    },
];

const collectionRoutes = collectionPages.map((collectionPage) => {
    return {
        ...collectionPage,
        component: ProductsPage,
        layout: ProductsLayout,
    };
});

const publicRoutes = [
    {
        title: 'Home',
        path: routes.root,
        component: HomePage,
        layout: DefaultLayout,
    },
    {
        title: 'On Sale',
        path: routes.onSale,
        component: ProductsPage,
        data: onSale,
        layout: ProductsLayout,
    },
    {
        title: 'Shop all',
        path: routes.products,
        component: ProductsPage,
        data: allProduct,
        layout: ProductsLayout,
    },
    {
        title: 'Product',
        path: routes.product_page,
        component: ProductPage,
        layout: DefaultLayout,
    },
    {
        title: 'Need a hand?',
        path: routes.contact_page,
        component: ContactPage,
        layout: ProductsLayout,
    },

    ...collectionRoutes,
    {
        title: 'No Page Match Route',
        path: routes.no_match,
        component: NoMatchPage,
        layout: ProductsLayout,
    },

    {
        title: 'Manager',
        path: routes.crud,
        component: CRUD,
        layout: ProductsLayout,
    },
    {
        path: routes.crud_page,
        component: CRUDPage,
        layout: ProductsLayout,
    },
    {
        path: routes.login_page,
        component: LoginPage,
        layout: Fragment,
    },
    {
        path: routes.dashboard,
        component: StoreProducts,
        layout: DashboardLayout,
    },
    // {
    //     path: routes.dashboardStoreProducts,
    //     component: StoreProducts,
    //     layout: DashboardLayout,
    // },
    // {
    //     path: routes.dashboardOrders,
    //     component: Orders,
    //     layout: DashboardLayout,
    // },
];

const privateRoutes = [];

export { publicRoutes, privateRoutes };
