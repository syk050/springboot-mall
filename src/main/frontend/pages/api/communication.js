import axios from 'axios';      // 통신 전용 자바스크립트

function loadMenu(value){
    let BASE_URL = 'kgd/name';
    if(value == "")
        BASE_URL = 'kgd/content'

    console.log(BASE_URL + value);
    return axios.get(BASE_URL + value);
}

export {loadMenu};          // 다른 파일 main.js에서 사용하기 위해 export
