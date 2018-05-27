package xyz.crearts.money.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.crearts.money.exception.NotFoundException;
import xyz.crearts.money.model.Config;
import xyz.crearts.money.service.Currency;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {
    @Mock
    private Config config;

    @Mock
    private Currency currency;

    private IndexController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(config, currency);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void indexTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("config"));
    }

    @Test
    public void categoriesTest() throws Exception {
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(view().name("categories.page"))
                .andExpect(model().attributeExists("config"));
    }

    @Test
    public void reportTest() throws Exception {
        mockMvc.perform(get("/report"))
                .andExpect(status().isOk())
                .andExpect(view().name("report.page"))
                .andExpect(model().attributeExists("config"));
    }

    @Test
    public void testNotFoundTest() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isNotFound());
    }
}
