import { createRouter, createWebHistory } from 'vue-router'
import appView from '../App'

const routes = [
    {
        path: '/search',
        name: 'appView',
        component: appView
    }
]

// 본래 페이지의 이동은 spring 서버에서 담당하지만 vue의 빠른 갱신을 개발 시 활용하기 위해
// vue 서버의 router 모듈을 바탕으로 페이지 이동을 결정

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router