<template>
<div>
  {{this.$route.params.id}}--{{this.$route.params.name}}
</div>
</template>

<script>
    export default {
        name: "NewsDetail",
        data() {
            return {
                msg: "vue news detail",
                para:'ddd'
            }
        },
        computed(){
            console.log('ddddd')
        }
    }
</script>

<style scoped>

</style>
