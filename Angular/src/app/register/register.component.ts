import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  valid: any;

  constructor(private auth: AuthService, private router: Router) { }

  register(registerForm: NgForm) {
    console.log(registerForm.value);
    this.auth.register(registerForm.value).subscribe(response => {
      this.valid = response.description;
      console.log(response);
      registerForm.reset();
      if (response.statusCode === 222) {
        this.router.navigateByUrl('/');
      }
    }, err => {
      console.log(err);

      registerForm.reset();
    });
  }

  ngOnInit() {
  }

}
