<template>
  <common-header/>
  <div id="content">
    <h2 id="page_title">상품 검색</h2>
    <h3 class="search_value">{{search_value}}</h3>
    <h4 class="search_value">  에 대한 상품 검색 결과입니다.</h4>
    <hr/>
  </div>
  <common-footer/>
</template>



<script>
import commonHeader from "../layout/common-header";       // header 파일
import commonFooter from "../layout/common-footer";       // footer 파일

export default {
  name: 'App',
  components: {
    'common-header' : commonHeader,
    'common-footer' : commonFooter
  },
  data(){
    return{
      search_value : "신발"

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
  margin-top: 20px;
  min-width: 1000px;
}
#content{
  width: 1000px;
  margin: 0 auto;         /* content 화면 정 가운데 고정 */
}
#page_title{
  margin : 30px 0px;
  /* 매개변수 개수에 따른 변화
  1개 : 4면,  2개 : 세로/가로,  3개 : 위/가로/아래,  4개 : 위/오른쪽/아래/왼쪽
  */
}
.search_value{
  display: inline;        /* h태그 줄넘김 없애기 */
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