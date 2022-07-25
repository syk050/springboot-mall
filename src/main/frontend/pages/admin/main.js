import { createApp } from 'vue'
import App from './App.vue'
import store from '@/store'

createApp(App).use(store).mount('#app')


// 가장 먼저 실행되는 자바스크립트 파일,  vue 인스턴스를 생성하는 역할
