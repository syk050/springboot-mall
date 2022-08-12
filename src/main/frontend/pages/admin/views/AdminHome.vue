<template>
  <div class="board-list">
    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnAdd">추가</button>
    </div>

    <div class="w3-card-4" v-for="(row, idx) in list" :key="idx" v-on:click="fnView(`${row.idx}`)">
        <img src="../../../src/assets/logo.png" alt="Alps">
        <div class="w3-container">
          <p>id: {{ row.id }}</p>
          <p>name: {{ row.name }}</p>
        </div>
    </div>
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
      this.$axios.get("/kgd/items").then((res) => {
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
        path: '/kgd/items/' + idx,
        query: this.requestBody
      })
    },
    fnAdd() {
      this.$router.push({
        path: '/kgd/items/add'
      })
    }
  }
}
</script>

<style scoped>

</style>