package com.brightslearning.webapp.demo.language;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LanguageServiceImplTest {

    @Test
    void getMyNameIs() {
        assertThat(new LanguageServiceImpl().getGoodDayFor("de"), is("Guten Tag"));
    }

    @Test
    void getTimesCalledFor() {
    }
}