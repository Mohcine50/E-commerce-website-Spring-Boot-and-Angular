import { Inject, Injectable } from '@angular/core';
import { AuthService } from './../services/auth.service';
import { CanActivate, Router } from '@angular/router';

@Injectable({
    providedIn: 'root',
})
export class AdminGuard implements CanActivate {
    constructor(private authService: AuthService, private router: Router) {}

    canActivate() {
        if (this.authService.isAdmin()) {
            return true;
        } else {
            return this.router.createUrlTree(['/404']);
        }
    }
}
