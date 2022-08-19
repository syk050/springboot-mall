<template>
  <!-- Overlay effect when opening sidebar on small screens -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

  <!-- !PAGE CONTENT! -->
  <div class="w3-main" style="margin-left:300px">
    <!-- Header -->
    <header id="">
      <a href="/admin"><img src="../../../src/assets/logo.png" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
      <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
      <div class="w3-container">
        <h1><b>상품 등록</b></h1>
        <div class="w3-section w3-container w3-bottombar">
          <a class="w3-button w3-round-large w3-right w3-dark-gray" role="button" v-on:click="fnList">목록</a>
          <a class="w3-button w3-round-large w3-right w3-indigo" role="button" v-on:click="fnSave">저장</a>
        </div>
      </div>
    </header>
    <!-- Header -->

    <!-- Content -->
    <div class="w3-row-padding">
      <div class="w3-twothird ">
        <div class="container">
          <img src="../../../src/assets/logo.png" style="width:60%" alt="상품 이미지">
          <div class="text-block">
            <p><button class="w3-button w3-small w3-round w3-green">이미지 등록</button></p>
          </div>
        </div>
        <form class="w3-container w3-light-grey">
          <p>
            <label>내용</label>
            <textarea class="w3-input w3-border w3-round-large" style="resize:none; height: 300px" type="text"></textarea>
          </p>
        </form>
      </div>

      <div class="w3-third w3-container">
        <h1 class="t-header">Tag</h1>
        <div class="w3-container w3-bottombar w3-padding-16 dnd-box r-tag">
          <!--          현재 태그 -->
          <span id="travel" class="w3-tag">Travel</span>
          <span id="newyork" class="w3-tag">New York</span>
        </div>
        <div class="w3-container w3-padding-16 dnd-box n-tag">
          <!--          추가 가능한 태그 -->
          <span id="london" class="w3-tag">London</span>
          <span id="ikea" class="w3-tag">IKEA</span>
          <span id="norway" class="w3-tag">NORWAY</span>
          <span id="diy" class="w3-tag">DIY</span>
        </div>
      </div>
    </div>
    <!-- Content -->
  </div>
  <!-- !PAGE CONTENT! -->
</template>

<script>
export default {
  name: "ItemAdd"
}
</script>

<style scoped>
.container {
  position: relative;
}

.text-block {
  position: absolute;
  bottom: 20px;
  right: 20px;
  padding-left: 20px;
  padding-right: 20px;
}

</style>