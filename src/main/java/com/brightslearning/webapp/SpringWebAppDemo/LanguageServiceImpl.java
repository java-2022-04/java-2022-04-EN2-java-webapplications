package com.brightslearning.webapp.SpringWebAppDemo;

import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Override
    public String getMyNameIs(String language) {
        switch (language) {
            case "de":
                return "Guten Tag";
            case "en":
                return "Hello";
            default:
                return "±'¿≠}–…∞";
        }
    }

    @Override
    public String getTimesCalledFor(String language) {
        switch (language) {
            case "de":
                return "Wurde so oft aufgerufen für";
            case "en":
                return "times called for";
            default:
                return "∞|][¢¶“¶¢[";
        }
    }
}
