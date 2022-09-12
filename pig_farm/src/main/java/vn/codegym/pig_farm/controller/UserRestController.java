//package vn.codegym.pig_farm.controller;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.*;
//import vn.codegym.pig_farm.dto.UserDto;
//import vn.codegym.pig_farm.entity.User;
//import vn.codegym.pig_farm.service.IUserService;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/user")
//public class UserRestController {
//
//    @Autowired
//    IUserService userService;
//
//    @GetMapping("")
//    public ResponseEntity<List<User>> findAll() {
//        List<User> users = userService.findAll();
//        if (users.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    /**
//     * @param userDto
//     * @param bindingResult
//     * @return create User
//     * @creator LongNT
//     * @day 08/09/2022
//     */
//
//    @PostMapping("")
//    public ResponseEntity<List<FieldError>> save(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
//        }
//
//        User userObj = new User();
//
//        BeanUtils.copyProperties(userDto, userObj);
//
//        userService.save(userObj);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    /**
//     * @param id
//     * @return User ID
//     * @creator LongNT
//     * @day 08/09/2022
//     */
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id) {
//        Optional<User> user = userService.findById(id);
//        if (!user.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    /**
//     * @param id
//     * @param userDto
//     * @param bindingResult
//     * @return User edited
//     * @creator LongNT
//     * @day 08/09/2022
//     */
//
//    @PutMapping("/{id}")
//    public ResponseEntity<List<FieldError>> edit(@PathVariable Integer id, @RequestBody UserDto userDto, BindingResult bindingResult) {
//        Optional<User> userObj = userService.findById(id);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
//        }
//
//        if (!userObj.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        userObj.get().setUsername(userDto.getUsername());
//
//        userObj.get().setPassword(userDto.getPassword());
//
//        userObj.get().setEmail(userDto.getEmail());
//
//        userService.edit(userObj.get());
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
