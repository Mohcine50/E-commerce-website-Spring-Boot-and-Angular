import { Injectable } from '@angular/core';
import { AuthService } from './../services/auth.service';
import { CanActivate, Router, UrlTree } from '@angular/router';

@Injectable({
    providedIn: 'root',
})
export class AuthGuard implements CanActivate {
    isAuthenticated: null | boolean = null;
    constructor(private authService: AuthService, private router: Router) {
        this.authService.isAuthenticated().subscribe({
            next: (auth) => {
                this.isAuthenticated = auth;
            },
        });
    }

    canActivate(): boolean | UrlTree {
        if (this.isAuthenticated) {
            return true;
        } else {
            return this.router.createUrlTree(['/login']);
        }
    }
}
