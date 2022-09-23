import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login'

const routes = [
    {
        path: '/Login',
        name: 'Login',
        component: Login
    }

]

const router = createRouter({
    mode : history,
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router