package com.example.employees.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
    @NotEmpty (message = "ID should be not Empty ")
    @Size (min = 3 , message = "ID letters should be more than 2")
    private String id;

    @NotEmpty (message = "name should be not Empty ")
    @Size(min=5 , message = "Name letters should be more than 4")
    private String name;

    @NotNull (message = "Age should be not Null")
    @Size(min=26, message = "Age should be more than 25 ")
    private int age;

    @NotEmpty (message = "Position should be not Empty")
    private String position;

    @NotEmpty(message = "on leave should be not Empty")
    @AssertFalse
    private boolean onleave;

    @NotNull (message = "Employment Year should be not Null")
    @Size(min = 2023 , message = " Employment Year should be this Year")
   @PastOrPresent
    private  int employmentyear;//سنه العمل

    @NotNull(message = "Annual leave should be not Null")
    private int annualleave;//الاجازة السنوية


}
