<template>
    <button :style="btnClass">{{btnText}}</button>
</template>

<script>

    export default {
        props:{
            btnText:String,
            btnClass:String
        },
        data(){
            return {msg:"xxx"}
        }
    }
</script>

<style scoped>

</style>
