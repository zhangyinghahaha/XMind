import { createApp } from 'vue'
import App from './04_composition_api_example/App.vue'

const app = createApp(App);
// app.mixin({
//     created () {
//         console.log('全局Mixin');
//     },
// });
app.mount('#app');
