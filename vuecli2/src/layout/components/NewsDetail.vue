<template>
<div>
  id:{{id}}
  <button @click="goback">返回</button>
</div>
</template>

<script>
    export default {
        name: "NewsDetail",
        data() {
            return {
                msg: "vue template",
                id:this.$route.params.id
            }
        },
        methods:{
            goback(){
                this.$router.go(-1);
            }
        }
    }
</script>

<style scoped>

</style>
