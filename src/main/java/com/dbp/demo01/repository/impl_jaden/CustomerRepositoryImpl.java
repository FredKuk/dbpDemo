package com.dbp.demo01.repository.impl_jaden;

import com.dbp.demo01.config.JadenDBConfig;
import com.dbp.demo01.model.Customer;
import com.dbp.demo01.repository.CustomerRepository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

	@Autowired
	private JadenDBConfig jadenDBConfig;
	  
    private JdbcTemplate jdbcTemplate;

	@Autowired
    public void setJdbcTemplate() {
        this.jdbcTemplate = new JdbcTemplate(jadenDBConfig.jadenDataSource());
    }

	@Override
	public List<Customer> findAll() {
		String SQL = "SELECT * FROM customer";
		return jdbcTemplate.query(SQL, customerRowMapper());
	}

    @Override
    public Customer findById(String id) {
		String SQL = "SELECT * FROM customer WHERE id=?";
		List<Customer> customers=jdbcTemplate.query(SQL, customerRowMapper(),id);
        if(customers.size()==1){
            return customers.get(0);
        }else{
            return null;
        }
    }
    @Override
    public Boolean create(Customer customer) {
        String SQL = "CALL createCustomer(?,?,?)";
        return jdbcTemplate.execute(SQL,new CallableStatementCallback<Boolean>() {
            public Boolean doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.setString(1, customer.getName());
                cs.setString(2, customer.getId());
                cs.setString(3, customer.getPwd());
                return !cs.execute();
            }
        });
    }

    @Override
    public Boolean update(Customer customer) {
        String SQL = "UPDATE customer SET pwd = ?, changeDate = DEFAULT WHERE id=? ";
        return jdbcTemplate.update(SQL, customer.getPwd(),customer.getId())==1? true : false;
    }

    @Override
    public Boolean delete(String id) {
        String SQL = "UPDATE customer SET stat = 2, changeDate = DEFAULT WHERE id=?";
        return jdbcTemplate.update(SQL, id)==1? true : false;
    }

	private RowMapper<Customer> customerRowMapper() {
        return (rs, rowNum) -> {  // replace with lambda
            return Customer.builder()
                                .cusNo(rs.getInt("cusNo"))
                                .name(rs.getString("name"))
                                .id(rs.getString("id"))
                                .pwd("NULL")
                                .startDate(rs.getTimestamp("startDate").toLocalDateTime())
                                .changeDate(rs.getTimestamp("changeDate").toLocalDateTime())
                                .stat(rs.getInt("stat"))
                                .build();
        };
    }
}
