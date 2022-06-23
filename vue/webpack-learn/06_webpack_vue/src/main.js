import { createApp } from 'vue';
import {sum} from './js/math';
const {priceFormat} = require('./js/format');

import './js/element';

console.log(sum(20, 30));
console.log(priceFormat());

// es6语法 -> es5
const names = ['a', 'b', 'c'];
names.forEach(item => console.log(item));

import App from './vue/app.vue';

const app = createApp(App);
app.mount('#app');