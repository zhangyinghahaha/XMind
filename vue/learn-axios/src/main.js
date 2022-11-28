import { createApp } from "vue";
import App from "./App.vue";

import httpClient from "./axios/HttpClient";

createApp(App).mount("#app");

httpClient.get('http://127.0.0.1:5173')
