<template>
  <div id="header">
    <div id="header_content">
      <div id="img_div">
        <img id="header_img" alt="Vue logo" src="../../src/assets/logo.png">
      </div>
      <input class="search_input" placeholder="검색어를 입력해주세요" maxlength="20"  />
      <button id="search_button" v-on:click="reSearch">reflesh</button>
    </div>
    <div class="category">카테고리</div>
    <ul class="menu">
      <li><a href="">신상품</a></li>
      <li><a href="">베스트</a></li>
      <li><a href="">알뜰상품</a></li>
      <li><a href="">특가혜택</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "common-header"
}
</script>

<style scoped>
  #header{
    height: 200px;
    background-color: antiquewhite;
  }
  #header_content{
    display: inline-block;
    width: 1000px;
    height: 200px;
    margin : 0 auto;
    text-align: left;

  }
  #img_div, .search_input{
    margin-top: 30px;
  }

  #img_div{
    display: inline-block;
    margin-left: 10px;
    width: 100px;
    height: 100px;
    align: left;
  }
  #header_img{
    width: 100px;
    height: 100px;
    align: left;
  }
  .search_input{
    margin-top: +32px;
    margin-left: 150px;
    padding-left: 40px;
    vertical-align: top;
    width: 550px;
    height : 65px;
    font-size: 25px;
    border: 0px;
    border-bottom: 3px solid;
    border-radius: 8px;
    border-color : #6e656a;
    background: transparent;
    color: #6e656a;
  }
  .menu{
    display: flex;
    list-style: none;

  }
</style>