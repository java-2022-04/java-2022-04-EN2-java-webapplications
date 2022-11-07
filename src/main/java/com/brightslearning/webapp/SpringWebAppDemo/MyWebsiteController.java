package com.brightslearning.webapp.SpringWebAppDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyWebsiteController {

    private LanguageService languageService;
    private UrlCallCounterService urlCallCounterService;

    @Autowired
    public MyWebsiteController(UrlCallCounterService urlCallCounterService, LanguageService languageService) {
        this.urlCallCounterService = urlCallCounterService;
        this.languageService = languageService;
    }

    @GetMapping("/hi")
    @ResponseBody
    public String greatMe(@RequestParam String name, @RequestParam String lang) {
        String numberOfCallTimes = urlCallCounterService.getUrlCallCounterFor(name);
        String firstPart = languageService.getMyNameIs(lang);
        String secondPart = languageService.getTimesCalledFor(lang);
        return "<h1>" + firstPart + " " + name + "! " + secondPart + " " + name + ": " + numberOfCallTimes + "</h1>";
    }

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
}
