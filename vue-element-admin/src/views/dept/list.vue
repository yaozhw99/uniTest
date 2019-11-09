<template>
<div class="app-container">
  <div class="filter-container">
    <el-input v-model="listQuery.deptName" placeholder="部门名称" style="width: 200px;" class="filter-item" />
    <el-select v-model="listQuery.type" placeholder="人数" clearable class="filter-item" style="width: 130px">
      <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name" :value="item.key" />
    </el-select>
    <el-button class="filter-item" type="success" icon="el-icon-search" @click="getList">
      查询
    </el-button>
    <el-button type="success" @click="addDept" class="filter-item">
      新增
    </el-button>
  </div>
  <el-table
    :data="list"
    border
    fit
    highlight-current-row
    style="width: 100%;"  >
    <el-table-column label="ID" prop="id" align="center" width="80" sortable>
      <template slot-scope="scope">
        <span>{{ scope.row.id }}</span>
      </template>
    </el-table-column>
    <el-table-column label="部门人数" prop="persons" align="center" width="120" sortable>
      <template slot-scope="scope">
        <el-tag :type="scope.row.persons|typeFilter">{{ scope.row.persons }}</el-tag>
      </template>
    </el-table-column>
    <el-table-column label="部门名称" prop="deptName" align="center" sortable>
      <template slot-scope="scope">
        <span>{{ scope.row.deptName }}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作" align="center" width="280" class-name="small-padding fixed-width">
      <template slot-scope="{row}">
        <el-button type="primary" size="mini" @click="updateDept(row)">
          编辑
        </el-button>

        <el-button type="danger" size="mini" @click="deleteDept(row)">
          删除
        </el-button>
      </template>
    </el-table-column>
  </el-table>

  <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

  <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
    <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
      <el-form-item label="部门名称" prop="deptName">
        <el-input v-model="temp.deptName" />
      </el-form-item>
      <el-form-item label="部门人数" prop="persons">
        <el-input v-model="temp.persons" />
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">
        取消
      </el-button>
      <el-button type="primary" @click="saveDept">
        确认
      </el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
  import {fetchList,fetchDept,createDept,updateDept,delDept} from '@/api/dept';
  import Pagination from '@/components/Pagination';

  const calendarTypeOptions = [
      { key: '5', display_name: '小于5人' },
      { key: '10', display_name: '5~10人' },
      { key: '30', display_name: '10-30人' },
      { key: '31', display_name: '30人以上' }
  ]

    export default {
        name: 'DeptTable',
        data() {
            return {
                list:[],
                total:0,
                listQuery: {
                    page: 1,
                    limit: 10,
                    deptName:'',
                    type:undefined
                },
                calendarTypeOptions,
                textMap: {
                    update: 'Edit',
                    create: 'Create'
                },
                dialogStatus: '',
                dialogFormVisible:false,
                updateIndex:-1,
                updateRow:{},
                rules: {
                    deptName: [{ required: true, message: 'deptName is required', trigger: 'blur' }],
                    persons: [{ required: true, message: 'persons is required', trigger: 'blur' }]
                },
                temp: {
                    id: -1,
                    deptName:'',
                    persons:''
                },
            }
        },
        methods:{
            getList() {
                fetchList(this.listQuery).then(response => {
                    console.log(response);
                    this.list = response.data.items;
                    this.total = response.data.total;
                }).catch(res=>{
                    console.log(res);
                })
            },
            deleteDept(row) {
                this.$confirm('确定要删除吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    delDept(row).then(res => {
                        if (res.code == 20000) {
                            const index = this.list.indexOf(row)
                            this.list.splice(index, 1)
                        }
                        this.$notify({
                            title: "删除确认",
                            message: res.code == 20000 ? "删除成功" : "删除失败",
                            type: res.code == 20000 ? 'success' : 'error',
                            duration: 2000
                        })
                    })
                })
            },
            addDept(){
              this.dialogFormVisible=true;
            },
            updateDept(row){
                this.updateIndex=1;
                this.updateRow=row;
              this.temp.id=row.id;
              this.temp.deptName=row.deptName;
              this.temp.persons=row.persons;
              this.dialogFormVisible=true;
            },
            saveDept(){//saveDept
                console.log('begin save...')
                if(this.updateIndex==-1) {//new
                    console.log('update index =-1...')
                    let row={id:this.list.length,deptName:this.temp.deptName,persons:this.temp.persons };
                    createDept(row).then(res=>{
                        this.getList();
                        this.$notify({
                            title: "保存确认",
                            message: res.code==20000?"保存成功":"新增失败",
                            type: res.code==20000?'success':'error',
                            duration: 2000
                        })
                    })
                } else {
                    console.log('update data  ...')
                    this.temp.peoples=this.temp.persons;

                  updateDept(this.temp).then(res=>{
                      this.getList();

                      this.$notify({
                          title: "保存确认",
                          message: res.code==20000?"修改成功":"修改失败",
                          type: res.code==20000?'success':'error',
                          duration: 2000
                      })
                  }).catch(res=>{
                      console.log(res)
                  })

                }


                this.dialogFormVisible=false;
                this.updateIndex=-1;
            }
        },
        mounted() {
            this.getList();
        },
        components:{
            Pagination
        },
        filters:{
            typeFilter(value) {
                return value>15?'danger':value>10?'warning':'success';
            }
        }
    }
</script>

<style scoped>

</style>
