const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  outputDir: "../src/main/resources/static",  // vue 빌드 타겟 디렉토리
  devServer : {
    proxy : {
      '/kgd' : {
        // '/KGD' url로 들어오면 8080으로 접속했어도 8081(스프링 서버)로 보낸다
        target : 'http://localhost:8080',
        changeOrigin : true //cross origin 허용(CORS : Cross Origin Resource Sharing)
                            // ex) 도메인 : naver.com     오리진 : https://www.naver.com/PORT
      }
    }
  },
  transpileDependencies: true,
})
