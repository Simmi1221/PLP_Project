package com.example.hotelmanagementsystem.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.example.hotelmanagementsystem.beans.HotelInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

@Service
public class CustomValidationImpl implements CustomValidation {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean customEmailValidation(String email) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isValid = false;

		String jpql = " from UserBean";
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		List<UserBean> list = null;
		try {
			list = query.getResultList();
			for (UserBean user : list) {
				if (email.equals(user.getEmail())) {
					isValid = true;
					return isValid;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public boolean customLocationValidation(String location) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isValid = false;

		String jpql = " from HotelInfoBean";
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		List<HotelInfoBean> list = null;
		try {
			list = query.getResultList();
			for (HotelInfoBean hotelInfo : list) {
				if (location.equals(hotelInfo.getLocation())) {
					isValid = true;
					return isValid;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public boolean customRoomIdValidation(int roomId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isValid = false;

		String jpql = " from RoomInfoBean";
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		List<RoomInfoBean> list = null;
		try {
			list = query.getResultList();
			for (RoomInfoBean roomInfoBean : list) {
				if (roomId == roomInfoBean.getRoomId()) {
					isValid = true;
					return isValid;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

}
