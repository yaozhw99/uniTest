<template>
    <UniTable :headc="headc" :sec-code="secCode" :content="content"></UniTable>
</template>

<script>
  import UniTable from "../components/UniTable";
  import Mock from "mockjs";

    export default {
        name: "Contract",
        data(){
            return {
                secCode:"name",//定义要搜索的列
                headc:[{code:"name",value:"姓名"},{code:"sex",value:"性别"},{code:"age",value:"年龄"},{code:"email",value:"Email"}],//标题定义，可调整前后顺序
                content:[
                    {name:"Jack",sex:"Male",age:15,email:"aaa@asld.com"},
                    {name:"Bill",sex:"Male",age:16,email:"qwe@asld.com"},
                    {name:"Tracy",sex:"Female",age:17,email:"zdas@asld.com"},
                    {name:"Chris",sex:"Male",age:18,email:"qweasd@asld.com"}]
            }
        },
        mounted(){
            let data=Mock.mock({
                "data|5-10":[{
                    "name":"@cname",
                    "sex|1":["Male","Female"],
                    "age|18-80":18,
                    "email":"@email"
                }]
            });
            this.content=data.data;
            let {router}=this.$router;
        },
        components:{
            UniTable
        }
    }
</script>

<style scoped>

</style>
