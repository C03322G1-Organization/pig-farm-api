package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.EmployeeDto;
import vn.codegym.pig_farm.dto.UserDto;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.AppUser;
import vn.codegym.pig_farm.service.IEmployeeService;
import vn.codegym.pig_farm.service.IUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IUserService userService;

    /**
     * @return list Employee (test list) success: OK, error: NOT_FOUND
     * @creator LongNT
     * @day 12/09/2022
     */

    @GetMapping("")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * @param employeeDto
     * @return create Employee success: CREATED, error: NOT_ACCEPTABLE
     * @creator LongNT
     * @day 08/09/2022
     */

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> save(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto userDto;

        userDto = employeeDto.getUserDto();

        AppUser appUser = new AppUser();

        BeanUtils.copyProperties(userDto, appUser);

        userService.save(appUser);

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeDto, employee);

        employeeService.save(employee);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @param id
     * @return Employee ID success: OK, error: NOT_FOUND
     * @creator LongNT
     * @day 08/09/2022
     */

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * @param id
     * @param employeeDto
     * @return Employee edited success: OK, Employee not present: NO_CONTENT, error: NOT_ACCEPTABLE
     * @creator LongNT
     * @day 08/09/2022
     */

    @PutMapping("/edit/{id}")
    public ResponseEntity<List<FieldError>> edit(@PathVariable Integer id, @RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {

        Optional<Employee> employeeObj = employeeService.findById(id);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        if (!employeeObj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        employeeObj.get().setCode(employeeDto.getCode());

        employeeObj.get().setName(employeeDto.getName());

        employeeObj.get().setBirthDay(employeeDto.getBirthDay());

        employeeObj.get().setGender(employeeDto.getGender());

        employeeObj.get().setIdCard(employeeDto.getIdCard());

        employeeObj.get().setImage(employeeDto.getImage());

        employeeService.edit(employeeObj.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
