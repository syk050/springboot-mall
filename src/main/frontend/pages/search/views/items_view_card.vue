<template>
  <div class="items_div">
    <div class="first_item">
      <button id="item_btn"> 아이템을 선택해주세요 </button>
    </div>
    <ul id="items_card_list">
      <li>
        <button class="items_card">
          <img class="items_card_img" src="../../../src/assets/pancakes.jpg">
          first
        </button>
      </li>
      <li>
        <button class="items_card">
          <img class="items_card_img" src="../../../src/assets/pancakes.jpg">
          second
        </button>
      </li>
      <li>
        <button class="items_card">
          <img class="items_card_img" src="../../../src/assets/pancakes.jpg">
          third
        </button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "items_view_card",
  data(){
    return{
      is_menu_clicked : false,
    }
  },
  mounted() {
      document.getElementById("item_btn").addEventListener("click", ()=> this.show_items_list());
      for(let i=0; i<3; i++){
        document.getElementsByClassName("items_card")[i].addEventListener("click", ()=> (this.item_clicked()));
      }

  },
  methods:{
    show_items_list(){
      const dom = document.getElementById("items_card_list")
      if(!this.is_menu_clicked){
        this.is_menu_clicked = true;
        dom.style.visibility = "visible";

      }
      else{
        this.is_menu_clicked = false;
        dom.style.visibility = "hidden";
      }
    },

    item_clicked(){
      console.log("aa")
      let point_tag = document.getElementById("items_card_list");
      let insert_tag = document.createElement('a'); // 제품 추가 div 설계 전 임시 태그
      insert_tag.innerText = "추가됨";

      point_tag.after(insert_tag);
      point_tag.after(document.createElement('br'))

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
  width: 400px;
  height : 300px;
  display: inline-block;
  text-align: center;
  visibility: hidden;
  list-style: none;
  margin: 10px 0px 10px;
  padding: 10px 0px;
  border: none;
  overflow: scroll;
  -ms-overflow-style: none; /* IE */
}
#items_card_list::-webkit-scrollbar{
  display: none;
}

#item_btn{

}

.items_card{
  width: 300px;
  height : 150px;
  text-align: left;
  margin: 5px 0px;
  border-radius: 10px;
}


.items_card_img{
  width: 70px;
  height: 80px;
  margin: 10px;
  border: 0.5px solid grey;
  border-radius: 6px;
}




</style>