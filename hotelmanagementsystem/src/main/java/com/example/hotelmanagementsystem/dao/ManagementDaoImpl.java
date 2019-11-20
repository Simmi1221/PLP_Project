package com.example.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

@Repository
public class ManagementDaoImpl implements ManagementDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public UserBean addAdmin(UserBean userBean) {

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		UserBean user = new UserBean();
		try {
			user.setUserName(userBean.getUserName());
			user.setEmail(userBean.getEmail());
			user.setPassword(userBean.getPassword());
			user.setPhoneNo(userBean.getPhoneNo());
			user.setAdharNo(userBean.getAdharNo());
			user.setNationality(userBean.getNationality());
			user.setUserType("admin");
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return user;
	}

	@Override
	public List<RoomInfoBean> allotment() {

		List<RoomInfoBean> roomDetails = null;
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInfoBean";
		Query query = entityManager.createQuery(jpql);
		try {
			roomDetails = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return roomDetails;
	}

	@Override
	public List<UserBean> viewCustomerDetails() {

		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userType=:type";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("type", "user");
		List<UserBean> userDetails = null;
		try {
			userDetails = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return userDetails;
	}

	@Override
	public List<BookingInfoBean> viewBillDetails() {

		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from BookingInfoBean";
		Query query = entityManager.createQuery(jpql);
		List<BookingInfoBean> billDetails = null;
		try {
			billDetails = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return billDetails;
	}
}
