import { createRouter, createWebHistory } from 'vue-router'
import PaymentCertification from "../views/PaymentCertification";
import PaymentHome from "../views/PaymentHome";
import Result from "../views/PaymentResult";
import IamPortTest from "../views/IamPortTest";


const routes = [
    {
        path: '/pay',
        name: 'IamPortTest',
        component: IamPortTest,
    },
    {
        path: '/payment',
        name: 'PaymentHome',
        component: PaymentHome,
    },
    {
        path: '/certification',
        name: 'PaymentCertification',
        component: PaymentCertification
    },
    {
        path: '/result',
        name: 'Result',
        component: Result
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router