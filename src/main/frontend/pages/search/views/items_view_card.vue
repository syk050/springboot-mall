<template>
  <div class="items_card_list">
    <div class="first_item">
      <button id="item_btn"> 아이템을 선택해주세요 </button>
    </div>
    <ul id="items_card_list">
      <li>
        <button>
          <img class="items_card_img" src="../../../src/assets/pancakes.jpg">
          first
        </button>
      </li>
      <li>
        <button>
          <img class="items_card_img" src="../../../src/assets/pancakes.jpg">
          second
        </button>
      </li>
    </ul>
  </div>

</template>

<script>
export default {
  name: "items_view_card",
  mounted() {
    document.getElementById("item_btn").addEventListener("click", ()=> this.show_items_list())
  },
  methods:{
    show_items_list(){
      document.getElementById("items_card_list").style.visibility = "visible";
    }
  }
}
</script>

<style scoped>

button{
  background-color: transparent;
  border: none;
  border-radius: 4px;
  box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
}

#items_card_list{
  width: 200px;
  display: inline-block;
  text-align: center;

}

#item_btn{

}


ul#items_card_list{
  visibility: hidden;
  list-style: none;
  margin: 0px;
  padding: 0px;
  border: none;
}



.items_card_img{

  width: 70px;
  height: 80px;
  margin: 10px;
  border: 0.5px solid grey;
  border-radius: 6px;
}


</style>