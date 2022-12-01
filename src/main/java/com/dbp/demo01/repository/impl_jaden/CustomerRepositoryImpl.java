package com.dbp.demo01.repository.impl_jaden;

import com.dbp.demo01.config.DataAppConfig;
import com.dbp.demo01.model.Customer;
import com.dbp.demo01.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

	@Autowired
	private DataAppConfig dAppConfig;
	
    
    private JdbcTemplate jdbcTemplate;

	@Autowired
    public void setJdbcTemplate() {
        this.jdbcTemplate = new JdbcTemplate(dAppConfig.jadentDataSource());
    }

	@Override
	public List<Customer> findAll() {
		String SQL = "SELECT * FROM book";
		return jdbcTemplate.query(SQL, customerRowMapper());
	}

	private RowMapper<Customer> customerRowMapper() {
        return (rs, rowNum) -> {  // replace with lambda
            return Customer.builder()
                                .cusNo(rs.getInt("cusNo"))
                                .name(rs.getString("name"))
                                .id(rs.getString("id"))
                                .pwd("NULL")
                                .startDate(rs.getDate("startDate"))
                                .changeDate(rs.getDate("changeDate"))
                                .stat(rs.getInt("stat"))
                                .build();
        };
    }

}
