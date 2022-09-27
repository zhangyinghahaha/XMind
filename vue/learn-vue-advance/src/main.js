import { createApp } from "vue";
import App from "./App.vue";

const app = createApp(App);
app.directive("focus", {
    mounted(element) {
        console.log("global focus mounted");
        element.focus();
    },
});
app.mount("#app");
