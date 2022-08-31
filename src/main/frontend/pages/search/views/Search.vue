<template>
  <common-header/>
  <div id="content">
    <div id="search_value_div">
      <h1 class="search_value">'{{ search_value }}' </h1>
      <h2 class="search_value">  에 대한 상품 검색 결과입니다.</h2>
    </div>
      <hr/>

<!--  DB에서 날마다 추천 상품 받아서 전송 -->
    <div id="search_item_list">
      <div class="items" v-for="(m,i) in menu" :key="i">
        <img class="items_img" alt="pancakes" src="../../../src/assets/pancakes.jpg">
        <h3 class="name">{{ m.name }} </h3>
        <h4 class="price">가격 : {{ m.price }}</h4>
        <h4 class="dc_rate">{{ m.dc_rate }}%</h4>
        <h4 class="deli" v-if=m.deli>무료배송</h4>
        <h4 class="deli" v-else>배송비</h4>
      </div>
      <div id="empty_notice_banner"></div>
    </div>
    <div class="items_index_div" id="items_index_div">                                                  <!-- 아이템 페이지 수, 동적으로 관리해야 함(검색된 물품 개수 / 한 페이지에 보여 줄 물품 개수 + 1) -->
    </div>                                                                         <!-- 총 index수를 가져온 다음, 페이지 첫 로드 시 <a>태그 자동 생성(10 단위로), ">>"태그나 index가 10이 넘어가면, 11에서 20까지 또는 11에서 최대 인덱스까지-->
  </div>

  <common-footer/>
</template>



<script>
import commonHeader from "../../layout/common-header";       // header 파일
import commonFooter from "../../layout/common-footer";       // footer 파일
import {loadMenu} from "../../api/communication";            // 통신전용 파일의 get 메소드
import $ from 'jquery';                                   // vue에 JQuery 적용

export default {
  name: 'App',
  components: {
    'common-header' : commonHeader,
    'common-footer' : commonFooter
  },
  data(){                                                 // data에는 변수를 저장
    return{
      search_value : this.$route.query.text,    // 검색어
      page_item_count : 6,                      // 한 페이지 당 보여줄 item 개수
      total_page : 0,                           // was에서 가져온 총 페이지 개수
      cur_page : 0,
      menu:[],                                  // 한 상품의 제원
    };
  },


  created() {                                              // Dom Element가 생성되기 전 호출되는 라이프사이클 훅
  },


  mounted(){            // 인스턴스가 마운트 된 직후 호출된다.

    this.get_WAS();


  },
  updated() {


  },

  computed:{                 // computed와 method의 차이점은 computed는 종속된 대상이 변하지 않는 이상 다시 계산을 하지 않는다.
  },
  watch : {

    $route(to, from){                           // 라우팅 값이 변했을 때 실행
      if(to.path == from.path)                        // 라우팅 값이 같은 경우, 재검색 함수 실행
        this.reSearch();
    }
  },

  methods: {

    get_WAS(str){                                                                           // was에서 DB값 get                                                             // 여기서 spring boot 서버에서 데이터 받아오고 화면 갱신 알고리즘 적용(페이지 내 재 검색을 통한 갱신)
      this.total_page = 0;
      if( typeof str == "undefined")
        str = ""
      else {
        this.search_value = this.$route.query.text;
        console.log(this.search_value)
      }
      this.fadeIn();
      loadMenu("query=" + this.search_value + str)
          .then(response => (this.menu = response.data.content,
              this.total_page = response.data.totalPages,
              console.log("spring에서 받아온 품목 : ",this.menu),
              console.log(" 총 페이지 수 : " + this.total_page),
              this.is_empty_page(),
              this.fadeOut()
              )
          )                                                                                                               // spring 서버에서 가져온 response 데이터를 변수에 저장(페이지 첫 로드)
          .catch(e => console.log("서버에서 DB 관련 데이터를 가져오는 데, 실패하였습니다.",e))

    },


    reSearch(){                                                                       // 재검색 실행 함수
      console.log("------------재검색이 활성화되었습니다.---------------");
      this.search_value = this.$route.query.text;
      this.get_WAS();
    },

    fadeIn(){
      const dom = document.getElementById('search_item_list')
      $(dom).animate({'opacity':'0'},800)
    },


    fadeOut(){
      const dom = document.getElementById('search_item_list')
      $(dom).animate({'opacity':'1'},800)
    },


    setting_index(length){                                                                                          // 페이지 index, 생성 함수
      this.reset_index();                                                                                      // index 검색 시, 초기화

      let parentTag = document.getElementById('items_index_div')

      let arrowTag;
      let tmp_id;
      let tmp_txt;
      for(let i=0; i < 2; i++){
        arrowTag = document.createElement('a');                                                                         // 화살표 index 제작
        arrowTag.setAttribute('class', 'items_index');
        tmp_id = (i == 0) ? 'arrow' : 'arrow_next';
        tmp_txt = (i == 0) ? '<' : '>';                                                                                 // 조건부 연산자 "?"를 활용
        arrowTag.setAttribute('id', tmp_id);
        if(i == 0)
          arrowTag.addEventListener("click", () => this.go_prev_page());
        else
          arrowTag.addEventListener("click", () => this.go_next_page());


        arrowTag.innerText = tmp_txt;
        parentTag.appendChild(arrowTag);
      }

      for(let i=0; i < length; i++){                                                                                    // 숫자 index 제작
        let tag = document.createElement('a')
        tag.setAttribute('class', 'items_index')
        tag.addEventListener("click",
            ()=>{
          this.get_WAS("&page=" + i);
              this.cur_page = i;
        })                                                                                                         // 매개변수를 보내면 자동 실행된다???   !!!!! 이벤트 리스너를 추가할 때, 매개변수를 주면 페이지 render()시 강제 실행된다, 이를 막기 위한 방법으로는 람다식 () => {}으로 감싸주면 매개변수도 주면서 동시에 render 시 실행도 막을 수 있다.
        tag.innerHTML = i+1
        arrowTag.before(tag)                                                                                    // appendchild는 nodelist와의 문제 때문에 [0]으로 접근해야 에러가 나지 않는다.
      }                                                                                                         // but,, after하고 before는 단일 객체를 넣는 구문이기에 [0]을 추가하지 않아도 된다.
    },

    is_empty_page(){
      if(this.total_page == 0){
        this.reset_index();
        let page = document.getElementById('empty_notice_banner');
        page.innerHTML = "";

        let tag = document.createElement('h2');
        tag.setAttribute('id', 'empty_h2');
        tag.innerHTML = "관련 상품이 존재하지 않습니다."
        page.appendChild(tag);

      }
      else{
        document.getElementById('empty_notice_banner').innerHTML = "";
        this.setting_index(this.total_page);
      }
    },

    reset_index(){
      let parentTag = document.getElementById('items_index_div')
      parentTag.innerHTML = "";
    },

    go_prev_page(){
      if(this.cur_page == 0)
        return
      this.cur_page--;
      this.get_WAS("&page=" + this.cur_page);
    },

    go_next_page(){
      if(this.cur_page == this.total_page - 1)
        return
      this.cur_page++;
      this.get_WAS("&page=" + this.cur_page);

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

#content{
  width: 1020px;
  height: 1340px;
  margin: 0 auto;         /* content 화면 정 가운데 고정 */
}

a:hover{
  color : white;
  background-color: grey;
  transition: background-color 0.2s ease-in-out,
              color 0.2s ease-in-out;

}

#search_value_div{
  margin : 80px 0 40px 0;
  /* 매개변수 개수에 따른 변화
  1개 : 4면,  2개 : 세로/가로,  3개 : 위/가로/아래,  4개 : 위/오른쪽/아래/왼쪽
  */
}

h1.search_value{
  color:#595965;
}

.search_value{
  display: inline;        /* h태그 줄넘김 없애기 */
}

#search_item_list{
  margin-top: 70px;
}

br{
  line-height: 170%;
}


.items{
  display: inline-block;
  width: 300px;
  height: 500px;
  padding: 30px 20px 0 20px;
}
.items_img{
  width: 240px;
  height: 320px;
  border-radius: 8px;
}
.name, .price, .dc_rate, .deli{
  margin: 10px 0;
}

.items_index_div {
  display: table;
  margin: 0 auto;
  padding: 40px 0;
  border-spacing: 5px;                                                                                                  /* diplay가 table일 때의 margin이라고 생각하면 편하다.(테이블 셀 간의 간격) */

}

#arrow, #arrow_next{
  position: relative;
  float: left;
  padding-bottom: 3px;
  font-size: 30px;
  margin: 0 5px;

}


.items_index{
  display: table-cell;
  vertical-align: middle;
  border: 1px gray solid;
  border-collapse: collapse;
  width:30px;
  height:30px;
  font-size: 20px;
  border-radius: 8px;
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

