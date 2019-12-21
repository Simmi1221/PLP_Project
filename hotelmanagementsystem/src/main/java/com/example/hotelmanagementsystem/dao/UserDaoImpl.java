package com.example.hotelmanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public UserBean register(UserBean userBean) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		UserBean userBean1 = new UserBean();
		try {
			userBean1.setUserName(userBean.getUserName());
			userBean1.setEmail(userBean.getEmail());
			userBean1.setPassword(userBean.getPassword());
			userBean1.setUserType("user");
			transaction.begin();
			entityManager.persist(userBean1);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean1;
	}

	@Override
	public UserBean login(String email, String password) {
		entityManager = entityManagerFactory.createEntityManager();
		UserBean user = null;

		String jpql = "from UserBean where email=:email and password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			user = (UserBean) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isBooked = false;
		BookingInfoBean bookinInfoBean1 = new BookingInfoBean();
		if (bookingInfoBean != null) {
			bookinInfoBean1.setUserId(userId);
			bookinInfoBean1.setHotelId(bookingInfoBean.getHotelId());
			bookinInfoBean1.setRoomId(bookingInfoBean.getRoomId());
			bookinInfoBean1.setAmount(bookingInfoBean.getAmount());
			bookinInfoBean1.setModeOfPayment(bookingInfoBean.getModeOfPayment());
			bookinInfoBean1.setPaymentStatus(bookingInfoBean.getPaymentStatus());
			bookinInfoBean1.setCheckinDate(bookingInfoBean.getCheckinDate());
			bookinInfoBean1.setCheckoutDate(bookingInfoBean.getCheckoutDate());
			transaction.begin();
			entityManager.persist(bookinInfoBean1);
			transaction.commit();
			isBooked = true;
		}

		return isBooked;
	}

}
