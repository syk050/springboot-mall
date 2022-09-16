<template>
  <div class="w3-third w3-container">
    <h1 class="t-header">Tag</h1>
    <div id="current-tag" class="w3-container w3-bottombar w3-padding-16 dnd-box">
      <!--          현재 태그 -->

    </div>
    <div id="not-tag" class="w3-container w3-padding-16 dnd-box">
      <!--          추가 가능한 태그 -->
      <span v-for="(tag, idx) in tags" :key="idx" v-bind:id="tag.tag" class="w3-tag">{{ tag.tag }}</span>
    </div>
  </div>
</template>

<script>
import { dnd } from "../../assets/js/dnd";

export default {
  name: "ItemTag",
  data() {
    return{
      tags: {},
    }
  },
  mounted() {
    this.fnGetTag()
  },
  updated() {
    dnd.init()
  },
  methods: {
    fnGetTag() {
      const apiUrl = "/kgd/tag"

      this.$axios.get(apiUrl).then(res =>{
        this.tags = res.data
      }).catch(err => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
  }
}
</script>

<style scoped>

</style>