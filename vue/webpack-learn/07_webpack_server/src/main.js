import { createApp } from 'vue';
import {sum} from '@/js/math';
const {priceFormat} = require('./js/format');
import axios from 'axios';

import '@/js/element';
if (module.hot) {
    module.hot.accept('@/js/element.js');
}

console.log(sum(20, 30));
console.log(priceFormat());

import App from '@/vue/app.vue';

const app = createApp(App);
app.mount('#app');

axios.get('/mock/test').then(res => {
    console.log(res);
}).catch(err => {
    console.log(err);
});