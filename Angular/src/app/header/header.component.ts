import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public auth: AuthService, private router: Router) { }

  isAdmin() {
    const userDetails = JSON.parse(localStorage.getItem('value'));
    if (userDetails && userDetails.userType === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  isUser() {
    const userDetails = JSON.parse(localStorage.getItem('value'));
    if (userDetails && userDetails.userType === 'user') {
      return true;
    } else {
      return false;
    }
  }


  logout() {
    localStorage.removeItem('value');
    this.router.navigateByUrl('/');
  }

  ngOnInit() {
  }

}
