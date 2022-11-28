package com.dbp.demo01.interfaces;
package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.UserService;
import kr.co.fastcampus.eatgo.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.dbp.demo01.controller.impl_jaden.DbpBookControllerImpl;
import com.dbp.demo01.model.Book;
import com.dbp.demo01.service.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DbpBookControllerImpl.class)
public class DbpBookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService booksService;

    @Test
    public void findBookAll() throws Exception {
        List<Book> books = new ArrayList<Book>();
        given(BDDMockito.willReturn(books));
        mvc.perform(get("/jaden/book"))
            .andExpect(status().isOk());
    }
}
