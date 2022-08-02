<template>
  <div>
    <div class="menu">
      <a v-for="(btn, i) in menus" :key="btn"> {{i}}.{{btn}} </a>
    </div>
    <br>
    <table class="table table-horizontal table-bordered">
      <thead class="thead-strong">
      <tr>
        <th>아이템 ID</th>
        <th>이름</th>
      </tr>
      </thead>
      <tbody id="tbody">
      <tr>
        <td>{{ item_id }}</td>
        <td>{{ item_name }}</td>
      </tr>
      </tbody>
    </table>
  </div>

</template>

<script>


export default {
  name: 'App',
  data() {
    return {
      // 데이터 보관함
      item_id: 1,
      item_name: "아이템 이름",

      menus: ['물품 등록', '물품 등록', '물품 등록']
    }
  },
  components: {
  }
}

</script>

<style>
.menu{
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}
.menu a {
  color: white;
  padding: 10px;
}

</style>


<!-- 최상위(Root) 컴포넌트 -->
<!-- 개발 시, vue 파일을 통해 편리하게 작성하고, 배포 시에는 npm run build를 통해 css/javascript 를 나눈 파일을 배포한다.-->

<!-- Vue 컴포넌트 파일 구조
template : 실제 Component를 구성하는 HTML코드를 작성하는 부분
script : Javascript 작성 부분
style : CSS 작성부분
-->

<!-- export default
export 문은 JS 모듈에서 함수, 객체, 원시 값을 내보낼 때 사용한다. -->

<!--
https://ko.javascript.info/import-export#ref-4122
-->