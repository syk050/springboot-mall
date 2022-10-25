<template>
  <common-header/>
  <div class="container">
    <form class="form">
      <h2 id="log-name">로그인</h2>
      <input type="text" id="id" placeholder="아이디를 입력해주세요">
      <input type="password" id="password" placeholder="비밀번호를 입력해주세요">
      <button type="submit" id="login">
        <span>로그인</span>
      </button>
      <input type="button" id="signup">
    </form>
  </div>
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
  .form{
    display: grid;
    place-items: center;
  }
  #log-name{
    font-family: sans-serif;
  }
  #id, #password{
    width: 25%;
    padding: 16px 15px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  #login, #signup{
    width: 25%;
    padding: 12px;
    margin: 10px 0;
    background-color: #FFE649;
    border-color: #0B1761;
    border-radius: 4px;
  }
</style>
