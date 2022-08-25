import { createApp } from 'vue'
import App from './02_composition_api基础/App.vue'

const app = createApp(App);
app.mixin({
    created () {
        console.log('全局Mixin');
    },
});
app.mount('#app');
