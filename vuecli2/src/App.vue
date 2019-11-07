<template>
<UniTable :headc="headc" :content="content" :secCode="secCode"></UniTable>
</template>

<script>
import UniTable from "./components/UniTable";
import Mock from "mockjs";

export default {

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
        "result":1,
          "message":"success",
          "data|5-10":[{
            "id|+1":1,
              "name":"@cname",
              "age:18-80":18,
              "email":"@email"
          }]
      })
      console.log(data);
  },
	components:{
      UniTable
	}
}
</script>

<style>

</style>
