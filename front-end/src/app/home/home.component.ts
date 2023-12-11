import { Component, ElementRef, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../hero/hero.component';
import { ProductComponent } from '../product/product.component';
import { Product } from '../types';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ProductService } from '../services/product.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
    selector: 'app-home',
    standalone: true,
    imports: [
        CommonModule,
        HeroComponent,
        ProductComponent,
        FontAwesomeModule,
        HttpClientModule,
    ],
    templateUrl: './home.component.html',
})
export class HomeComponent {
    faMagnifyingGlass = faMagnifyingGlass;
    products: Product[];
    constructor(private productService: ProductService) {
        this.products = this.productService.getAllProducts();
    }
}
