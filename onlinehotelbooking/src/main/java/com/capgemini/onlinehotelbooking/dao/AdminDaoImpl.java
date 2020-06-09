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
import com.capgemini.onlinehotelbooking.beans.HotelInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.exception.HotelCustomException;

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
			throw new HotelCustomException("Some thing went wrong ...Hotel cannot be add!!!");
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
				throw new HotelCustomException("Some thing went wrong ...Hotel cannot be update!!!");
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
		try {
			HotelInfoBean hotelInfoBean = entityManager.find(HotelInfoBean.class, hotelId);
			transaction.begin();
			entityManager.remove(hotelInfoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...Hotel cannot be delete!!!");
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
			throw new HotelCustomException("Some thing went wrong ...Hotel details canot be found!!!");
		}

		entityManager.close();
		return hotelList;
	}

	@Override
	public boolean addRoom(RoomInfoBean roomInfoBean) {
		boolean isAdded = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(roomInfoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...Room cannot be add!!!");
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
				throw new HotelCustomException("Some thing went wrong ...Room Details cannot be update!!!");
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

		try {
			RoomInfoBean roomInfoBean = entityManager.find(RoomInfoBean.class, roomId);
			transaction.begin();
			entityManager.remove(roomInfoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Some thing went wrong ...Room cannot be delete!!!");
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
			throw new HotelCustomException("Some thing went wrong ...Room Details cannot be found!!!");
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
			throw new HotelCustomException(
					"Some thing went wrong ...Booking list of specific hotel cannot be found!!!");
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
			throw new HotelCustomException("Some thing went wrong ...Guest List of specific hotel cannot be found!!!");
		}

		entityManager.close();
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
			throw new HotelCustomException("Some thing went wrong ...Guest List of specific date cannot be found!!!");
		}

		entityManager.close();
		return bookingList;
	}

	@Override
	public EmployeeInfoBean addEmployee(EmployeeInfoBean employeeBean) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		EmployeeInfoBean employee = new EmployeeInfoBean();
		employee.setEmployeeName(employeeBean.getEmployeeName());
		employee.setEmail(employeeBean.getEmail());
		employee.setPassword(employeeBean.getPassword());
		employee.setPhoneNo(employeeBean.getPhoneNo());
		employee.setHotelId(employeeBean.getHotelId());
		employee.setHotelName(employeeBean.getHotelName());
		employee.setEmployeeType("employee");
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();

		entityManager.close();
		return employee;
	}

	@Override
	public List<HotelInfoBean> searchHotel(String location) {

		List<HotelInfoBean> hotelList = null;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		String jpql = "select h from HotelInfoBean h where h.location like :location ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("location", "%"+location+"%");
		try {
			hotelList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelCustomException("Something went wrong...location cannot be find");
		}
		return hotelList;
	}
}
