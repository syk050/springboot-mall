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
          <a class="w3-button w3-right w3-dark-gray" role="button" v-on:click="fnList">목록</a>
          <a class="w3-button w3-right w3-indigo" role="button" v-on:click="fnModify">수정</a>
          <a class="w3-button w3-right w3-purple" role="button" v-on:click="fnDelete">삭제</a>
        </div>
      </div>
    </header>
    <!-- Header -->

    <!-- Content -->
    <div class="w3-row-padding ">
      <div class="w3-twothird">
        <img id="previewImg" v-show="imgPath" v-bind:src="imgPath" alt="item img" style="width:60%" class="w3-hover-opacity">
        <img id="previewImg" v-show="!imgPath" src="../../../src/assets/logo.png" alt="Temp Logo" style="width:60%" class="w3-hover-opacity">
        <div>
          <table class="w3-table w3-striped w3-bordered w3-border">
            <thead class="w3-teal"><th style="width:30%">구분</th><th>내용</th></thead>
            <tr><td style="width:30%">ID</td><td>{{ id }}</td></tr>
            <tr><td>name</td><td>{{ name }}</td></tr>
          </table>
          <div id="content">

          </div>
        </div>
      </div>

      <!--   태그   -->
      <itemTag :idxValue="idx"/>
    </div>
    <!-- Content -->
  </div>
  <!-- !PAGE CONTENT! -->
</template>

<script>
import itemTag from "./components/ItemTag";

export default {
  name: "ItemsList",
  data() {
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      id: '',
      name: '',
      imgPath:'',
    }
  },
  components: {
    itemTag
  },
  mounted() {
    this.fnGetView()
  },
  methods: {      // 여기!!!!!!!!!!!!!!!
    fnGetView() {
      this.$axios.get('/kgd/items/' + this.idx).then(res =>{
        this.id = res.data.id
        this.name = res.data.name
        this.imgPath = res.data.imgPath
        document.getElementById("content").innerHTML = res.data.content
      }).catch(err => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: '/admin',
        query: this.requestBody
      })
    },
    fnModify() {
      this.$router.push({
        path: this.$itemModify,
        query: this.requestBody
      })
    },
    fnDelete() {
      if (!confirm("삭제하시겠습니까?")) return

      this.$axios.delete('/kgd/items/' + this.idx).then(() => {
        alert('삭제되었습니다');
        this.fnList();
      }).catch(err => {
        console.log(err);
      })
    }
  }
}
</script>

<style scoped>


</style>