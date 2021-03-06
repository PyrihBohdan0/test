package com.project.test.springbootlesson1.controllers;

import com.project.test.springbootlesson1.dbServices.UserService;
import com.project.test.springbootlesson1.models.User;
import com.project.test.springbootlesson1.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@AllArgsConstructor
public class MainController {

    private UserService userService;
//    //    @RequestMapping(path = "/", method = RequestMethod.GET)
//    @GetMapping("/index")
//    public String login(User user) {
//            user.setName("hz");
//            return "templates/Index";
//    }

    @GetMapping("/")
    public String home(){
        return "you are at home";
    }

    @GetMapping("/save")
    public User save(User user) {
        System.out.println(user);
        return user;
    }

    @PostMapping("/save")
    public User saveUser(User user) {
        System.out.println(user);

        userService.save(user);
        System.out.println(user);
        return user;

    }

    @GetMapping("/users")
    public List<User> users (){
        List<User> all = userService.findAll();
        return all;
    }

    @GetMapping("/user/{id}")
    public User getUser (@PathVariable int id){
        User user = userService.findById(id).get();
        System.out.println(user);
        return user;
    }

    @GetMapping("/delete/{id}")
    public void deleteUser (@PathVariable int id){
        System.out.println(userService.findById(id).get());
        userService.deleteById(id);
//        System.out.println(userService.findById(id).get());
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("filexxx") MultipartFile file) throws IOException {
        String path = System.getProperty("user.home") + File.separator + "Pictures" + File.separator + file.getOriginalFilename();
        file.transferTo(new File(path));
        return "ok";
    }

    private MailService mailService;
    @GetMapping("/email/")
    public String sendEmail(@RequestParam String email,@RequestParam MultipartFile file){
        mailService.sendEmail(email,file);

        return "ok";
    }
}
