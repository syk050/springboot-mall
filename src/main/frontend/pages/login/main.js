import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'                           // axios 모듈 가져오기(이전에 npm install axios 로 설치해야 함)
import router from "./router/index.js"






const app = createApp(App)
app.config.globalProperties.axios = axios         //axios 모듈 장작

app.use(router).mount('#app')

router.beforeEach((to, from, next) => {
    console.log(from.path + ' -> ' + to.path)
    next();
})




