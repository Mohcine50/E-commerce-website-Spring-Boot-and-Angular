import { AuthService } from './../services/auth.service';
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [CommonModule, RouterLink, HttpClientModule, ReactiveFormsModule],
    templateUrl: './login.component.html',
})
export class LoginComponent {
    constructor(private authService: AuthService, private router: Router) {}

    loginForm = new FormGroup({
        username: new FormControl(''),
        password: new FormControl(''),
    });

    login(event: Event) {
        event.preventDefault();
        this.authService
            .login(
                this.loginForm.controls['username'].value as string,
                this.loginForm.controls['password'].value as string
            )
            .subscribe({
                next: (response) => {
                    if (
                        response.accessToken !== undefined ||
                        response.accessToken !== null
                    ) {
                        localStorage.setItem(
                            'accessToken',
                            response.accessToken
                        );
                        this.authService.setAuthentication(true);
                        this.router.navigate(['/']);
                    }
                },
            });
    }
}
