<template>
  <div id="header">
    <h3>제품 등록 페이지</h3>
  </div>
  <div id="body">
    <h2>- 제품</h2>
    <h2>- 배송</h2>
    <h2>- 상품 상세페이지</h2>
    <h2>- 배송 상세 페이지</h2>

    <button>추가</button>
    <button>초기화</button>
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
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  min-width: 1000px;
}

#header{
  min-width: 1000px;
  margin: 0 auto;
  text-align : center;
}

</style>