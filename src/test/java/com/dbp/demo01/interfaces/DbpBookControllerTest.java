package com.dbp.demo01.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dbp.demo01.controller.impl_jaden.ComicBookControllerImpl;
import com.dbp.demo01.model.extd.ComicBook;
import com.dbp.demo01.service.impl_jaden.ComicBookService;

@WebMvcTest(ComicBookControllerImpl.class)
public class DbpBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComicBookService comicBooksService;

    @Test
    public void findBookAll() throws Exception {
        List<ComicBook> books = new ArrayList<ComicBook>();
        given(comicBooksService.findAll()).willReturn(books);
        mockMvc.perform(get("/jaden/book"))
            .andExpect(status().isOk());
    }
}
