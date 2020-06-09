package com.capgemini.onlinehotelbooking.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.exception.HotelCustomException;

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
			throw new HotelCustomException("Some thing went wrong ...user connot be register!!!");
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
			throw new HotelCustomException("Some thing went wrong ...user cannot be login!!!");
		}

		entityManager.close();
		return user;
	}

	@Override
	public EmployeeInfoBean loginAsEmployee(String email, String password) {
		entityManager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employee = null;

		String jpql = "from EmployeeInfoBean where email=:email and password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			employee = (EmployeeInfoBean) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...User cannot be login!!!");
		}

		entityManager.close();
		return employee;
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
			BookingInfoBean bookinInfoBean1 = new BookingInfoBean();
			bookinInfoBean1.setUserId(userId);
			bookinInfoBean1.setUserName(userName);
			bookinInfoBean1.setHotelName(bookingInfoBean.getHotelName());
			bookinInfoBean1.setHotelId(bookingInfoBean.getHotelId());
			int roomId = bookingInfoBean.getRoomId();
			bookinInfoBean1.setRoomId(roomId);

			String jpqlNew = "from RoomInfoBean where roomId=:roomId";
			Query queryNew = entityManager.createQuery(jpqlNew);
			queryNew.setParameter("roomId", roomId);
			RoomInfoBean roomInfoBean = (RoomInfoBean) queryNew.getSingleResult();
			double roomRent = roomInfoBean.getRoomRent();
			bookinInfoBean1.setAmount(bookingInfoBean.getAmount());
			bookinInfoBean1.setModeOfPayment(bookingInfoBean.getModeOfPayment());
			bookinInfoBean1.setPaymentStatus(bookingInfoBean.getPaymentStatus());
			Date startDate = bookingInfoBean.getCheckinDate();
			Date endDate = bookingInfoBean.getCheckoutDate();
			long calculatedDays = getdays(startDate, endDate);
			bookinInfoBean1.setCheckinDate(startDate);
			bookinInfoBean1.setCheckoutDate(endDate);
			bookinInfoBean1.setDays(calculatedDays);
			double amount = roomRent * calculatedDays;
			bookinInfoBean1.setAmount(amount);

			transaction.begin();
			entityManager.persist(bookinInfoBean1);
			transaction.commit();
			isBooked = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...Room cannot be book!!!");
		}

		entityManager.close();
		return isBooked;
	}

	@Override
	public long getdays(Date startDate, Date endDate) {
		long calculatedDays = 0;
		try {
			long difference = endDate.getTime() - startDate.getTime();
			calculatedDays = difference / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong!!!");
		}
		return calculatedDays;
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
			throw new HotelCustomException("Some thing went wrong ...Room details cannot be found!!!");
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
				throw new HotelCustomException("Some thing went wrong ...User profile cannot be update!!!");
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
		UserBean userBean = null;
		try {
			userBean = (UserBean) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...User profile cannot be found!!!");
		}
		return userBean;
	}

	@Override
	public double getBill(int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		double bill = 0;
		String jpql = "from BookingInfoBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		BookingInfoBean bookingInfoBean;
		try {
			bookingInfoBean = (BookingInfoBean) query.getSingleResult();
			bill = bookingInfoBean.getAmount();

		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...Bill cannot be generate!!!");
		}
		return bill;
	}

	@Override
	public List<RoomInfoBean> seeRoomDetailsForEmployee(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		List<RoomInfoBean> roomList = null;

		try {
			roomList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...Room Details cannot be found!!!");
		}

		entityManager.close();
		return roomList;

	}

	@Override
	public boolean bookingRoomByEmployee(BookingInfoBean bookingInfoBean) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isBooked = false;
		BookingInfoBean newBookingInfoBean = new BookingInfoBean();
		try {
			newBookingInfoBean.setUserId(bookingInfoBean.getUserId());
			newBookingInfoBean.setUserName(bookingInfoBean.getUserName());
			newBookingInfoBean.setHotelName(bookingInfoBean.getHotelName());
			newBookingInfoBean.setHotelId(bookingInfoBean.getHotelId());
			int roomId = bookingInfoBean.getRoomId();
			newBookingInfoBean.setRoomId(roomId);

			String jpqlNew = "from RoomInfoBean where roomId=:roomId";
			Query queryNew = entityManager.createQuery(jpqlNew);
			queryNew.setParameter("roomId", roomId);
			RoomInfoBean roomInfoBean = (RoomInfoBean) queryNew.getSingleResult();
			double roomRent = roomInfoBean.getRoomRent();
			newBookingInfoBean.setAmount(bookingInfoBean.getAmount());
			newBookingInfoBean.setModeOfPayment(bookingInfoBean.getModeOfPayment());
			newBookingInfoBean.setPaymentStatus(bookingInfoBean.getPaymentStatus());
			Date startDate = bookingInfoBean.getCheckinDate();
			Date endDate = bookingInfoBean.getCheckoutDate();
			long calculatedDays = getdays(startDate, endDate);
			newBookingInfoBean.setCheckinDate(startDate);
			newBookingInfoBean.setCheckoutDate(endDate);
			newBookingInfoBean.setDays(calculatedDays);
			double amount = roomRent * calculatedDays;
			newBookingInfoBean.setAmount(amount);
			transaction.begin();
			entityManager.persist(newBookingInfoBean);
			transaction.commit();
			isBooked = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...room cannot be book!!!");
		}
		entityManager.close();
		return isBooked;
	}

	@Override
	public boolean updateBookingInfoBean(BookingInfoBean bookingInfoBean, int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isUpdated=false;

		String modeOfPayment = bookingInfoBean.getModeOfPayment();
		String paymentStatus = bookingInfoBean.getPaymentStatus();
		try {
			String jpql = "from BookingInfoBean where userId=:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			BookingInfoBean newBookingInfoBean = (BookingInfoBean) query.getSingleResult();
			// int bookingId = newBookingInfoBean.getBookingId();
			newBookingInfoBean.setModeOfPayment(modeOfPayment);
			newBookingInfoBean.setPaymentStatus(paymentStatus);
			transaction.begin();
			entityManager.persist(newBookingInfoBean);
			transaction.commit();
			isUpdated=true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Something went wrong...booking info cannot found!!!");
		}

		return isUpdated;
	}

}
