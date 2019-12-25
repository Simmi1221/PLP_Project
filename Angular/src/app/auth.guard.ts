import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {


    constructor(private auth: AuthService) { }

    canActivate(route: ActivatedRouteSnapshot): boolean {
        const expectedRoleArray = route.data.expectedRole;
        const details = JSON.parse(localStorage.getItem('value'));

        let role: string = null;
        for (const index in expectedRoleArray) {
            if (details && details.type === expectedRoleArray[index]) {
                role = expectedRoleArray[index];
            }
        }
        if (details && details.type === role) {
            console.log('loggedIn');
            return true;
        } else {
            console.log(' not loggedIn');
            return false;
        }
    }
}
