import { JwtService } from './../services/jwt.service';
import { Component, Input } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {
    faCartPlus,
    faMagnifyingGlass,
    faRightFromBracket,
    faUser,
} from '@fortawesome/free-solid-svg-icons';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { CartService } from '../services/cart.service';

@Component({
    selector: 'app-navbar',
    standalone: true,
    imports: [CommonModule, FontAwesomeModule, ReactiveFormsModule, RouterLink],
    templateUrl: './navbar.component.html',
})
export class NavbarComponent {
    faMagnifyingGlass = faMagnifyingGlass;
    faUser = faUser;
    faCart = faCartPlus;
    faRightFromBracket = faRightFromBracket;

    selectedPage: string = '';
    isAuthenticated?: boolean;
    @Input()
    numsOfProdsOfCart: number = 0;

    constructor(
        private router: Router,
        public authService: AuthService,
        public cartService: CartService,
        private jwtService: JwtService
    ) {
        this.authService.isAuthenticated().subscribe({
            next: (auth) => {
                this.isAuthenticated = auth;
            },
        });
    }

    ngOnInit() {
        let accessToken = localStorage.getItem('accessToken');
        if (accessToken && accessToken !== null) {
            let decodedJWT = this.jwtService.decodeToken(accessToken);
            let tokenExpired = this.jwtService.isTokenExpired(decodedJWT);
            if (!tokenExpired) this.authService.setAuthentication(true);
            if (decodedJWT.exp < decodedJWT.iat)
                this.authService.setAuthentication(false);
        }

        this.router.events.subscribe((event) => {
            this.selectedPage = this.router.url.substring(1);
        });
        this.cartService.numberOfProdsOnCart =
            Number(localStorage.getItem('numsOfProducts')) | 0;
        let products = localStorage.getItem('products');
        if (products !== null) {
            let productsJson = JSON.parse(products);
            this.cartService.productsCart = productsJson['products'];
        }
    }

    searchForm: FormGroup = new FormGroup({
        searchQuery: new FormControl(''),
    });

    handleSubmit = (): void => {
        const searchQuery = this.searchForm.controls['searchQuery'].value;
        const paramsUrl = `/shop?search=${searchQuery}`;
        this.router.navigate([paramsUrl], {
            queryParams: { search: searchQuery },
        });
        this.searchForm.controls['searchQuery'].setValue('');
    };

    logout = (): void => {
        this.authService.setAuthentication(false);
        localStorage.removeItem('accessToken');
        this.router.navigate(['login']);
    };
}
