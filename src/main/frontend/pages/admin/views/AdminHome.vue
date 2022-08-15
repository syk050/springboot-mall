<template>
  <!-- Overlay effect when opening sidebar on small screens -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

  <!-- !PAGE CONTENT! -->
  <div class="w3-main" style="margin-left:300px">

    <!-- Header -->
    <header id="portfolio">
      <a href="/admin"><img src="../../../src/assets/logo.png" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
      <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
      <div class="w3-container">
        <h1><b>상품 리스트</b></h1>
        <div class="w3-section w3-bottombar w3-padding-16">
          <span class="w3-margin-right">Filter:</span>
          <button class="w3-button w3-black">ALL</button>
          <button class="w3-button w3-white"><i class="fa fa-diamond w3-margin-right"></i>Design</button>
          <button class="w3-button w3-white w3-hide-small"><i class="fa fa-photo w3-margin-right"></i>Photos</button>
          <button class="w3-button w3-white w3-hide-small"><i class="fa fa-map-pin w3-margin-right"></i>Art</button>
        </div>
      </div>
    </header>

    <!-- First Photo Grid-->
    <div class="w3-row-padding">
      <div class="w3-third w3-container w3-margin-bottom" v-for="(item, idx) in list" :key="idx"  v-on:click="fnView(`${item.id}`)">
        <img src="../../../src/assets/logo.png" alt="Temp Logo" style="width:100%" class="w3-hover-opacity">
        <div class="w3-container w3-white">
          <p><b>{{ item.name }}</b></p>
          <p class="">
            <span class="w3-tag w3-blue-grey">Travel</span> <span class="w3-tag w3-blue-grey">New York</span>
            <span class="w3-tag w3-blue-grey">London</span> <span class="w3-tag w3-blue-grey">IKEA</span>
            <span class="w3-tag w3-blue-grey">NORWAY</span> <span class="w3-tag w3-blue-grey">DIY</span>
          </p>
        </div>
      </div>
    </div>

<!--    &lt;!&ndash; Pagination &ndash;&gt;-->
<!--    <div class="w3-center w3-padding-32">-->
<!--      <div class="w3-bar">-->
<!--        <a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>-->
<!--        <a href="#" class="w3-bar-item w3-black w3-button">1</a>-->
<!--        <a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>-->
<!--        <a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>-->
<!--        <a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>-->
<!--        <a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>-->
<!--      </div>-->
<!--    </div>-->
  </div>
</template>

<script>
export default {
  name: "AdminHome",
  data() { //변수 생성
    return {
      requestBody: {},
      list: {}
    }
  },
  mounted() {
    this.fnGetList()
  },
  methods: {
    fnGetList() {
      this.$axios.get( "/kgd/items").then((res) => {
        this.list = res.data
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: '/admin-item',
        query: this.requestBody
      })
    },
    fnAdd() {
      this.$router.push({
        path: '/kgd/items/add'
      })
    }
  },
}
</script>

<style scoped>
.w3-tag {
  margin-right: 5px;
  margin-bottom: 5px;
}

</style>