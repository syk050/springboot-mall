import axios from 'axios';      // 통신 전용 자바스크립트

function loadMenu(num, value){
    let BASE_URL = 'http://localhost:8081/kgd/name?';               // 0 = search

    if(num < 2)
    {
        if(num == 1)
            BASE_URL = 'http://localhost:8081/kgd/detail?';             // 1 = detail

        console.log("spring으로 get 요청 전송,\n", BASE_URL + value);
        return axios.get(BASE_URL + value);
    }else if(num == 2){
        BASE_URL = "http://localhost:8081/kgd/product/post"

        console.log("spring으로 post 요청 전송, \n", BASE_URL)
        return axios.post(BASE_URL, value);
    }



}

export {loadMenu};          // 다른 파일 main.js에서 사용하기 위해 export
