package com.brightslearning.webapp.SpringWebAppDemo;

import org.springframework.stereotype.Service;

public interface LanguageService {

    String getMyNameIs(String language);
    String getTimesCalledFor(String language);
}
