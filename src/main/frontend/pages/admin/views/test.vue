<template>
  <!-- Overlay effect when opening sidebar on small screens -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

  <!-- !PAGE CONTENT! -->
  <div class="w3-main" style="margin-left:300px">

    <!-- Header -->
    <header id="header">
      <a href="/admin"><img src="../../../src/assets/logo.png" alt="아이콘" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
      <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
      <div class="w3-container">
        <h1><b>상품 리스트</b></h1>
        <div class="w3-section w3-bottombar w3-padding-16">
          <span class="w3-margin-right">Filter:</span>
          <button class="w3-button w3-black">ALL</button>
          <!--          <button class="w3-button w3-white"><i class="fa fa-diamond w3-margin-right"></i>Design</button>-->
          <!--          <button class="w3-button w3-white w3-hide-small"><i class="fa fa-photo w3-margin-right"></i>Photos</button>-->
          <!--          <button class="w3-button w3-white w3-hide-small"><i class="fa fa-map-pin w3-margin-right"></i>Art</button>-->
          <button class="w3-button w3-indigo w3-right" v-on:click="fnAdd">추가</button>
        </div>
      </div>
    </header>

    <!-- First Photo Grid-->
    <div class="w3-row-padding" v-for="idx in Math.ceil(itemList.length/3)" :key="idx">
      <div v-for="i in 3" :key="i">
        <div class="w3-third w3-container w3-margin-bottom" v-if="listNotOver">
          <div class="img-box">
            <img id="previewImg" v-show="itemList[index].imgPath" v-bind:src="itemList[index].imgPath" alt="item img" style="width:100%" class="w3-hover-opacity">
            <img id="previewImg" v-show="!itemList[index].imgPath" src="../../../src/assets/logo.png" alt="Temp Logo" style="width:100%" class="w3-hover-opacity">
<!--            <img id="previewImg" src="../../../src/assets/logo.png" alt="Temp Logo" style="width:100%" class="w3-hover-opacity">-->
          </div>
          <div class="w3-container w3-white">
            <p><b>{{ this.itemList[index].name }}</b></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "testPage",
  data() { //변수 생성
    return {
      itemList: [
          {'id': 1, 'name': '1번', 'imgPath': undefined}, {'id': 2, 'name': '2번', 'imgPath': undefined}, {'id': 3, 'name': '3번', 'imgPath': undefined},
          {'id': 4, 'name': '4번', 'imgPath': undefined}, {'id': 5, 'name': '5번', 'imgPath': undefined}, {'id': 6, 'name': '6번', 'imgPath': undefined},
          {'id': 7, 'name': '7번', 'imgPath': undefined}
      ],
      index: 0
    }
  },
  methods: {
    addIndex() {
      this.index += 1
      console.log(this.index)
    },
  },
  computed: {
    listNotOver() {
      // this.index = this.index + 1
      return this.itemList.length > this.index ? 1 : 0;
    },
    getIndex() {
      // this.index += 1
      return this.index
    }
  }
}
</script>

<style scoped>

</style>
