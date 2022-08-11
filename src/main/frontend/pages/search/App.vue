<template>
  <common-header/>
  <button id="reflesh_btn" v-on:click="reSearch">reflesh</button>
  <div id="content">
    <div id="search_value_div">
      <h1 class="search_value">'{{search_value}}'</h1>
      <h2 class="search_value">  에 대한 상품 검색 결과입니다.</h2>
    </div>
      <hr/>

<!--  DB에서 날마다 추천 상품 받아서 전송 -->
    <div class="search_item_list">
      <div class="items" v-for="(item,i) in items" :key="i">
        <img class="items_img" alt="pancakes" src="../../src/assets/pancakes.jpg">
        <h4 class="items_name">[성명이네] 맛동산 팬케이크 </h4>
        <h3 class="items_price">8,000원</h3>
      </div>
    </div>

    <div v-for="(menu,i) in menu" :key="i">
      <h1>spring 서버에서 받아온 데이터</h1>
      <h2>ID : {{menu.testId}}</h2>
      <h3>Contents : {{menu.testContents}}</h3>
    </div>
  </div>>
  <common-footer/>
</template>



<script>
import commonHeader from "../layout/common-header";       // header 파일
import commonFooter from "../layout/common-footer";       // footer 파일
import {loadMenu} from "../api/communication";            // 통신전용 파일의 get 메소드
import $ from 'jquery';                                   // vue에 JQuery 적용

export default {
  name: 'App',
  components: {
    'common-header' : commonHeader,
    'common-footer' : commonFooter
  },
  data(){                                                 // data에는 변수를 저장
    return{
      search_value : "성명이네 맛동산",
      server_query : "이게 나오면 성공",
      menu:[],
      items:{
        name : '',
        price : '',
        disc_price : '',
        desc : '',
        delivery : ''
      },
    };
  },
  created() {                                               // Dom Element가 생성되기 전 호출되는 라이프사이클 훅
    this.$nextTick(() => {
      console.log("-----------> Netick callback ")


      console.log('-----------> 수정 전')
      console.log('-----------> 수정완료')
    })
    loadMenu(this.server_query)
        .then(response => (this.menu = response.data, console.log(this.menu)))      // spring 서버에서 가져온 response 데이터를 변수에 저장
        .catch(e => console.log(e))
  },
  methods: {
    reSearch(){
      const dom = document.getElementById('reflesh_btn')
      dom.style.color = "pink"
      $("#content").load("http://127.0.0.1:8081/content");
      console.log("dddd");
    }
  }

}
</script>



<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  min-width: 1000px;
}

#content{
  width: 1020px;
  margin: 0 auto;         /* content 화면 정 가운데 고정 */
}
#search_value_div{
  margin : 50px 0 35px 0;
  /* 매개변수 개수에 따른 변화
  1개 : 4면,  2개 : 세로/가로,  3개 : 위/가로/아래,  4개 : 위/오른쪽/아래/왼쪽
  */
}

h1.search_value{
  color: darkblue;
}

.search_value{
  display: inline;        /* h태그 줄넘김 없애기 */
}


.items{
  display: inline-block;
  width: 300px;
  height: 500px;
  padding: 30px 20px 0 20px;
}
.items_img{
  width: 240px;
  height: 320px
}
.items_name{
  margin: 10px 0;
}
</style>


<!-- 최상위(Root) 컴포넌트 -->
<!-- 개발 시, vue 파일을 통해 편리하게 작성하고, 배포 시에는 npm run build를 통해 css/javascript 를 나눈 파일을 배포한다.-->

<!-- Vue 컴포넌트 파일 구조
template : 실제 Component를 구성하는 HTML코드를 작성하는 부분
script : Javascript 작성 부분
style : CSS 작성부분
-->

<!-- 컴포넌트 : 조합하여 화면을 구성할 수 있는 블록 (ex) Header, Content, Footer-->

<!-- export default
export 문은 JS 모듈에서 함수, 객체, 원시 값을 내보낼 때 사용한다. -->

<!--
https://ko.javascript.info/import-export#ref-4122
-->






<!--
<div class="show" v-for="(item,i) in menu" :key="i">
          <p>id : {{ item.id }}</p>
          <p>title : {{ item.title }}</p>
</div>
          -->