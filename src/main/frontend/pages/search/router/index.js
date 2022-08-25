import { createRouter, createWebHistory } from 'vue-router'
import search from '../views/Search'

// vue 라우터란? : 뷰 라이브러리를 이용하여 싱글 페이지 애플리케이션을 구현하거나 페이지 간의 이동할 대 사용하는 라이브러리
//                페이지 이동 시 마다 서버에 요청하여 갱신하는 것이 아닌 미리 해당 페이지를 받아놓고 바로바로 이동할 수 있게 한다.
// <router-view> 는 페이지 url이 변경 또는 이동되었을때 url에 따라 뿌려지는 영역을 정의할 수 있는 라우터 태그
// <router-link> 사용자 입장에서 페이지의 이동을 link로 받아야할 때 사용되는 router 태그로 최종적으로 anchor태그로 변화( ex) <a href=""></a>)
const routes = [
    {
        path: '/search',                // router 접근 경로
        name: 'search',                 // 경로의 이름
        component: search,              // 실제로 보여줄 페이지
    }
]

// 본래 페이지의 이동은 spring 서버에서 담당하지만 vue의 빠른 갱신을 개발 시 활용하기 위해
// vue 서버의 router 모듈을 바탕으로 페이지 이동을 결정

const router = createRouter({
    mode : history,
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router