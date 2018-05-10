package com.example.springboot.controller;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IDEA
 * Author: GuiqiHu
 * Created in: 2018/4/26 18:12
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello2")
    public String sayHello() {
        //return "Hello SpringBoot!";
        return "hello";
    }

    @RequestMapping("/hello1")
    public ModelAndView sayHello1(Model model) {
        //return "Hello SpringBoot!";
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println("haha");
        return modelAndView;
        // return "hello";
    }

    /*查询所有用户*/
    @GetMapping("/user")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @GetMapping("/user1")
    public String userList(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("u", users);
        return "index";
    }


    /*添加用户*/
    @PostMapping("/user")
    public User userAdd(@RequestParam("name") String name,
                        @RequestParam("age") Integer age,
                        @RequestParam("password") String password
    ) {
        User user = new User();
        user.setAge(age);
        user.setPassword(password);
        user.setName(name);
        return userRepository.save(user);
    }

    /*删除用户*/
    @DeleteMapping(value = "/user/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        //userRepository.deleteById(id);
        userRepository.deleteById(id);
        //sayHello1(model);
    }

    /*删除用户*/
    @RequestMapping("/delete")
    public void userDelete1(@RequestParam("id") Integer id, Model model) {
        //userRepository.deleteById(id);
        userRepository.deleteById(id);
        List<User> users = userRepository.findAll();
        model.addAttribute("user", users);

    /*    ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;*/
        sayHello1(model);
    }


    /*修改用户*/
    @PutMapping(value = "/user/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age,
                           @RequestParam("password") String password) {
        User user = new
                User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);
        return userRepository.save(user);
    }

    /*查询单个用户*/
    @GetMapping(value = "/user/{id}")
    public User userFindOne(@PathVariable("id") Integer id) {
        return userRepository.getOne(id);
    }
}