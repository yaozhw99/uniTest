<template>
  <el-header>
    <i class="el-icon-star-on"></i>
    中国联通广东分公司
    <i class="el-icon-star-on"></i>
  </el-header>
</template>

<script>
    export default {
        name: "LayoutHeader",
        data() {
            return {
                msg: "vue header"
            }
        }
    }
</script>

<style scoped>
.el-header{
  background-color: darkorange;
  color: white;
  height: 60px;
  line-height: 60px;
  text-align: left;
}

</style>
