package com.example.hotelmanagementsystem.dao;

import java.util.Date;
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
import com.example.hotelmanagementsystem.beans.UserDetailsBean;

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

		if (hotelInfoBean != null) {
			transaction.begin();
			entityManager.persist(hotelInfoBean);
			transaction.commit();
			isAdded = true;
		}

		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean updateHotelDetails(HotelInfoBean hotelInfoBaan) {
		boolean isUpdated = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		if (hotelInfoBaan != null) {
			transaction.begin();
			HotelInfoBean hotelInfoBean1 = entityManager.find(HotelInfoBean.class, hotelInfoBaan.getHotelId());
			hotelInfoBean1.setHotelName(hotelInfoBaan.getHotelName());
			hotelInfoBean1.setLocation(hotelInfoBaan.getLocation());
			transaction.commit();
			isUpdated = true;
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
			transaction.begin();
			RoomInfoBean roomInfoBean1 = entityManager.find(RoomInfoBean.class, roomInfoBean.getRoomId());
			roomInfoBean1.setHotelId(roomInfoBean.getHotelId());
			roomInfoBean1.setRoomType(roomInfoBean.getRoomType());
			roomInfoBean1.setRoomCapacity(roomInfoBean.getRoomCapacity());
			roomInfoBean1.setRoomRent(roomInfoBean.getRoomRent());
			roomInfoBean1.setRoomStatus(roomInfoBean.getRoomStatus());
			transaction.commit();
			isUpdated = true;
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
			isDeleted=true;
		}

		entityManager.close();
		return isDeleted;
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

		return bookingList;
	}

	@Override
	public List<UserDetailsBean> guestListOfSpecificHotel(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		List<UserDetailsBean> guestList = null;
		String jpql = "from UserDetailsBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		try {
			guestList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return guestList;
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificDate(Date date) {
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

		return bookingList;
	}

}
