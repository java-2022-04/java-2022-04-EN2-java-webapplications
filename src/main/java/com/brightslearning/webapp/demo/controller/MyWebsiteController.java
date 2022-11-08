package com.brightslearning.webapp.demo.controller;

import com.brightslearning.webapp.demo.service.language.LanguageService;
import com.brightslearning.webapp.demo.service.language.LanguageServiceImpl;
import com.brightslearning.webapp.demo.service.urlcounter.UrlCallCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyWebsiteController {

    private final LanguageService languageService;
    private final UrlCallCounterService urlCallCounterService;

    @Autowired
    public MyWebsiteController(UrlCallCounterService urlCallCounterService, LanguageService languageService) {
        this.urlCallCounterService = urlCallCounterService;
        this.languageService = languageService;
    }

    @GetMapping("/hi")
    @ResponseBody
    public String greatMe(@RequestParam String name, @RequestParam String lang) {
        String numberOfCallTimes = urlCallCounterService.getUrlCallCounterFor(name);
        String firstPart = languageService.getGoodDayFor(lang);
        String secondPart = languageService.getTimesCalledFor(lang);
        return String.format("<h1>%s %s!</h1> <p><b>%s %s</b> %s</p>",
                firstPart, name, secondPart, name, numberOfCallTimes);
    }

    @PostMapping("/hello")
    public ResponseEntity<String> greeting(@RequestParam String name, @RequestParam String food) {
        return ResponseEntity.ok(String.format("This is %s and I like to eat %s", name, food));
    }

    @GetMapping("/")
    public ResponseEntity<String> form() {
        return ResponseEntity.ok("<form action=\"/hello\" method=\"POST\">" +
                "<input name=\"name\" placeholder=\"Your name\">" +
                "<input name=\"food\" placeholder=\"A meal\">" +
                "<button>Go</button>" +
                "</form>");
    }
}
