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
    detail : Object,                                                                                                    // props를 변수에 담아 사용하려 하니 watch문이 제대로 먹히지 않는 오류가 있다.
  },
  data(){
    return{
      imgSrc : require('../../../src/assets/pancakes.jpg'),
      is_menu_clicked : false,
      is_r_option_created : [],
      is_s_option_created : [],
    }
  },
  mounted() {
    document.getElementById("item_btn").addEventListener("click", ()=> this.show_items_list());

  },
  watch : {
    detail(){                                                                                                           // detail props 변수를 받아오면 실행
      this.is_r_option_created = Array(this.detail.realItems.length).fill(0);                                      // 선택되었는지 확인하는 방법
      this.is_s_option_created = Array(this.detail.subItems.length).fill(0);                                       //
      this.mount_option_menu();
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

    mount_option_menu(){                                                                                                // 본품 옵션 및 사이드 옵션 나눠서 추가
      this.create_option_menu(this.detail.realItems);
      this.create_option_menu(this.detail.subItems);
    },

    create_option_menu(a){                                                                                               // 아이템을 선택해주세요 버튼 클릭시 나오는 옵션 메뉴 생성
      console.log(a);
      let point_tag = document.getElementById("items_card_list");
      let li;
      let btn;
      let img;
      let p;




      for(let i=0; i<a.length; i++){

        let text;

        if(a[i].color === null)
          text = a[i].name;
        else
          text = a[i].color;



        li = document.createElement('li');
        btn = document.createElement('button');
        img = document.createElement('img');
        p = document.createElement('p');

        btn.setAttribute('class', 'items_card');
        img.setAttribute('class', 'items_card_img');
        p.setAttribute('class', 'items_card_p');
        img.setAttribute('src', this.imgSrc);


        if(a[i].color === null)
          btn.addEventListener("click", ()=> (this.create_result_item(i, this.is_s_option_created, this.detail.subItems, text, 1)));
        else
          btn.addEventListener("click", ()=> (this.create_result_item(i, this.is_r_option_created, this.detail.realItems, text, 0)));


        p.innerText = text;

        btn.appendChild(img);
        btn.appendChild(p);
        li.appendChild(btn);
        point_tag.appendChild(li);

      }

    },

    create_result_item(i, is_option_created, a, t, num){                                                             // 옵션 선택 혹은 추가 시, 선택확인 div 생성
      console.log(i);
      if(num == 0) {

        if(this.is_r_option_created[i] === 1) {
          alert("이미 추가된 제품입니다.");
          return
        }
        else
          this.is_r_option_created[i] = 1;

      }
      else if(num==1){

        if (this.is_s_option_created[i] === 1) {
          alert("이미 추가된 제품입니다.");
          return
        }
        else
          this.is_s_option_created[i] = 1;

      }


      let point_tag = document.getElementById("items_card_list");
      let tag_div = document.createElement('div');
      let tag_name = document.createElement('p');
      let tag_delbtn = document.createElement('button');
      let prev_addbtn = document.createElement('button');
      let num_addbtn = document.createElement('input');
      let next_addbtn = document.createElement('button');

      tag_div.setAttribute('class', 'result_div');
      tag_name.setAttribute('class', 'result_name');
      tag_delbtn.setAttribute('class', 'result_delbtn');
      prev_addbtn.setAttribute('class', 'result_minusbtn')
      num_addbtn.setAttribute('class', 'result_num_count');
      num_addbtn.setAttribute('type', 'number');
      num_addbtn.setAttribute('size', '1');
      // num_addbtn.setAttribute('readonly', '');


      tag_name.innerText = t;
      tag_delbtn.innerText = "X";

      prev_addbtn.innerText = "<";
      num_addbtn.value = 0;
      next_addbtn.innerText = ">";

      tag_delbtn.addEventListener("click", ()=>{
        if(num == 0)
          this.is_r_option_created[i] = 0;
        else
          this.is_s_option_created[i] = 0;

        let parent = tag_div.parentElement;
        parent.removeChild(tag_div);
      });

      prev_addbtn.addEventListener("click", ()=>{
        if(num_addbtn.value > 0)
          num_addbtn.value--;
      });

      next_addbtn.addEventListener("click", ()=>{
        if(num_addbtn.value < 1000)
          num_addbtn.value++;
      });

      tag_div.appendChild(tag_name);
      tag_div.appendChild(tag_delbtn);
      tag_div.appendChild(document.createElement('br'));

      tag_div.appendChild(prev_addbtn);
      tag_div.appendChild(num_addbtn);
      tag_div.appendChild(next_addbtn);

      point_tag.after(tag_div);
      point_tag.after(document.createElement('br'));


    },

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

input{
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}
input[type="number"]::-webkit-inner-spin-button,
input[type="number"]::-webkit-outer-spin-button{
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}

#items_card_list{
  width: 400px;
  height : 350px;
  display: inline-block;
  text-align: center;
  visibility: hidden;
  list-style: none;
  margin: 30px 0px 10px;
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
  border: 1px solid grey;
  border-radius: 6px;
}

.items_card_p{
  float : right;

}

.result_div{                                                                                                            /* 구매 아이템 결정 div */
  border : none;
  border-radius: 12px;
  box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2);
  width: 300px;
  height : 100px;
  margin-left : 45px;
}

.result_name{                                                                                                           /* 구매 아이템 결정 div 내의 제품명 */
  display: inline-block;
  font-family: "맑은고딕", "Malgun Gothic";
  font-weight: 600;
  font-size: 20px;
  margin-left: 30px;
}

.result_delbtn{                                                                                                         /* 구매 아이템 결정 div 내의 delete 버튼 */
  float : right;
  margin-right: 5px;
  margin-top : 8px
}
.result_num_count{
  border: none;
  width: 50px;
  text-align: center;
}






</style>