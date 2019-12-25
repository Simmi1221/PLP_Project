import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ServiceComponent } from './service/service.component';
import { HotellistComponent } from './hotellist/hotellist.component';
import { RoomlistComponent } from './roomlist/roomlist.component';
import { BookingstatusComponent } from './bookingstatus/bookingstatus.component';
import { GuestlistComponent } from './guestlist/guestlist.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { AddroomComponent } from './addroom/addroom.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AboutusComponent,
    LoginadminComponent,
    PagenotfoundComponent,
    ServiceComponent,
    HotellistComponent,
    RoomlistComponent,
    BookingstatusComponent,
    GuestlistComponent,
    RegisterComponent,
    AddroomComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
