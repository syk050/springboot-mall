<template>
  <div id="header">
    <div id="header_content">
      <div id="img_div" onclick="location.reload()">
        <img id="header_img" alt="Vue logo" src="../../src/assets/logo.png">
      </div>
      <form class="search_input_form" @submit.prevent="submit_form" >     <!-- onsubmit은 form에서 enter를 눌렀을 때, 작용하는 이벤트이다. 우선순위로 1. onsubmit 기능, 2. action에 있는 url로 이동한다. 이 때 submit이 return 한 것이 false 라면 url이동은 하지 않는다. -->
        <input id="search_input" placeholder="검색어를 입력해주세요" maxlength="20"/>
      </form>

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
  name: "common-header",
  methods:{


    submit_form(){
      let search = document.getElementById('search_input').value;                                              // javascript 에서 값을 가져올 때는 value 속성을, 값을 넣을 때에는 innerText 속성을 사용한다.
      this.$router.push({
        name : "search",                                                                                                  // test 해 보니 , push의 우선순위는 path 보다는 name에 우선되어 있다.(name이 없다면 path로 우선순위가 이동)
        path: "/search",
        query: {text : search}
      })


    },

  }

}
</script>

<style scoped>
  input:focus{
    outline : none;
  }

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
  .search_input_form{
    display: inline;
  }
  #search_input{
    margin-top: +32px;
    margin-left: 150px;
    padding-left: 40px;
    vertical-align: top;
    width: 550px;
    height : 65px;
    font-size: 25px;
    border: 0px;
    border-bottom: 3px solid;
    border-radius: 40px;
    border-color : #6e656a;
    background: transparent;
    color: #6e656a;
  }
  .menu{
    display: flex;
    list-style: none;
  }
</style>