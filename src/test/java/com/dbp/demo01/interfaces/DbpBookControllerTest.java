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

import com.dbp.demo01.controller.impl_jaden.DbpBookControllerImpl;
import com.dbp.demo01.model.Book;
import com.dbp.demo01.service.BookService;

@WebMvcTest(DbpBookControllerImpl.class)
public class DbpBookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService booksService;

    @Test
    public void findBookAll() throws Exception {
        List<Book> books = new ArrayList<Book>();
        given(booksService.findAll()).willReturn(books);
        mvc.perform(get("/jaden/book"))
            .andExpect(status().isOk());
    }
}
