package com.brightslearning.webapp.demo.service.urlcounter;

import com.brightslearning.webapp.demo.service.urlcounter.UrlCallCounterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class UrlCallCounterServiceImplTest {
    private UrlCallCounterService urlCallCounterService;

    @BeforeEach
    void setUp() {
        urlCallCounterService = new UrlCallCounterServiceImpl();
    }

    @Test
    void getUrlCallCounterFor() {
        assertThat(urlCallCounterService.getUrlCallCounterFor("Sam"), is("1"));
        assertThat(urlCallCounterService.getUrlCallCounterFor("Sam"), is("2"));
        assertThat(urlCallCounterService.getUrlCallCounterFor("Bob"), is("1"));
        assertThat(urlCallCounterService.getUrlCallCounterFor("Sam"), is("3"));
    }
}