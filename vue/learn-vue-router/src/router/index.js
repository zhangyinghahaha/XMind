import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router';

import Home from '../views/Home.vue';
import About from '../views/About.vue';

// 配置映射关系
const routes = [
    {path: '/', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/about', component: About}
];

// 创建路由对象
const router = createRouter({
    routes,
    history: createWebHistory()
});

export default router;