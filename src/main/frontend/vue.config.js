const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  outputDir: "../resources/static",
  // vue 빌드 타겟 디렉토리(빌드하면 위의 경로로 생성된다.)
  pages:{
    main:{
      entry: './pages/main/main.js',
      template: './public/main-page.html',
      filename: 'main-page.out.html'
    },
    search:{
      entry: 'pages/search/main.js',
      template: 'public/search-page.html',
      filename: 'search-page.out.html'
    },
    admin:{
      entry: 'pages/admin/main.js',
      template: 'public/admin-page.html',
      filename: 'admin-page.out.html'
      // pages : vue 페이지들
      // 경로명 :{
      //  entry :  진입점, main.js
      //  template : 빌드할 html파일
      //  filename : 빌드한 결과물의 파일명

      // 현재 경로처리가 된 상태라
      // npm run serve 명령어를 사용하여 vue 서버를 시동하면
      // localhost:8081/main, /search, admin 으로 진입이 가능함
      // 본래 빌드를 하고 테스트를 하는 방식이었으나
      // vue 서버를 기동시키고 해당 코드를 저장시키면, 즉시 서버 웹에 반영되는 이점이 있어서 vue를 사용한다.

    },
    itemadd: {

    }
  },
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
