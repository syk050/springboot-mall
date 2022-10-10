import { createApp } from 'vue'
import App from './App.vue'

import router from './router';
import axios from "axios";

const app = createApp(App);

app.config.globalProperties.$axios = axios;

app.use(router).mount('#app');

// 가장 먼저 실행되는 자바스크립트 파일,  vue 인스턴스를 생성하는 역할
