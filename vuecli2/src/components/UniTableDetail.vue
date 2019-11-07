<template>
    <div>
      用户详细资料：

      <ul>
        <li v-for="(item,idx) in this.$route.params.titles">
          {{item.value}}:
          {{content[item.code]}}
        </li>
      </ul>
      <a href="#" @click="gohome">返回</a>
    </div>
</template>

<script>
    export default {
        name: "UniTableDetail",
        data() {
            return {
                msg: "vue template",
                content:{}
            }
        },
        mounted() {
            this.content=this.$route.params.content;
        },
        methods:{
            gohome(){
                this.$router.go(-1);
            }
        }
    }
</script>

<style scoped>

</style>
