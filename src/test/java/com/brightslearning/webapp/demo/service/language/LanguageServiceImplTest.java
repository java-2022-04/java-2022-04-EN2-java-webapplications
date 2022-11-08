package com.brightslearning.webapp.demo.service.language;

import com.brightslearning.webapp.demo.service.language.LanguageServiceImpl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageServiceImplTest {

    private LanguageServiceImpl languageService;

    @Test
    void shouldTranslateToEN_When_lang_is_en() {
        languageService = new LanguageServiceImpl();
        assertThat(languageService.getGoodDayFor("de"), is("Guten Tag"));
        assertEquals("Guten Tag", languageService.getGoodDayFor("de"));
    }

    @Test
    void getTimesCalledFor() {
    }
}