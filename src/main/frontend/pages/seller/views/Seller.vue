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
      <div id="colorTagDiv">
        <p>색상</p>
        <input name="p_color" id="p_color_input" class="p_input" v-model="pColor">
      </div>
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
// import $ from "jquery"
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
    document.getElementById("p_color_input").addEventListener('keyup', this.pushColorToArray);            // Color input 입력 후, Enter 시 배열 추가 func
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

    pushColorToArray() {
      if (event.keyCode === 13) {
        if (this.pColor == '') {                                // 아무것도 입력된 것이 없으면 동작 X
          return;
        }
        else if (this.pColorArr.includes(this.pColor)) {
          alert("이미 값이 추가되었습니다");
        } else {
          this.pColorArr.push(this.pColor);             // 배열에 추가
          this.pushEffect();                            // 이펙트 동작
        }

        this.pColor = '';                               // 초기화
        console.log("pColorArr : ", this.pColorArr);
      }
    },

    pushEffect() {
      // 해당되는 input 태그에서 생성되어 오른쪽 자신의 자리로 이동하는 animation 생성 예정
      let colorTagDiv = document.getElementById("colorTagDiv");

      let tagDiv = document.createElement("div");
      let tagTxt = document.createElement("p");
      let tagDelBtn = document.createElement("button");

      tagDiv.setAttribute('class', 'tagDiv');
      tagTxt.setAttribute('class', 'tagTxt');
      tagDelBtn.setAttribute('class', 'tagDelBtn');

      tagTxt.innerText = this.pColor;
      tagDelBtn.innerText = "X";

      tagDelBtn.addEventListener("click", () => {
        let idx = this.pColorArr.indexOf(tagTxt.innerText);
        this.pColorArr.splice(idx, 1);

        let parent = tagDiv.parentElement;
        parent.removeChild(tagDiv);
      })


      tagDiv.appendChild(tagTxt);
      tagDiv.appendChild(tagDelBtn);
      colorTagDiv.appendChild(tagDiv);

    },


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

fieldset {
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

.p_input {
  margin-left: 10px;
}


#colorTagDiv {
}


#btn_div {
  text-align: center;
}

</style>


<!--scoped는 제한된 css만 적용됨(동적 적용 및 타 컴포넌트에도 적용하려면 scoped가 없는 style 작성해야 함)-->
<style>

@keyframes fadeOutRight {
  from {
    opacity: 0;
    left: -100px;
    top: -100px;
  }
  to {
    opacity: 1;
    left: 0px;
    top: 0px;
  }

}

p {
  display: inline;
  margin: 0px 3px;
}

.tagDiv {
  position: relative;
  border: 1px solid black;
  border-radius: 3px;
  margin: 2px;
  padding: 2px;
  display: inline;
  vertical-align: center;
  -webkit-animation: fadeOutRight 1s;
  -moz-animation: fadeOutRight 1s;
  -ms-animation: fadeOutRight 1s;
  -o-animation: fadeOutRight 1s;
  animation: fadeOutRight 1s;
}

/*  브라우저 호환성을 위한 처리
-webkit : 크롬 & 사파리
-moz : 파이어폭스
-o : 오페라
-ms : 인터넷 익스플로러

*/


.tagDelBtn {
  margin: 2px;
  width: 18px;
  height: 18px;
  padding: 0px;
  vertical-align: center;
}


</style>