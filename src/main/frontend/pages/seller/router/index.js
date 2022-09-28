import { createRouter, createWebHistory } from 'vue-router'
import seller from '../views/Seller.vue'


const routes = [
    {
        path: '/seller',                // router 접근 경로
        name: 'seller',                 // 경로의 이름
        component: seller              // 실제로 보여줄 페이지
    }
]

const router = createRouter({
    mode : history,
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router