import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
    selector: 'app-checkout',
    standalone: true,
    imports: [CommonModule, RouterLink, ReactiveFormsModule],
    templateUrl: './checkout.component.html',
})
export class CheckoutComponent {
    isAuthenticated?: boolean;
    constructor(private authService: AuthService) {
        this.authService
            .isAuthenticated()
            .subscribe((auth) => (this.isAuthenticated = auth));
    }
}
