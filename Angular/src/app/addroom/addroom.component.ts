import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-addroom',
  templateUrl: './addroom.component.html',
  styleUrls: ['./addroom.component.css']
})
export class AddroomComponent implements OnInit {


  notValid: any;

  constructor(private hotelService: HotelService) { }

 submit(addForm: NgForm) {
    console.log(addForm.value);
    this.hotelService.postRoom(addForm.value).subscribe(response => {
    this.notValid = response;
    console.log('post method');
    console.log(response);
    console.log('post method');
    addForm.reset();
    },
      err => {
        console.log(err);
      }

    );
  }

  ngOnInit() {
  }

}
