const routes = {
    root: '/',
    onSale: '/on_sale',
    products: '/products',
    product_page: '/product_page/:id',
    games_page: '/games',
    best_sellers_page: '/best_sellers',
    consoles_page: '/consoles',
    controllers_page: '/controllers',
    accessories_page: '/accessories',
    contact_page: '/contact',
    crud: '/crud',
    crud_page: '/crud/:entity',
    login_page: '/login',
    dashboard: '/dashboard/*',
    // dashboardStoreProducts: '/dashboard/products',
    // dashboardOrders: '/dashboard/orders',
    no_match: '*',
};

export default routes;
