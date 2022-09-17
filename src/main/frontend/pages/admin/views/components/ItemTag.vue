<template>
  <div class="w3-third w3-container">
    <h1 class="t-header">Tag</h1>
    <div id="current-tag" class="w3-container w3-bottombar w3-padding-16 dnd-box">
      <!--          현재 태그 -->
      <span v-for="(tag, idx) in itemTagList" :key="idx" v-bind:id="tag" class="w3-tag">{{ tag }}</span>
    </div>
    <div id="not-tag" class="w3-container w3-padding-16 dnd-box">
      <!--          추가 가능한 태그 -->
      <span v-for="(tag, idx) in tags" :key="idx" v-bind:id="tag" class="w3-tag">{{ tag }}</span>
    </div>
  </div>
</template>

<script>
import { dnd } from "../../assets/js/dnd";

export default {
  name: "ItemTag",
  props: {
    idxValue: String
  },
  data() {
    return{
      apiUrl: "/kgd/tag/",
      tags: {},
      itemTagList: {},
    }
  },
  mounted() {
    this.init()
  },
  updated() {
    dnd.init()
  },
  methods: {
    init() {
      if (this.$route.name === "ItemModify"){  // router에 등록된 name
        console.log("상품 수정 페이지")
        this.itemTagFilter();

      }else if(this.$route.name === "ItemsDetail") {
        console.log("상품 정보 페이지")
        this.getItemTag();

      }else{
        console.log('상품 등록 페이지')
        this.loadTag();

      }
    },
    async loadTag() {
      await this.$axios.get(this.apiUrl).then(res =>{
        // this.tags = res.data
        this.tags = res.data.map(x => x.tag)
      }).catch(err => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    async getItemTag() {
      await this.$axios.get(this.apiUrl + this.idxValue)
          .then(res => {
            this.itemTagList = res.data.map(x => x.tag)
          }).catch(err => {
            if (err.message.indexOf('Network Error') > -1) {
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }else{
              console.error(err);
            }
      })
    },
    itemTagFilter() {
      this.loadTag()
          .then(() => {
            this.getItemTag().then(() => {
              let s_tags = new Set(this.tags.map(x => x))
              let s_tagList = new Set(this.itemTagList.map(x => x))

              this.tags = new Set([...s_tags].filter(x => !s_tagList.has(x)))
            })
          }).catch(err => {
            console.error(err)
      })
    }
  }
}
</script>

<style scoped>

</style>