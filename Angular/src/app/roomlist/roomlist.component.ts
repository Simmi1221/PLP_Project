import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { RoomList } from '../room';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-roomlist',
  templateUrl: './roomlist.component.html',
  styleUrls: ['./roomlist.component.css']
})
export class RoomlistComponent implements OnInit {
  roomArray: [];
  delete: any;
  update: any;
 selectedRoom: RoomList = {
  hotelId: null,
  roomId: null,
  roomCapacity: null,
  roomRent: null,
  roomStatus: null,
  roomType: null

};
  constructor( private hotelService: HotelService ) {
    this.getRoomList();
   }

getRoomList() {
  this.hotelService.getRoom().subscribe((data) => {
    console.log(data.roomList);
    this.roomArray = data.roomList;
  });
}


selectRoom(roomList: RoomList) {
  this.selectedRoom = roomList;
}

deleteRoom(roomList: RoomList) {
  this.hotelService.deleteRoom(roomList).subscribe(response => {
    console.log(response);
    this.delete = response;
    console.log('delete hotel name');
    this.getRoomList();
  },
    err => {
      console.log(err);
    });
}


updateForm(form: NgForm) {
  this.hotelService.putRoom(form.value).subscribe(response => {
    console.log(response);
    this.update = response;
    form.reset();
  }, err => {
    console.log(err);
  });

}

  ngOnInit() {
  }

}
