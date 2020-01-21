package com.example.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;



import java.util.List;

import java.util.Map;
import java.util.Optional;

import javax.persistence.Table;



@RestController

public class LoginController {



    @Autowired
    LoginRepository loginRepository;

    

    @GetMapping("/login")

    public List<Login> index(){

        return loginRepository.findAll();

    }



    @GetMapping("/login/{id}")

    public Optional<Login> show(@PathVariable String id){

        int loginId = Integer.parseInt(id);

        return loginRepository.findById(loginId);

    }



   // @PostMapping("/login/search")

   // public List<Blog> search(@RequestBody Map<String, String> body){

     //  String searchTerm = body.get("text");

 //    return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);

  //  }



    @PostMapping("/login")

    public Login create(@RequestBody Map<String, String> body){

        String username = body.get("username");

        String password = body.get("password");

        return loginRepository.save(new Login(username, password));

    }



    @PutMapping("/login/{id}")

    public Login update(@PathVariable String id, @RequestBody Map<String, String> body){

        int loginId = Integer.parseInt(id);

        // getting login
        

        Login login = loginRepository.findOne(loginId);

        login.setUsername(body.get("username"));
 
        login.setPassword(body.get("password"));

        return loginRepository.save(login);

    }



    @DeleteMapping("login/{id}")

    public boolean delete(@PathVariable String id){

        int loginId = Integer.parseInt(id);

        loginRepository.deleteById(loginId);

        return true;

    }

}