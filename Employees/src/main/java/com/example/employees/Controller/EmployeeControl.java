package com.example.employees.Controller;

import com.example.employees.ApiResponse.ApiResponse;
import com.example.employees.Model.Employee;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControl {
    ArrayList<Employee> employees=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList getEmployees(){
        return employees;
    }
    @PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body("Employee Added ");
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployee(@Valid @PathVariable int index,@RequestBody Employee employee,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee Updated "));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index){
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Employee Deleted"));
    }
//    @GetMapping("/position/{index}")
//    public ApiResponse positionEmployee(@Valid @PathVariable int index, @RequestBody Employee employee, @RequestParam String position ){
//        Employee employee1=employees.get(index);
//        if(employee1.getPosition().equals("supervisor")){
//            employee1.setPosition(position);
//        }
//        return new ApiResponse(" Sorry available ");
//    }

//    @GetMapping("/onleave")
//    public ApiResponse onleaveEmployee(@Valid String onleave ) {
//        for (Employee employee:employees) {
//            if (onleave.equals(employee.getOnleave()));
//            System.out.println(false);
//        }
//        return new ApiResponse ("true");
//    }

    @GetMapping("/apply")
    public ResponseEntity applyEmployee( @Valid Errors errors){

        for (Employee employee:employees) {
            if (employee.isOnleave()){

            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(new ApiResponse(message));}

            if (employee.getAnnualleave()==0){
                String message=errors.getFieldError().getDefaultMessage();

                return ResponseEntity.status(400).body(new ApiResponse(message));
            }

        }

        return null;
    }






}
