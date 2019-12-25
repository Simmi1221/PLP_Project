import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { ServiceComponent } from './service/service.component';
import { HotellistComponent } from './hotellist/hotellist.component';
import { RoomlistComponent } from './roomlist/roomlist.component';
import { BookingstatusComponent } from './bookingstatus/bookingstatus.component';
import { GuestlistComponent } from './guestlist/guestlist.component';
import { AuthGuard } from './auth.guard';
import { RegisterComponent } from './register/register.component';

import { AddroomComponent } from './addroom/addroom.component';


const routes: Routes = [
  { path: '', component: HomeComponent, },
  { path: 'aboutus', component: AboutusComponent },
  { path: 'loginadmin', component: LoginadminComponent },
  { path: 'service', component: ServiceComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'hotellist', component: HotellistComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'addroom', component: AddroomComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'roomlist', component: RoomlistComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  { path: 'bookingstatus', component: BookingstatusComponent },
  {
    path: 'guestlist', component: GuestlistComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },


  { path: '**', component: PagenotfoundComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
