package com.brightslearning.webapp.SpringWebAppDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyWebsiteController {


    @PostMapping("/hello")
    public ResponseEntity<String> greating(@RequestParam String name, @RequestParam String food) {
        return ResponseEntity.ok("This is " + name + " and I like to eat " + food);
    }

    @GetMapping("/")
    public ResponseEntity<String> form() {
        return ResponseEntity.ok("<form action=\"/hello\" method=\"POST\">\n" +
                "<input name=\"name\" placeholder=\"Your name\">\n" +
                "<input name=\"food\" placeholder=\"A meal\">\n" +
                "<button>Go</button>\n" +
                "</form>");
    }

    private Incrementer incrementer;
    @Autowired
    public MyWebsiteController(Incrementer incrementer) {
        this.incrementer = incrementer;
    }

    @GetMapping("/hi")
    @ResponseBody
    public String greatMe(@RequestParam String name) {
        String times = incrementer.getNumberOfTimesFor(name).toString();
        return "<h1>My name is " + name + "and this method was called " + times + " times for " + name + "!</h1>";
    }

}
