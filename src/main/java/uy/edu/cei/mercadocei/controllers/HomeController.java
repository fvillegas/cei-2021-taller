package uy.edu.cei.mercadocei.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    // responde a http://localhost:8080/
    @GetMapping
    public String index() {
        return "hola mundo!!!";
    }

    // responde a http://localhost:8080/index2
    @GetMapping("index2")
    public String index2() {
        return "hola mundo reloaded!!!";
    }

}
