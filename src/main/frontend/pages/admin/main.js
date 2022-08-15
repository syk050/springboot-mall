import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import axios from "axios";
import router from "./router";

const app = createApp(App)

app.config.globalProperties.$axios = axios;
app.config.globalProperties.$serverUrl = "http://localhost:8080/KGD";
app.config.globalProperties.$itemDetail = "/admin/item";
app.config.globalProperties.$itemModify = "/admin/item-modify";

app.use(router).mount('#app')


// 가장 먼저 실행되는 자바스크립트 파일,  vue 인스턴스를 생성하는 역할
