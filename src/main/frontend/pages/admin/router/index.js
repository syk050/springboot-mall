import { createRouter, createWebHistory } from 'vue-router'
import AdminHome from '../views/AdminHome'
import ItemsDetail from '../views/ItemsDetail'
import ItemModify from "../views/ItemModify";


const routes = [
    {
        path: '/admin',
        name: 'AdminHome',
        component: AdminHome
    },
    {
        path: '/admin/item',
        name: 'ItemsDetail',
        component: ItemsDetail
    },
    {
        path: '/admin/item-modify',
        name: 'ItemModify',
        component: ItemModify
    }

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router