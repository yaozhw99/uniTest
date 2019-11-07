<template>
      <el-menu
        unique-opened
        class="el-menu-vertical-demo"
        default-active="/detail"
        router>
        <el-submenu v-for="item in menu" :index="item.id" :key="item.id">
          <template slot="title">
            <i :class="item.icon"></i>
            <span>{{item.name}}</span>
          </template>
          <el-menu-item v-for="(sub,idx) in item.children" :index="sub.path" :key="idx">{{sub.name}}</el-menu-item>
        </el-submenu>
      </el-menu>
</template>

<script>
  import  axios from 'axios'

    export default {
        name: "LeftMenu",
        data() {
            return {
                menu:[
                    {
                        name:'新闻',
                        id:'news',
                        icon:'el-icon-goods',
                        children:[
                            {
                                name:'新闻列表',
                                path:'/detail'
                            },{
                                name:'人员列表',
                                path:'/home'
                            }
                        ]
                    }
                ]
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>

<style scoped>
  .el-menu{
    height:100%;
  }
</style>
