<template>
<div>
  Search：
  <input type="text" v-model="secValue">

  <el-table :data="secTable" border style="width:100%" stripe>
    <el-table-column label="姓名">
      <template slot-scope="scope">
        <span @click="godetail(scope.$index)">{{scope.row.name}}</span>

      </template>
    </el-table-column>
    <el-table-column prop="sex" label="性别"></el-table-column>
    <el-table-column prop="email" label="邮箱"></el-table-column>
    <el-table-column prop="age" label="年龄"></el-table-column>
  </el-table>

<!--  <table>-->
<!--    <thead>-->
<!--      <td v-for="(name,idx) in headc" :key="idx">{{name.value}}</td>-->
<!--    </thead>-->
<!--    <tbody>-->
<!--    <tr v-for="(value,idx2) in secTable" :key="idx2">-->
<!--      <td v-for="(val,idx3) in headc" :key="idx3">-->
<!--        <a href="#" @click="godetail(idx3)">{{value[val.code]}}</a>-->

<!--      </td>-->
<!--    </tr>-->
<!--    </tbody>-->
<!--  </table>-->
</div>

</template>

<script>
    export default {
        props:{
            secCode:String,
            headc:Array,
            content:Array
        },
        data() {
            return {
                secValue:''
            }
        },
        methods:{
            godetail(idx){
                let a=this.content[idx];
                this.$router.push({name:'tabledetail',params:{titles:this.headc,content:a}})
            }
        },
        computed:{
            secTable(){
                let{secValue,content,secCode}=this;

                let arr=content;
                if(secValue) {
                    arr=content.filter(n=>n[secCode].toString().toLowerCase().indexOf(secValue.toString().toLowerCase())!==-1)
                    // if(isNaN(secValue)) {
                    //     arr=content.filter(n=>n[secCode].toString().indexOf(secValue)!==-1);
                    // } else {
                    //     arr=content.filter(n=>n[secCode].toString()==secValue.toString());
                    // }
                }

                return arr;
            }
        }
    }
</script>

<style scoped>
  table{
    width: 100%;
    border: 2px solid orange;
    border-collapse: collapse;
    text-align: center;
  }
td{
  border: 2px solid orange;
  border-collapse: collapse;
}
  thead{
    background-color: orange;
    color: white;
    font-weight: bold;
    font-size: 20px;
  }
</style>
