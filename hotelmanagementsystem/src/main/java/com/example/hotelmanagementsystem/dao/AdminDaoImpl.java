package com.example.hotelmanagementsystem.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.HotelInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean addHotel(HotelInfoBean hotelInfoBean) {
		boolean isAdded = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(hotelInfoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean updateHotelDetails(HotelInfoBean hotelInfoBean) {
		boolean isUpdated = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		if (hotelInfoBean != null) {

			HotelInfoBean newHotelInfoBean = entityManager.find(HotelInfoBean.class, hotelInfoBean.getHotelId());
			if (newHotelInfoBean != null) {
				if (hotelInfoBean.getHotelName() != null) {
					newHotelInfoBean.setHotelName(hotelInfoBean.getHotelName());
				}
				if (hotelInfoBean.getLocation() != null) {
					newHotelInfoBean.setLocation(hotelInfoBean.getLocation());
				}
			}
			try {
				transaction.begin();
				entityManager.persist(newHotelInfoBean);
				transaction.commit();
				isUpdated = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		entityManager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		boolean isDeleted = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		if (hotelId > 0) {
			HotelInfoBean hotelInfoBean = entityManager.find(HotelInfoBean.class, hotelId);
			transaction.begin();
			entityManager.remove(hotelInfoBean);
			transaction.commit();
			isDeleted = true;
		}
		entityManager.close();
		return isDeleted;
	}

	@Override
	public List<HotelInfoBean> seeHotelDetails() {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelInfoBean";
		Query query = entityManager.createQuery(jpql);
		List<HotelInfoBean> hotelList = null;
		try {
			hotelList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return hotelList;
	}

	@Override
	public boolean addRoom(RoomInfoBean roomInfoBean) {
		boolean isAdded = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		if (roomInfoBean != null) {
			transaction.begin();
			entityManager.persist(roomInfoBean);
			transaction.commit();
			isAdded = true;
		}
		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean updateRoomDetails(RoomInfoBean roomInfoBean) {
		boolean isUpdated = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		if (roomInfoBean != null) {
			RoomInfoBean roomInfo = entityManager.find(RoomInfoBean.class, roomInfoBean.getRoomId());
			if (roomInfo != null) {
				if (roomInfoBean.getHotelId() != 0) {
					roomInfo.setHotelId(roomInfoBean.getHotelId());
				}
				if (roomInfoBean.getRoomType() != null) {
					roomInfo.setRoomType(roomInfoBean.getRoomType());
				}
				if (roomInfoBean.getRoomCapacity() != 0) {
					roomInfo.setRoomCapacity(roomInfoBean.getRoomCapacity());
				}
				if (roomInfoBean.getRoomRent() != 0) {
					roomInfo.setRoomRent(roomInfoBean.getRoomRent());
				}
				if (roomInfoBean.getRoomStatus() != null) {
					roomInfo.setRoomStatus(roomInfoBean.getRoomStatus());
				}

			}
			try {
				transaction.begin();
				entityManager.persist(roomInfo);
				transaction.commit();
				isUpdated = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		entityManager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteRoom(int roomId) {
		boolean isDeleted = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		if (roomId > 0) {
			RoomInfoBean roomInfoBean = entityManager.find(RoomInfoBean.class, roomId);
			transaction.begin();
			entityManager.remove(roomInfoBean);
			transaction.commit();
			isDeleted = true;
		}

		entityManager.close();
		return isDeleted;
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails() {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInfoBean";
		Query query = entityManager.createQuery(jpql);
		List<RoomInfoBean> roomList = null;
		try {
			roomList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return roomList;
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificHotel(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookingList = null;
		String jpql = "from BookingInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		try {
			bookingList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return bookingList;
	}

	@Override
	public List<BookingInfoBean> guestListOfSpecificHotel(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> guestList = null;
		String jpql = "from BookingInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		try {
			guestList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return guestList;
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificDate(LocalDate date) {
		entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookingList = null;
		String jpql = "from BookingInfoBean where checkinDate=:date";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("date", date);
		try {
			bookingList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return bookingList;
	}

	@Override
	public UserBean addEmployee(UserBean userBean) {
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
			user.setUserType("employee");
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return user;
	}
}
