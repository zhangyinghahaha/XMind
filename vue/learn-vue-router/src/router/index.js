import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router';

// import Home from '../views/Home.vue';
// import About from '../views/About.vue';

// 路由懒加载
const Home = () => import('../views/Home.vue');
const About = () => import('../views/About.vue');
const User = () => import('../views/User.vue');
const NotFound = () => import('../views/NotFound.vue');
const HomeMessage = () => import('../views/HomeMessage.vue');
const HomeProduct = () => import('../views/HomeProduct.vue');

// 配置映射关系
const routes = [
    {name:'index', path: '/', redirect: '/home/'},
    {
        path: '/home', 
        component: Home,
        children: [
            {
                path: '',
                redirect: '/home/product'
            },
            {
                path: 'message',
                component: HomeMessage
            },
            {
                path: 'product',
                component: HomeProduct
            }
        ]
    },
    {path: '/user/:username', component: User},
    {path: '/:pathMatch(.*)', component: NotFound}
];

// 创建路由对象
const router = createRouter({
    routes,
    history: createWebHistory()
});

// 动态添加路由
const aboutRoute = {path: '/about', component: About};
router.addRoute(aboutRoute);

export default router;