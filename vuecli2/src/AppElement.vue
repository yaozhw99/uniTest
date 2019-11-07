<template>

  <el-container>
    <el-header style="width: 100%"><layout-header></layout-header></el-header>
    <el-container>
      <el-aside><left-menu></left-menu></el-aside>
      <el-main><router-view></router-view></el-main>
    </el-container>
  </el-container>
</template>

<script>
    import LayoutHeader from "./layout/components/LayoutHeader";
    import LayoutMain from "./layout/components/LayoutMain";
    import LeftMenu from "./layout/components/LeftMenu";

    export default {
        name: "index",
        data() {
            return {
                msg: "vue index"
            }
        },components:{
            LayoutHeader,
            LayoutMain,
            LeftMenu
        }
    }
</script>

<style>
  .el-container,html,body {
    height: 100%;
  }
  .el-header {
    padding: 0!important;
  }

  .el-aside {
    width: 200px;
    /*height: 100%;*/
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin: 0;
    padding: 0;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 100%;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 100%;
  }
  html,body,#APP,.el-container,.el-menu{
    height: 100%;
    margin: 0;
    padding: 0;
  }

</style>
