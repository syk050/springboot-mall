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
          <a class="w3-button w3-round-large w3-right w3-dark-gray" role="button" v-on:click="fnCancel">취소</a>
          <a class="w3-button w3-round-large w3-right w3-indigo" role="button" v-on:click="fnSave">저장</a>
        </div>
      </div>
    </header>
    <!-- Header -->

    <!-- Content -->
    <div class="w3-row-padding ">
      <!-- 내용 -->
      <div class="w3-twothird">
        <div id="item-img">
          <img v-show="imgPath" v-bind:src="imgPath" alt="item img" style="width:60%" class="w3-hover-opacity">
          <img v-show="!imgPath" src="../../../src/assets/logo.png" style="width:60%" alt="상품 이미지">
          <div class="text-block">
            <label class="w3-button w3-small w3-round w3-green" for="input-file">이미지 등록</label> <!-- label의 for 속성을 이용해 input file 태그와 연결 -->
            <input type="file" accept="image/*" id="input-file"  style="display: none"/> <!-- 기존의 input file 태그 숨김 -->
          </div>
        </div>

        <div id="item-content">
          <table class="w3-table w3-striped w3-bordered w3-border">
            <thead class="w3-teal"><th style="width:30%">구분</th><th>내용</th></thead>
            <tr><td style="width:30%">ID</td><td>{{ id }}</td></tr>
            <tr><td>name</td><td><input type="text" v-model="name" class="w3-input w3-border"></td></tr>
          </table>
          <div id="ckeditor">
            <ckeditor :editor="editor" v-model="editorData" :config="editorConfig"></ckeditor>
          </div>
        </div>
      </div>

      <!-- 태그 -->
      <div class="w3-third w3-container">
        <h1 class="t-header">Tag</h1>
        <div id="current-tag" class="w3-container w3-bottombar w3-padding-16 dnd-box">
          <!--          현재 태그 -->
          <span id="travel" class="w3-tag">Travel</span>
          <span id="newyork" class="w3-tag">New York</span>
        </div>
        <div id="not-tag" class="w3-container w3-padding-16 dnd-box">
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
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import MyCustomUploadAdapterPlugin from "../assets/js/MyUploadAdapter";
import { dnd } from "../assets/js/dnd"

export default {
  name: "ItemModify",
  data() {
    return {
      editor: ClassicEditor,
      editorConfig: {
        // The configuration of the editor.
        extraPlugins: [ MyCustomUploadAdapterPlugin ],
      },

      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      id: '',
      name: '',
      editorData: '',
      imgPath: ''
    }
  },
  mounted() {
    this.fnGetView()
    dnd.init()
  },
  methods: {
    fnGetView() {
      this.$axios.get('/kgd/items/' + this.idx).then(res =>{
        this.id = res.data.id
        this.name = res.data.name
        this.editorData = res.data.content
        this.imgPath = res.data.imgPath
      }).catch(err => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnCancel() {
      this.$router.push({
        path: this.$itemDetail,
        query: this.requestBody
      })
    },
    fnSave() {
      // let nodeList = document.getElementById("current-tag").childNodes;
      // for (let i = 0; i < nodeList.length; i++) {
      //   console.log(nodeList[i].innerText)
      // }

      const apiUrl = '/kgd/items/' + this.idx

      this.form = {
        "name": this.name,
        "content": this.editorData
      }
      this.$axios.put(apiUrl, this.form)
          .then(() => {
            this.fnCancel()
          }).catch(err => {
            if (err.message.indexOf('Network Error') > -1) {
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }
      })
    },
    previewImg() {
      const inputFile = document.getElementById("input-file");

      inputFile.onchange = () => {
        const selectFile = inputFile.files[0];
        //const selectedFile = [...fileInput.files]; // 여러개 파일을 선택할 경우
        // console.log(selectFile);

        const fileReader = new FileReader();
        fileReader.readAsDataURL(selectFile);

        fileReader.onload = () => {
          document.getElementById("previewImg").src = fileReader.result;
        }
      }
    },
  }
}
</script>

<style scoped>
#item-img {
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