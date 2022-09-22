<template>
  <common-header/>
  <div>
    <h2>로그인</h2>
  </div>
  <form>
    <input type="text" id="id" placeholder="">
    <input type="password" id="password" placeholder="">
    <input type="submit" id="login">
    <input type="button" id="signup">
  </form>
  <common-footer/>
</template>

<script>
import commonHeader from "../../layout/common-header"      // header 파일
import commonFooter from "../../layout/common-footer"     // footer 파일

export default {
  name: 'App',
  components: {
      'common-header' : commonHeader,
      'common-footer' : commonFooter
    },
}
</script>

<style>

</style>
