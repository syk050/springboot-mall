<template>
  <div id="header">
    <h3>제품 등록 페이지</h3>
  </div>
  <div id="content">
    <fieldset>          <!-- 몇몇 추가 기능은 입력 후 Enter함으로써 Array에 추가 및 Array 상태로 발송하는 알고리즘을 이용할 것-->
      <legend>제품</legend>
      <p>제품명</p>
      <input name="p_name" id="p_name_input" class="p_input" v-model="pName"><br>
      <p>관련 등록 아이템</p>
      <input name="p_rel_item" id="p_rel_item_input" class="p_input" v-model="relItmes"><br>
      <p>카테고리</p>
      <input name="p_category" id="p_category_input" class="p_input" v-model="pCategory"><br>
      <p>태그</p>
      <input name="p_tag" id="p_tag_input" class="p_input"><br>
      <p style="display:block">간단한 설명</p>
      <textarea cols="50" rows="4" name="p_clarif" id="p_clarif_input" class="p_input" v-model="pClarif"></textarea><br>
      <p>색상</p>
      <input name="p_color" id="p_color_input" class="p_input" v-model="pColor"><br>
      <p>개수</p>
      <input name="p_count" id="p_count_input" class="p_input" v-model="pCount"><br>
      <p>가격</p>
      <input name="p_price" id="p_price_input" class="p_input">
    </fieldset>

    <fieldset>
      <legend>배송</legend>
      <p>배송 회사명</p>
      <input name="p_deli_name" id="p_deli_name_input" class="p_input"><br>
      <p>배송금액</p>
      <input name="p_deli_price" id="p_deli_price_input" class="p_input">     <!-- 배송지별 금액 산정은 아직 고민 중 -->
    </fieldset>

    <fieldset>
      <legend>상품 상세페이지</legend>
      <input type="file" name="p_detail_img" id="p_detail_img_input" class="p_input">
    </fieldset>
    <fieldset>
      <legend>교환/반품</legend>
    </fieldset>
    <div id="btn_div">
      <button v-on:click="sendPost">추가</button>
      <button>초기화</button>
    </div>
  </div>
  <common-footer/>
</template>

<script>
import commonFooter from "../../layout/common-footer";
import {loadMenu} from "../../api/communication";            // 통신전용 파일의 get 메소드
export default {
  name: "App",
  components: {
    'common-footer': commonFooter,
  },
  data() {
    return {
      form: {},
      pName: '',
      relItmes: '',    // 추가 제품(자질구래한 것) 'space' 분할기능이 service 단에 있으니 ex){1, 2, 3} 처럼 관련 아이템 번호를 스페이스로 구별하여 생성
      pCategory: '',   // 최종 카테고리(자식)
      pClarif: '',
      pColor: '',      // 지원 가능 색상 배열
      pCount: '',
      pColorArr: [],
      pCountArr: [],
    }
  },
  mounted() {
    document.getElementById("p_color_input").addEventListener('keyup', this.pushColorToArray);

  },
  methods: {
    sendPost() {

      this.form = {
        "name": this.pName,
        "rel_items": this.relItmes,
        "category": this.pCategory,
        "clarif": this.pClarif,
        "c_name": this.pColor,
        "count": this.pCount,

      };

      console.log(this.form);

      loadMenu(2, this.form)
          .then(() => {
            console.log("전송완료");
          })

    },

    pushColorToArray(){
      if(event.keyCode === 13){
        this.pColorArr.push(this.pColor);
        this.pColor = '';

        console.log("pColorArr : ", this.pColorArr);
      }

    }


  }
}
</script>

<style scoped>

p {
  display: inline;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  min-width: 1000px;
}

fieldset{
  padding-left: 30px;
}

#header, #content {
  width: 1000px;
  min-width: 1000px;
  margin: 0 auto;
}

#header {
  text-align: center;
}

.p_input{
  margin-left: 10px;
}

#btn_div {
  text-align: center;
}

</style>