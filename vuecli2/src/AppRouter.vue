<template>
<div id="APP">
  <a @click="go">Home</a>
  <router-link to="/about">About</router-link>
  <router-link to="/contract">Contract</router-link>
  <router-link to="/news">News</router-link>
  <router-link to="/index">LayoutIndex</router-link>

  <router-view></router-view>
</div>
</template>

<script>
    export default {
        name: "AppRouter",
        data() {
            return {
                msg: "vue template"
            }
        },methods:{
            go(){
                this.$router.push({name:'home',id:'1'})
            }
        }
    }
</script>

<style>
body,html {
  margin: 0;
  padding:0;
}
/*html,body,#APP,.el-container,.el-menu{*/
/*  height: 100%;*/
/*}*/
.el-container,.el-menu{
  min-height: 100%;
}
</style>
