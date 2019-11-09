package com.example.demo.dao;

import com.example.demo.entity.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptDao {

    @Select("select * from dept")
    List<Dept> getAllDept();

    @Delete("delete from dept where id=#{id}")
    int delDept(int id);

    @Update("insert into dept(peoples,deptName) values (#{persons},#{deptName})")
    int addDept(int persons,String deptName);

    @Update("update dept a set a.peoples=#{peoples},a.deptName=#{deptName} where id=#{id}")
    int updateDept(int id,int peoples,String deptName);


}
