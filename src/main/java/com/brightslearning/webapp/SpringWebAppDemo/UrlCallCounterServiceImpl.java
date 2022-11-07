package com.brightslearning.webapp.SpringWebAppDemo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlCallCounterServiceImpl implements UrlCallCounterService {

    private Map<String, Integer> numberOfGreetings = new HashMap<>();

    public String getUrlCallCounterFor(String name) {
        Integer numberOfGreatings = numberOfGreetings.get(name);
        if (numberOfGreatings == null) {
            numberOfGreatings = 0;
        }
        numberOfGreetings.put(name, ++numberOfGreatings);
        return numberOfGreatings.toString();
    }
}
