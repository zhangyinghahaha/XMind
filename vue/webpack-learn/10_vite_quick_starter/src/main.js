import { add } from './js/math';
import _ from 'lodash-es';
// import _ from '../node_modules/lodash-es/lodash.default.js';
// import moduleName from './css/style.css';
import './css/title.less';
import multi from './ts/multi';

console.log('Hello World!');
console.log(add(1, 10));

console.log(_.join(['abc', 'def'], '-'));

const titleEl = document.createElement('div');
titleEl.className = 'title';
titleEl.innerHTML = 'Hello Vite';
document.body.appendChild(titleEl);

console.log(multi(2, 8));

