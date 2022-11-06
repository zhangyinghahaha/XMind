import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router';

// import Home from '../views/Home.vue';
// import About from '../views/About.vue';

// 路由懒加载
const Home = () => import('../views/Home.vue');
const About = () => import('../views/About.vue');
const User = () => import('../views/User.vue');
const NotFound = () => import('../views/NotFound.vue');

// 配置映射关系
const routes = [
    {name:'index', path: '/', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/about', component: About},
    {path: '/user/:username', component: User},
    {path: '/:pathMatch(.*)', component: NotFound}
];

// 创建路由对象
const router = createRouter({
    routes,
    history: createWebHistory()
});

export default router;