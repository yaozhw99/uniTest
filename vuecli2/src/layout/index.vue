<template>

  <el-container>
    <el-header><layout-header></layout-header></el-header>
    <el-container>
      <el-aside><left-menu></left-menu></el-aside>
      <el-main><router-view></router-view></el-main>
    </el-container>
  </el-container>
</template>

<script>
  import LayoutHeader from "./components/LayoutHeader";
  import LayoutMain from "./components/LayoutMain";
  import LeftMenu from "./components/LeftMenu";

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

<style scoped>
  .el-container{
    height: 100%;
  }

  .el-aside {
    width: 500px;
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
</style>
