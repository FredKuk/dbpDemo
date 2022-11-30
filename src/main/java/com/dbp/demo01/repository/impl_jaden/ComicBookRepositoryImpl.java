package com.dbp.demo01.repository.impl_jaden;

import com.dbp.demo01.config.DataAppConfig;
import com.dbp.demo01.model.extd.ComicBook;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComicBookRepositoryImpl implements ComicBookRepository{

	@Autowired
	private DataAppConfig dAppConfig;
	
    
    private JdbcTemplate jdbcTemplate;

	@Autowired
    public void setJdbcTemplate() {
        this.jdbcTemplate = new JdbcTemplate(dAppConfig.jadentDataSource());
    }

	@Override
	public List<ComicBook> findAll() {
		String SQL = "SELECT * FROM book";
		return jdbcTemplate.query(SQL, comicBookRowMapper());
	}

	private RowMapper<ComicBook> comicBookRowMapper() {
        return (rs, rowNum) -> {  // replace with lambda
            ComicBook comicBook = new ComicBook();
            comicBook.setBookId(rs.getInt("bookId"));
            comicBook.setName(rs.getString("name"));
			comicBook.setType(rs.getInt("type"));
			comicBook.setCompany(rs.getString("company"));
            return comicBook;
        };
    }

}
