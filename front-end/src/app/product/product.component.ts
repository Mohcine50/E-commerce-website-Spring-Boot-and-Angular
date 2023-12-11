import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product } from '../types';
import { RouterLink } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
    selector: 'app-product',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './product.component.html',
})
export class ProductComponent {
    @Input() product!: Product;

    constructor(private cartService: CartService) {}

    handleAddTocart() {
        this.cartService.addProductToCart(this.product, 1);
    }
}
