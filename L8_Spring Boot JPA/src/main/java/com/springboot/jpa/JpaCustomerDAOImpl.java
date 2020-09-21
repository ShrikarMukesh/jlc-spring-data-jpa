package com.springboot.jpa;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class JpaCustomerDAOImpl implements CustomerDAO {

	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	public void addCustomer(Customer cust) {
		entityManager.persist(cust);
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		Customer cust2 = entityManager.merge(cust);
		return cust2;
	}

	@Override
	public Customer getCustomerByCid(int cid) {
        Customer customer = entityManager.find(Customer.class, cid);		
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String jpaql = "from Customer cust";
		List<Customer>list =  entityManager.createQuery(jpaql, Customer.class).getResultList();
		return list;
	}
	
	@Override
	public List<Customer> getCustomersByCity(String city) {
		String jpaql = "from Customer cust where city=?1";
		return entityManager.createQuery(jpaql, Customer.class).setParameter(1, city).getResultList();
	}

	@Override
	public List<Customer> getCustomersByEmail(String email) {
		String jpaql = "from Customer cust where email=?1";
		return entityManager.createQuery(jpaql,Customer.class).setParameter(1, email).getResultList();
	}

	@Override
	public List<Customer> getCustomersByEmailAndPhone(String email, long phone) {
		String jpaql = "from Customer cust where email=?1 and phone=?2";
		return entityManager.createQuery(jpaql,Customer.class).setParameter(1, email).setParameter(2, phone).getResultList();
	}

	@Override
	public List<Customer> getCustomersByEmailOrPhone(String email, long phone) {	
		return null;
	}

	public BigInteger getCustomerCount() {
		String sql="select count(*) from customers";
		return (BigInteger) entityManager.createNativeQuery(sql).getSingleResult();
	}

	@Override
	public BigInteger getCustomerCountByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCityByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getPhoneByEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getCidByPhone(long phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteCustomer(int cid) {
		// TODO Auto-generated method stub		
	}
}