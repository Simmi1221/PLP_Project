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
public class UserDaoImpl implements UserDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public UserBean register(UserBean userBean) {
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
			user.setUserType("user");
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

		entityManager.close();
		return user;
	}

	@Override
	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isBooked = false;
		String jpql = "from UserBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		try {
			UserBean userBean = (UserBean) query.getSingleResult();
			String userName = userBean.getUserName();
			BookingInfoBean bookinInfo = new BookingInfoBean();
			if (bookingInfoBean != null) {
				bookinInfo.setUserId(userId);
				bookinInfo.setUserName(userName);
				bookinInfo.setHotelId(bookingInfoBean.getHotelId());
				bookinInfo.setRoomId(bookingInfoBean.getRoomId());
				bookinInfo.setAmount(bookingInfoBean.getAmount());
				bookinInfo.setModeOfPayment(bookingInfoBean.getModeOfPayment());
				bookinInfo.setPaymentStatus(bookingInfoBean.getPaymentStatus());
				bookinInfo.setCheckinDate(bookingInfoBean.getCheckinDate());
				bookinInfo.setCheckoutDate(bookingInfoBean.getCheckoutDate());
				transaction.begin();
				entityManager.persist(bookinInfo);
				transaction.commit();
				isBooked = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isBooked;
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		List<RoomInfoBean> roomList = null;
		try {
			roomList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomList;
	}

	@Override
	public boolean updateProfile(int userId, UserBean userBean) {
		boolean isUpdated = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		if (userBean != null) {
			UserBean user = entityManager.find(UserBean.class, userId);
			if (userBean != null) {
				if (userBean.getUserName() != null) {
					user.setUserName(userBean.getUserName());
				}
				if (userBean.getEmail() != null) {
					user.setEmail(userBean.getEmail());
				}
				if (userBean.getPassword() != null) {
					user.setPassword(userBean.getPassword());
				}
				if (userBean.getUserType() != null) {
					user.setUserType(userBean.getUserType());
				}
				if (userBean.getAdharNo() != null) {
					user.setAdharNo(userBean.getAdharNo());
				}
				if (userBean.getPhoneNo() != null) {
					user.setPhoneNo(userBean.getPassword());
				}
			}
			try {
				transaction.begin();
				entityManager.persist(user);
				transaction.commit();
				isUpdated = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isUpdated;
	}

	@Override
	public UserBean getUserProfile(int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		UserBean userBean =null;
		try {
			 userBean = (UserBean) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
	}

}
