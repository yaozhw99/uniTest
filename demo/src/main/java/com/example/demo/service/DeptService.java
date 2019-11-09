package com.example.demo.service;

import com.example.demo.dao.DeptDao;
import com.example.demo.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DeptService {
    @Autowired
    private DeptDao deptDao;

    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }

    @Transactional
    public int delDept(int id) {
        return deptDao.delDept(id);
    }

    @Transactional
    public int addDept(Dept dept) {
        return deptDao.addDept(dept.getPersons(),dept.getDeptName());

    }

    @Transactional
    public int updateDept(Dept dept) {
        return deptDao.updateDept(dept.getId(),dept.getPersons(),dept.getDeptName());

    }
}
