package com.luv2code.springboot.cruddemo.Controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    //add mapping for list
    @GetMapping("/list")
    public String listEmployees(Model model)
    {
        //get emp from db
        List<Employee> theEmployee=employeeService.findAll();

        //add to spring model
        model.addAttribute("employees", theEmployee);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model)
    {
        // get emp from service
        Employee theEmployee=employeeService.findById(id);

        //set emp in the model to prepopulated the form
        model.addAttribute("employee", theEmployee);

        //send to our form
        return "employees/employee-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("employeeId") int id)
    {
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }







    @GetMapping("/showFormForAdd")
    public  String showFormForAdd(Model model)
    {
        // create model attributes to bund form data
        Employee theEmployee=new Employee();

        model.addAttribute("employee",theEmployee);

        return "/employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        //save the employee
        employeeService.save(theEmployee);

        //use a redirect to prevent duplicate submission
        return "redirect:/employees/list";
    }
















}
