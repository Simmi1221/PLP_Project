import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { HotelService } from '../hotel.service';
import { HotelList } from '../hotelList';

@Component({
  selector: 'app-hotellist',
  templateUrl: './hotellist.component.html',
  styleUrls: ['./hotellist.component.css']
})
export class HotellistComponent implements OnInit {
  notValid: any;
  delete: any;
  update: any;
  hotelArray: [];

  selectedHotel: HotelList = {
    hotelId: null,
    hotelName: null,
    location: null,
    imageUrl: null
  };

  constructor(private hotelService: HotelService) {
    this.getHotelList();
  }

  getHotelList() {
    this.hotelService.getHotel().subscribe((data) => {
      console.log(data.hotelList);
      this.hotelArray = data.hotelList;
    });
  }

  selectHotel(hotelList: HotelList) {
    this.selectedHotel = hotelList;
  }


  deleteHotel(hotelList: HotelList) {
    this.hotelService.deleteHotel(hotelList).subscribe(response => {
      console.log(response);
      this.delete = response;
      console.log('delete hotel name');
      this.getHotelList();
    },
      err => {
        console.log(err);
      });
  }

  submitForm(addHotel: NgForm) {
    console.log(addHotel.value);
    this.hotelService.postHotel(addHotel.value).subscribe(response => {
      this.notValid = response;
      console.log(response);
      addHotel.reset();

    },
      err => {
        console.log(err);
      }

    );
  }


  updateForm(form: NgForm) {
    this.hotelService.putHotel(form.value).subscribe(response => {
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
