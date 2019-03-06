package com.zbw.springboot.controller;

import com.zbw.springboot.dao.DepartmentDao;
import com.zbw.springboot.dao.EmployeeDao;
import com.zbw.springboot.entities.Department;
import com.zbw.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @author zhangbin
 * @{DATE} - 20:26
 */
@Controller
public class EmployeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工
    //thymeleaf 默认会拼串，classpath:/templates/xxx.html
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }


    @GetMapping("/emp")
    public String toAddPage(Model model){
        //到员工添加页面,查出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
       model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        //redirect:重定向到一个地址 /代表当前路径
        //forward转发到一个地址
        System.out.println("保存的员工信息"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";


    }

}
