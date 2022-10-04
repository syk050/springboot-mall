<template>
  <div id="header">
    <h3>제품 등록 페이지</h3>
  </div>
  <div id="content">
    <form class="p_add_form" method="post">
      <fieldset>
        <legend>제품</legend>
        <p>제품명</p>
        <input name="p_name" id="p_name_input" class="p_input">
        <div>
          <p>관련 등록 아이템</p>
          <select name="p_rel_item" id="p_rel_item_input" class="p_input">
  <!--          옵션은 동적으로 추가할 예정 -->
          </select>
        </div>
        <p>카테고리</p>
        <select name="p_category" id="p_category_input" class="p_input">
          <!--          옵션은 동적으로 추가할 예정 -->
        </select>

        <div>
        <p>태그</p>
          <input name="p_tag" id="p_tag_input" class="p_input">
  <!--      태그 입력하고 엔터 누르면 옆에 태그 div 동적으로 추가됨-->
        </div>
        <p style="display:block">간단한 설명</p>
        <textarea cols="50" rows="4"></textarea>
        <div>
          <p>색상</p>
          <input name="p_color" id="p_color_input" class="p_input"><br/>
          <p>개수</p>
          <input name="p_count" id="p_count_input" class="p_input"><br/>
          <p>가격</p>
          <input name="p_price" id="p_price_input" class="p_input">
  <!--        색상/가격 입력 후 enter 누르면 옆에 색상-개수-가격 div 동적으로 추가  -> 해당 div 내에서 개수 및 가격 수정가능    -->
        </div>
      </fieldset>

      <fieldset>
        <legend>배송</legend>
        <p>배송 회사명</p>
        <input name="p_deli_name" id="p_deli_name_input" class="p_input"><br/>
        <p>배송금액</p>
        <input name="p_deli_price" id="p_deli_price_input" class="p_input">     <!-- 배송지별 금액 산정은 아직 고민 중 -->
      </fieldset>

      <fieldset>
      <legend>- 상품 상세페이지</legend>
      <input type="file" name="p_detail_img" id="p_detail_img_input" class="p_input">
      </fieldset>
      <fieldset>
        <legend>- 교환/반품</legend>
      </fieldset>
      <div id="btn_div">
        <button>추가</button>
        <button>초기화</button>
      </div>
    </form>
  </div>
  <common-footer/>
</template>

<script>
import commonFooter from "../../layout/common-footer";
export default {
  name: "App",
  components : {
    'common-footer' : commonFooter,
  },
  mounted() {
  }
}
</script>

<style scoped>

p{
  display: inline;
}
/* display : inline   :  줄바꿈 제거 */

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  min-width: 1000px;
}

#header, #content{
  width : 1000px;
  min-width: 1000px;
  margin: 0 auto;
}

#header{
  text-align: center;
}

#btn_div{
  text-align: center;
}
</style>