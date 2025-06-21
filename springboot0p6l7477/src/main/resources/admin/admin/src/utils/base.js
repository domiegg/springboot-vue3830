const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot0p6l7477/",
            name: "springboot0p6l7477",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot0p6l7477/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于JavaWeb的宠物商城平台 "
        } 
    }
}
export default base
