<template>
  <!-- Sidebar/menu -->
  <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
    <div class="w3-container">
      <a href="#" onclick="w3_close()" class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey" title="close menu">
        <i class="fa fa-remove"></i>
      </a>
      <img src="../../../../src/assets/logo.png" style="width:45%;" class="w3-round"><br><br>
      <h4><b>안녕하세요 admin님</b></h4>
      <p class="w3-text-grey">Template by W3.CSS</p>
    </div>
    <div class="w3-bar-block">
      <a href="/admin" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-text-teal"><i class="fa fa-th-large fa-fw w3-margin-right"></i>Item List</a>
      <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw w3-margin-right"></i>ABOUT</a>
      <a href="/admin/test" onclick="w3_close()" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope fa-fw w3-margin-right"></i>CONTACT</a>
    </div>
    <div class="w3-panel w3-large">
      <i class="fa fa-facebook-official w3-hover-opacity"></i> |
      <i class="fa fa-instagram w3-hover-opacity"></i> |
      <i class="fa fa-snapchat w3-hover-opacity"></i> |
      <i class="fa fa-pinterest-p w3-hover-opacity"></i> |
      <i class="fa fa-twitter w3-hover-opacity"></i> |
      <i class="fa fa-linkedin w3-hover-opacity"></i>
    </div>
  </nav>

</template>

<script>
export default {
  name: "AdminSideNav"
}
</script>

<style scoped>

</style>
