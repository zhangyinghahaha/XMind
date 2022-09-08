import { createApp } from 'vue'
import App from './03_refapi/App.vue'

const app = createApp(App);
app.mixin({
    created () {
        console.log('全局Mixin');
    },
});
app.mount('#app');
