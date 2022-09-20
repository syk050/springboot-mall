<template>
  <common-header/>
  <div id="contents">
    <div id="up_detail">
        <img id="itm_img" alt="pancakes" src="../../../src/assets/pancakes.jpg">
      <div id="right_detail">
        <h3>{{item_detail.name}}</h3>
        <h5>{{item_detail.clarif}}</h5>
        <h3>{{item_detail.price}}</h3>

        <items_view_card :length="item_detail.realItems" v-bind:detail="this.item_detail"/>
        <button id="buy_btn">바로구매</button>
        <button id="cart_btn">장바구니</button>
      </div>
    </div>

<!--    v-if와 v-show
        v-if : 실제 조건부 렌더링으로 전환 도중 조건부 블록 내부의 이벤트 리스너 및 자식 컴포넌트들이 올바르게 제거되고 다시 생성된다.(lazy 렌더링을 지키는 명령, 조건이 거짓(false)이면 아무 작업도 수행하지 않는다)
        v-show : css 기반 전환으로, 초기 조건과 관계 없이 항상 렌더링된다.(DOM에 우선 렌더링하고 조건에 따라 display를 전환한다.)
        자주 전환 시 show를, 런타임 시 자주 변경되지 않는다면 if를 사용하는 것이 좋다
        *** if와 for를 함께 쓰는 것은 vue 권장사항에 해당하지 않는다.


        == 과 ===
        '=='은 값만 비교하지만 '==='은 값과 타입을 같이 비교한다.
-->


    <div id="down_detail">          <!--버튼 클릭 시마다 해당하는 내용으로 down_detail_area 내용 변경-->
      <button class="down_detail_btn"> 상세설명</button>
      <button class="down_detail_btn"> 구매후기</button>
      <button class="down_detail_btn"> 상품문의</button>
      <button class="down_detail_btn"> 교환 및 반품</button>
      <div v-show="down_detail_cnt === 0" class="down_detail_area" id="down_detail_area_desc">
          안녕하세요 임시 "상세설명" 페이지입니다.
      </div>
      <div v-show="down_detail_cnt === 1" class="down_detail_area" id="down_detail_area_review">
        안녕하세요 임시 "구매후기" 페이지입니다.
      </div>
      <div v-show="down_detail_cnt === 2" class="down_detail_area" id="down_detail_area_question">
        안녕하세요 임시 "상품문의" 페이지입니다.
      </div>
      <div v-show="down_detail_cnt === 3" class="down_detail_area" id="down_detail_area_exchange">
        안녕하세요 임시 "교환 및 반품" 페이지입니다.
      </div>
    </div>
  </div>
  <common-footer/>
</template>



<script>
import commonHeader from "../../layout/common-header";       // header 파일
import commonFooter from "../../layout/common-footer";       // footer 파일
import Items_view_card from "./items_view_card";
import {loadMenu} from "../../api/communication";

export default {
  name: 'App',
  components: {
    'common-header' : commonHeader,
    'common-footer' : commonFooter,
    'items_view_card' : Items_view_card
  },
  data(){                                                                                                               // data : 변수를 저장하는 공간
    return{
      down_detail_cnt : 0,
      search_value : this.$route.query.text,
      item_detail : []

    };
  },


  created() {                                                                                                           // created : Dom Element가 생성되기 전 호출되는 라이프사이클 훅(data에 직접 접근이 가능하기 때문에, 초기에 받아온 값들로 data를 세팅하거나 이벤트 리스너를 설정할 때 사용한다.



  },


  mounted(){                                                                                                            // mount : 인스턴스가 DOM에 마운트 된 직후 호출된다.(import로 부모 자식 간의 mount 훅 순서는 자식 -> 부모 순으로 실행된다)
    for(let i=0; i<4; i++){
      document.getElementsByClassName("down_detail_btn")[i].addEventListener("click", () => this.down_detail_cnt = i)
    }

    loadMenu(1, "query=" + this.search_value)
        .then(response => (this.item_detail = response.data,
                console.log(this.item_detail)
        ))
        .catch(e => console.log("서버에서 DB 관련 데이터를 가져오는 데, 실패하였습니다.",e))

  },
  updated() {


  },

  computed:{                                                                                                            // computed와 method의 차이점은 computed는 종속된 대상이 변하지 않는 이상 다시 계산을 하지 않는다.(lazy)
  },
  watch : {

  },

  methods: {

    down_detail_cnt_switch(){

    }


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
#up_detail{                                                                                                             /* 사진과 설명을 아우르는 위쪽에 위치한 설명 탭 전체 */
  display: inline-block;
  text-align: left;
  margin: 100px auto 0;
  width: 1000px;
  white-space: nowrap;
}

#itm_img{                                                                                                               /* 제품 사진 */
  margin : 40px 50px;
  width: 300px;
  height: 400px;
}

#right_detail{                                                                                                          /* 제품 detail div */
  display: inline-block;
  vertical-align: top;
  margin : 40px 50px;
  width: 300px;
  white-space: nowrap;
}

#down_detail{                                                                                                           /* 상세설명-질문응답-리뷰 div */
  height: 500px;
  margin-top: 70px;
}

#buy_btn, #cart_btn{
  margin-top : 70px;
  margin-right: 30px;
  width : 200px;
  height: 60px;
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

