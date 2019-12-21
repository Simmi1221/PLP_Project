package com.example.hotelmanagementsystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class RoomInfoBean {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
	@Column
	private double roomRent;
	@Column
	private String roomType;
	@Column
	private int roomCapacity;
	@Column
	private String roomStatus;
	@Column
	private int hotelId;
	
	//Gtters and Setters
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public double getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(double roomRent) {
		this.roomRent = roomRent;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
}
