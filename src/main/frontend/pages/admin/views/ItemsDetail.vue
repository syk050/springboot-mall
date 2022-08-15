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
        <h1><b>상품 정보</b></h1>
        <div class="w3-section w3-container w3-bottombar">
<!--          <span class="w3-left w3-xxlarge" v-on:click="fnPre(idx)">«</span>-->
<!--          <span class="w3-right w3-xxlarge" v-on:click="fnNext(idx)">»</span>-->

          <a href="/admin" class="w3-button w3-round-large w3-right w3-dark-gray" role="button">목록</a>
          <a class="w3-button w3-round-large w3-right w3-indigo" role="button">수정</a>
        </div>
      </div>
    </header>
    <!-- Header -->

    <!-- Content -->
    <div class="w3-row-padding ">
      <div class="w3-twothird">
        <img src="../../../src/assets/logo.png" style="width:60%" alt="상품 이미지">
        <table class="w3-table w3-striped w3-bordered w3-border">
          <thead class="w3-teal"><th style="width:30%">구분</th><th>내용</th></thead>
          <tr><td style="width:30%">ID</td><td>{{ id }}</td></tr>
          <tr><td>name</td><td>{{ name }}</td></tr>
        </table>
      </div>

      <div class="w3-third w3-container">
        <h1>Tag</h1>
        <div class="w3-container w3-bottombar pading-bottom">
<!--          현재 태그 -->
          <span class="w3-tag w3-blue-grey">Travel</span> <span class="w3-tag w3-blue-grey">New York</span>
          <span class="w3-tag w3-blue-grey">London</span> <span class="w3-tag w3-blue-grey">IKEA</span>
          <span class="w3-tag w3-blue-grey">NORWAY</span> <span class="w3-tag w3-blue-grey">DIY</span>
        </div>
        <div class="w3-container w3-padding-16">
<!--          추가 가능한 태그 -->
          <span class="w3-tag w3-deep-orange">Travel</span> <span class="w3-tag w3-deep-orange">New York</span>
          <span class="w3-tag w3-deep-orange">London</span> <span class="w3-tag w3-deep-orange">IKEA</span>
          <span class="w3-tag w3-deep-orange">NORWAY</span> <span class="w3-tag w3-deep-orange">DIY</span>
        </div>
      </div>
    </div>
    <!-- Content -->
  </div>
  <!-- !PAGE CONTENT! -->
</template>

<script>
export default {
  name: "ItemsList",
  data() {
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      id: '',
      name: '',
    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    fnGetView() {
      this.$axios.get('/kgd/items/' + this.idx).then(res =>{
        this.id = res.data.id
        this.name = res.data.name
      }).catch(err => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnPre(idx) {
      this.requestBody.idx = idx - 1
      this.$router.push({
        path: '/admin-item',
        query: this.requestBody
      })
    },
    fnNext(idx) {
      this.requestBody.idx = idx + 1
      this.$router.push({
        path: '/admin-item',
        query: this.requestBody
      })
    }
  }
}
</script>

<style scoped>
.pading-bottom {
  padding-bottom: 16px;
}

</style>