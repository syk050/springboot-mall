import { createRouter, createWebHistory } from 'vue-router'
import AdminHome from '../views/AdminHome'
import ItemsDetail from '../views/ItemsDetail'
import ItemModify from "../views/ItemModify";
import ItemAdd from "../views/ItemAdd";


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
    },
    {
        path: '/admin/item-add',
        name: 'ItemAdd',
        component: ItemAdd
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router