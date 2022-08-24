import { createApp } from 'vue'
import App from './01_mixin和extends/App.vue'

const app = createApp(App);
app.mixin({
    created () {
        console.log('全局Mixin');
    },
});
app.mount('#app');
