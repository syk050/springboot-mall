<template>
<!--  <commonHeader/> &lt;!&ndash; 헤더 컴포넌트 &ndash;&gt;-->
  <router-view/>  <!-- 페이지 이동이 표시될 곳 -->
<!--  <commonFooter/> &lt;!&ndash; 푸터 컴포넌트 &ndash;&gt;-->
</template>

<script>
// import commonHeader from "../layout/common-header";
// import commonFooter from "../layout/common-footer";


export default {
  name: 'App',
  components: {
    // commonHeader,
    // commonFooter
  }
}

</script>

<style>

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