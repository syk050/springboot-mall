import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'                           // aios 모듈 가져오기(이전에 npm install axios 로 설치해야 함)
import router from "./router/index.js";
import store from '@/store'




const app = createApp(App)
app.config.globalProperties.axios = axios;          //axios 모듈 장작
createApp(App).use(router).use(store).mount('#app')

router.beforeEach((to, from, next) => {
    console.log(from.path + ' -> ' + to.path);
    next();
})

// router를 vue에 등록하게 되면 $route와 $router를 사용할 수 있게 된다.
// $route는 일반적으로 url로 넘어오는 값이나, 상태를 가집니다.
// $router는 주로 페이지 이동에 대한 함수(push,go 등등)이나, $route가 가지고 있는 전체값을 가집니다.

// 가장 먼저 실행되는 자바스크립트 파일,  vue 인스턴스를 생성하는 역할


/*
    현재 개발 중 테스트 구조는
        vue 서버(프론트 테스트) -> 빌드 -> Spring boot 연결 -> Spring 서버(백엔드 테스트)이다.

    이는 백엔드 테스트로 바로바로 이동하기 전
    매번 빌드하거나 build --watch 옵션을 통해 변경을 감지하고 자동 빌드 하는 방법을 써야 한다는 불편함이 있다(자동 빌드는 메모리와 저장공간 차지에 단점이 있다)


    이를 조금 더 편하게 할 수 있는 방법으로는 vue axios를 활용하는 것이 있다.
        vue 서버(프론트 테스트) -> get,post,put,del 방식의 요청(axios) -> Spring 서버(백엔드)
    쉽게 설명하자면, 본래 메인페이지를 spring url로 요청하고, spring 서버 내에서 rest 구조를 사용하여 가공된 페이지를 제공해야 하지만,
    vue 서버를 통해 페이지를 쉽게 표현하고, 백엔드로의 요청은 axios가 전송하여 해당 vue 페이지에 넣어주는 방식이다.


    * Ajax(Asynchronous JavaScript And XML) : 자바스크립트를 이용해 클라이언트와 서버 간에 데이터를 주고받는 비동기 HTTP 통신, JQuery 사용
    * axios : Node.js와 브라우저를 위한 Promise API를 활용하는 HTTP 통신 라이브러리, response timeout 처리방법이 존재, 브라우저 호환성이 뛰어남, 모듈 설치 필요
    * fetch : ES^부터 들어온 JavaScript 내장 라이브러리, Promise 기반, 내장 라이브러리로 import 필요 X, 지원하지 않는 브라우저(IE11 ...), JSON으로 변환과정 필요, axios에 비해 기능 부족


    *** 위 내용을 바탕으로 최종 빌드 전까지 프론트 페이지 테스트는 vue 서버에, 백엔드 rest 관리는 spring boot 서버에 일관하고, 2개의 서버를 동시에 운영하며, 그 사이의 운영은 axios로 하는 것이 좋다 생각함

    //// 아마 최종빌드를 하면 2개 서버를 운영하기에는 벅찰 것 같아, spring 서버가 vue 페이지 전송(프론트)까지 담당해야 할 것으로 예상이 됨(페이지 다이렉트 관련 코드가 필요해질 것 ,return ../xxx.html)
 */