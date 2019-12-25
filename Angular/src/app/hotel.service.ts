import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HotelList } from './hotelList';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  hotels: HotelList[] = [];
  api = 'http://localhost:8080/';


  constructor(private http: HttpClient) { }

  postHotel(data) {
    return this.http.post(`${this.api}addHotelDetails`, data);

  }
  postRoom(data) {
    return this.http.post(`${this.api}addRoomDetails`, data);

  }
  putHotel(data) {
    return this.http.put(`${this.api}updateHotelDetails`, data);

  }

  getHotel() {
    return this.http.get<any>(`${this.api}getHotelDetails`);
  }
  getRoom() {
    return this.http.get<any>(`${this.api}getRoomDetails`);
  }
  getGuestList() {
    return this.http.get<any>(`${this.api}getHotelDetails`);
  }


  deleteHotel(data) {
    return this.http.delete(`${this.api}deleteHotelDetails/${data.hotelId}`);
  }

  deleteRoom(data) {
    return this.http.delete(`${this.api}deleteRoomDetails/${data.roomId}`);
  }
  putRoom(data) {
    return this.http.put(`${this.api}updateRoomDetails`, data);

  }

}
