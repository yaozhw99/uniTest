<template>
  <div>
  <el-table
    ref="filterTable"
    :data="tableData"
    max-height="800"
    size="small"
    style="width: 100%">
    <el-table-column
      prop="id"
      label="编号"
      width="80"
      sortable>
    </el-table-column>
    <el-table-column
      prop="date"
      label="日期"
      sortable
      width="100"
      column-key="date"
      :filters="filterDate"
      :filter-method="filterHandler"    >
    </el-table-column>
    <el-table-column
      prop="type"
      label="类别"
      sortable
      width="100">
    </el-table-column>
    <el-table-column
      prop="title"
      label="标题"
      sortable
      width="300">
    </el-table-column>
    <el-table-column
      prop="content"
      sortable
      label="内容">
    </el-table-column>
    <el-table-column
      prop="redu"
      label="热度"
      sortable
      width="100"
      :filters="[{ text: '热点新闻', value: '1' }, { text: '火爆新闻', value: '2' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.redu >=100 && scope.row.redu<200 ? 'primary' : scope.row.redu>=200?'danger':'success' "
          disable-transitions>{{scope.row.redu}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column label="操作" width="200">
      <template slot-scope="scope">
        <el-tag type="primary" @click="secDetail(scope.row.id)" style="cursor:pointer">查看</el-tag>
        <el-tag type="success" @click="editNews(scope.row)" style="cursor:pointer">编辑</el-tag>
        <el-tag type="danger" @click="delNews(scope.row)" style="cursor:pointer">删除</el-tag>
      </template>
    </el-table-column>
  </el-table>


  <el-dialog :visible.sync="dialogFormVisible">
    <el-form :model="form">
      <el-form-item label="id" :label-width="formLabelWidth">
        <el-input v-model="form.id" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="cdata" :label-width="formLabelWidth">
        <el-input v-model="form.cdata" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="title" :label-width="formLabelWidth">
        <el-input v-model="form.title" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="content" :label-width="formLabelWidth">
        <el-input v-model="form.content" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="redu" :label-width="formLabelWidth">
        <el-input v-model="form.redu" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="类别" :label-width="formLabelWidth">
        <el-select v-model="form.type" placeholder="请选择活动区域">
          <el-option label="时事热点" value="时事热点"></el-option>
          <el-option label="财经新闻" value="财经新闻"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="saveNews">确 定</el-button>
    </div>
  </el-dialog>
</div>

</template>

<script>
  import Mock from 'mockjs'

    export default {
        name: "LayoutMain",
        data() {
            return {
                msg:"alsdjflasdjflj",
                dialogFormVisible:false,
                formLabelWidth:"80px",
                rowid:'',
                form:{
                  id:'',
                    type:'',
                    cdata:'',
                    title:'',
                    content:'',
                    redu:''
                },
                tableData:[],
                filterDate:[]
            }
        },
        mounted() {
            let data=Mock.mock({
                "data|20-30":[{
                    "id|+1":1,
                    "date":'@date("yyyy-MM-dd")',
                    "type|1":["财经新闻","时事热点"],
                    "title":"@title",
                    "content":"@cparagraph",
                    "redu|20-300":50
                }]
            });

            let arr=[];
            let d=data.data;

            for (let i=0;i<d.length;i++) {
                if(arr.indexOf(d[i].date)==-1) {
                    arr.push(d[i].date);
                }
            }

            let arr2=[];
            for (let j=0;j<arr.length;j++) {
                arr2.push({"text":arr[j],"value":arr[j]});
            }
            this.filterDate=arr2;


            this.tableData=data.data;

        },
        methods: {
            filterTag(value, row) {
                return (row.redu>=100&&row.redu<200?1:row.redu>=200?2:0)==value;
            },
            filterHandler(value, row, column) {
                const property = column['property'];
                return row[property] == value;
            },
            secDetail(id) {
                this.$router.push({path:`/secone/${id}`});

            },
            editNews(row) {
              let form=this.form;
              form.id=row.id;
              form.type=row.type;
              form.cdata=row.date;
              form.title=row.title;
              form.content=row.content;
              form.redu=row.redu;
              this.dialogFormVisible=true;
            },
            saveNews() {
                let f=this.form;
                this.tableData.forEach(function(row){
                    if(row.id==f.id) {
                        row.type=f.type;
                        row.date=f.cdata;
                        row.title=f.title;
                        row.content=f.content;
                        row.redu=f.redu;
                    }
                });

                this.dialogFormVisible=false;
                this.$message({
                    message: '数据修改成功！',
                    type: 'success'
                });
            },
            delNews(row){
                this.$confirm('确定要删除吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    for (let i=0;i<this.tableData.length;i++) {
                        if (this.tableData[i].id==row.id) {
                            this.tableData.splice(i,1);
                        }
                    }
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });


            }
        }
    }

</script>

<style scoped>

</style>
