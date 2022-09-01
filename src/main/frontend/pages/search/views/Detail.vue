<template>
  <common-header/>
  <div id="contents">
    <div id="up_detail">
        <img id="itm_img" alt="pancakes" src="../../../src/assets/pancakes.jpg">
      <div id="right_detail">
        <h3> &lt;제품명&gt;</h3>
        <h5> &lt;제품 설명&gt;</h5>
        <h3> &lt;제품가격&gt; </h3>

        <items_view_card/>
      </div>


    </div>
  </div>
  <common-footer/>
</template>



<script>
import commonHeader from "../../layout/common-header";       // header 파일
import commonFooter from "../../layout/common-footer";       // footer 파일
import Items_view_card from "./items_view_card";
export default {
  name: 'App',
  components: {
    'common-header' : commonHeader,
    'common-footer' : commonFooter,
    'items_view_card' : Items_view_card
  },
  data(){                                                 // data에는 변수를 저장
    return{

    };
  },


  created() {                                              // Dom Element가 생성되기 전 호출되는 라이프사이클 훅
  },


  mounted(){            // 인스턴스가 마운트 된 직후 호출된다.


  },
  updated() {


  },

  computed:{                 // computed와 method의 차이점은 computed는 종속된 대상이 변하지 않는 이상 다시 계산을 하지 않는다.
  },
  watch : {

  },

  methods: {



  }
}
</script>

<!-- vue.js 의 라이프 사이클
1. Create : 라이프 사이클들 중 가장 먼저 실행됨(beforeCreate, created)
2. Mount : 컴포넌트가 DOM에 추가될 때, 실행되는 라이프사이클 훅, 컴포넌트 초기에 data가 세팅되어야 한다면 이것말고 create 추천(beforeMount, mounted)
3. Update : 컴포넌트에서 사용되는 속성들이 변경되는 등 컴포넌트가 재 렌더링되면 실행되는 라이프 사이클 훅
4. Destroy : 제거
-->

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  min-width: 1000px;
}
#up_detail{
  display: inline-block;
  text-align: left;
  margin: 100px auto 0;
  width: 1000px;
  white-space: nowrap;
}

#itm_img{
  margin : 40px 50px;
  width: 300px;
  height: 400px;
}

#right_detail{
  display: inline-block;
  vertical-align: top;
  margin : 40px 50px;
  width: 300px;
  height: 400px;
  white-space: nowrap;
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

<!-- css에서의 let / var / const 의 역할
var : 함수 범위로(블록을 벗어나도 사용가능)
let : 한 block 단위(let는 한 번 지정한 값을 바꿀 수 있다.)
const : 한 block 단위(const는 한 번 지정한 값을 바꿀 수 없다.)

https://velog.io/@gnb577/HTML-CSS-let-var-const
-->

