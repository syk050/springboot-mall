<template>
  <!-- Sidebar/menu -->
  <adminSideNav/>

  <!-- Overlay effect when opening sidebar on small screens -->
  <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

  <!-- !PAGE CONTENT! -->
  <div class="w3-main" style="margin-left:300px">

    <!-- Header -->
    <header id="portfolio">
      <a href="#"><img src="../../../src/assets/logo.png" style="width:65px;" class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
      <span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey" onclick="w3_open()"><i class="fa fa-bars"></i></span>
      <div class="w3-container">
        <h1><b>상품 정보</b></h1>
        <div class="w3-section w3-bottombar w3-padding-16">

        </div>
      </div>
    </header>
    <!-- Header -->

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
    <!-- First Photo Grid-->

  </div>
  <!-- !PAGE CONTENT! -->
</template>

<script>
import adminSideNav from "./components/AdminSideNav";

export default {
  name: "ItemsList",
  components: {
    adminSideNav
  }
}
</script>

<style scoped>

</style>