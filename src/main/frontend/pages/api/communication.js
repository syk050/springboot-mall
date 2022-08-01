import axios from 'axios';      // 통신 전용 자바스크립트

function loadMenu(){
    const BASE_URL = 'kgd/get';
    return axios.get(BASE_URL);
}

export {loadMenu};          // 다른 파일 main.js에서 사용하기 위해 export