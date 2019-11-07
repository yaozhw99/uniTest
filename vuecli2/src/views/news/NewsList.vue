<template>
<div>
  {{msg}}
  <ul>
    <li v-for="(item,idx) in news">
      <router-link :to="`/news/${item.id}`">{{item.id}}</router-link>--
      {{item.title}}--
      <button @click="gopage(idx)">编辑</button></li>
  </ul>
  <router-view></router-view>
</div>


</template>

<script>
    export default {
        name: "NewsList",
        data() {
            return {
                msg: "vue NewsList",
                news:[
                    {id:1,title:"新闻1"},
                    {id:2,title:"新闻2"},
                    {id:3,title:"新闻3"},
                    {id:4,title:"新闻4"},
                ]
            }
        },methods:{
            gopage(idx){
                // this.$router.push({path:`/news/detail/${idx}`})
                this.$router.push({name:'detail',params:{id:'2',name:'jack'}})
            }
        }
    }
</script>

<style scoped>

</style>
