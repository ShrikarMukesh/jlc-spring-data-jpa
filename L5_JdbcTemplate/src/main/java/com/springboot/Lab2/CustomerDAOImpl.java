package com.springboot.Lab2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemp;
	
	public void addCustomer(Customer cust) {
		String sql = "insert into customers values(?,?,?,?,?)";
		jdbcTemp.update(sql, cust.getCid(), cust.getCname(), cust.getEmail(), cust.getPhone(),
				cust.getCity());
	}
	public List<Customer> getAllCustomers() {
		String sql = "select * from customers";
		List<Customer> list = jdbcTemp.query(sql, new CustomerRowMapper());
		return list;
	}
	@Override
	public Customer getCustomer(int cid) {
		String sql = "select * from customers where cid = ?";
		//return jdbcTemp.queryForObject(sql, new Object[]{cid}, new CustomerRowMapper());
		return jdbcTemp.queryForObject(sql, new Object[]{cid}, (rs, rowNum) ->
		
        new Customer(
                rs.getInt("cid"),
                rs.getString("cname"),
                rs.getString("email"),
                rs.getLong("phone"),
                rs.getString("city")
        ));
	}
	@Override
	public boolean deleteCustomer(int cid) {
		String sql = "delete  from jlcdb.customers where cid =?";
		 Object[] args = new Object[] {cid};

		 return jdbcTemp.update(sql, args) == 1;
	}
}