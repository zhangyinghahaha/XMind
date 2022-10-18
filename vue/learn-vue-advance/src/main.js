import { createApp } from "vue";
import App from "./App.vue";
import registerDirectives from './directives';

const app = createApp(App);
// 自定义全局指令
// app.directive("focus", {
//     mounted(element) {
//         console.log("global focus mounted");
//         element.focus();
//     },
// });

// 注册指令
registerDirectives(app);
app.mount("#app");
