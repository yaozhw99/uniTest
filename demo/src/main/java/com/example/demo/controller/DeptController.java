package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.CommEntity;
import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("list")
    public CommEntity getAll() {
        try {

            return new CommEntity(deptService.getAllDept());
        } catch (Exception e) {
            return new CommEntity(-1,"后台返回错误:"+e.getLocalizedMessage());
        }
    }

    @RequestMapping(value = "list1")
    public JSONObject getList() {
        JSONObject rs=new JSONObject();
        //String jsonstr="{\"code\":20000,\"data\":{\"items\":"+ JSONArray.toJSONString(getDeptList()) +",\"total\":\"+getDeptList().size()+\"},\"message\":\"生成成功\"}";
        return getJsonObject(deptService.getAllDept());

    }

//    //http://xxx/dept/1
//    @DeleteMapping(value = "{delid}")
//    public JSONObject delDept(@PathVariable(name="delid") int id) {

    @PostMapping(value="delete")
    public JSONObject delDept(@RequestBody JSONObject json) {
        int result=deptService.delDept(json.getIntValue("id"));
        if (result>0) {
            return getJsonObject("20000","删除成功！");
        } else {
            return getJsonObject("0","删除失败");
        }
    }

    @PostMapping(value="create")
    public JSONObject createDept(@RequestBody Dept dept) {
        int result=deptService.addDept(dept);
        if (result>0) {
            return getJsonObject("20000","新增成功！");
        } else {
            return getJsonObject("0","新增失败");
        }
    }

    @PostMapping(value="update")
    public JSONObject updateDept(@RequestBody Dept dept) {
        int result=deptService.updateDept(dept);
        if (result>0) {
            return getJsonObject("20000","修改成功！");
        } else {
            return getJsonObject("0","修改失败");
        }
    }

    private JSONObject getJsonObject(List list) {
        String jsonstr="{\"code\":20000,\"data\":{\"items\":"+ JSONArray.toJSONString(list) +",\"total\":"+list.size()+"},\"message\":\"生成成功\"}";
        return JSONObject.parseObject(jsonstr);
    }

    private JSONObject getJsonObject(String code,String msg) {
        String jsonstr="{\"code\":"+code+",\"data\":\""+msg+"\"}";
        return JSONObject.parseObject(jsonstr);
    }




}
