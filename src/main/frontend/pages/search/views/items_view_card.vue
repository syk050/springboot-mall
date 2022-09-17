<template>
  <div class="items_div">
    <div class="first_item">
      <button id="item_btn"> 아이템을 선택해주세요 </button>
    </div>
    <ul id="items_card_list">
    </ul>
  </div>
</template>

<script>
export default {

  name: "items_view_card",
  props : {
    detail : Object,    // 변수에 담아 사용하려 하니 watch문이 제대로 먹히지 않는 오류가 있다.
  },
  data(){
    return{
      imgSrc : require('../../../src/assets/pancakes.jpg'),
      is_menu_clicked : false,
    }
  },
  mounted() {
    document.getElementById("item_btn").addEventListener("click", ()=> this.show_items_list());

  },
  watch : {
    detail(){
      this.create_option_menu();
    },
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
      this.create_result_item();

    },
    create_result_item(){     // 제품 추가 시, 결과 다이얼로그
      let point_tag = document.getElementById("items_card_list");
      let tag_div = document.createElement('div');
      let tag_name = document.createElement('h2');
      let tag_delbtn = document.createElement('button');

      tag_div.setAttribute('class', 'result_div');
      tag_name.setAttribute('class', 'result_name');
      tag_delbtn.setAttribute('class', 'result_delbtn');

      tag_name.innerText = "제품명";
      tag_delbtn.innerText = "X"

      tag_div.appendChild(tag_name);
      tag_div.appendChild(tag_delbtn);
      point_tag.after(tag_div);
      point_tag.after(document.createElement('br'));
    },


    create_option_menu(){
      console.log(this.detail);
      let point_tag = document.getElementById("items_card_list");
      let li;
      let btn;
      let img;
      let p;



      for(let i=0; i<this.detail.realItems.length; i++){
        li = document.createElement('li');
        btn = document.createElement('button');
        img = document.createElement('img');
        p = document.createElement('p');

        btn.setAttribute('class', 'items_card');
        img.setAttribute('class', 'items_card_img');
        p.setAttribute('class', 'items_card_p');
        img.setAttribute('src', this.imgSrc);

        btn.addEventListener("click", ()=> (this.item_clicked()));


        p.innerText = this.detail.realItems[i].color;

        btn.appendChild(img);
        btn.appendChild(p);
        li.appendChild(btn);
        point_tag.appendChild(li);
        console.log(this.detail.realItems.length);

      }




    }



  }
}
</script>

<style>

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

.items_card_p{
  float : right;

}






</style>