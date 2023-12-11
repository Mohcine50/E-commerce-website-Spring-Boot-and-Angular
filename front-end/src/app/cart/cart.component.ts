import { CartService } from './../services/cart.service';
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {
    faCartPlus,
    faCartShopping,
    faDeleteLeft,
    faXmark,
} from '@fortawesome/free-solid-svg-icons';
import { Product } from '../types';

@Component({
    selector: 'app-cart',
    standalone: true,
    imports: [CommonModule, FontAwesomeModule],
    templateUrl: './cart.component.html',
})
export class CartComponent {
    cartIcon = faCartPlus;
    deleteIcon = faXmark;
    total: number = 0;
    productsCart: { product: Product; qte: number }[] = [];

    constructor(private cartService: CartService) {}

    ngOnInit() {
        this.productsCart = this.cartService.productsCart;
        const totalPrice = this.productsCart.reduce((sum, product) => {
            const priceWithoutDollar =
                parseFloat(product.product.price.replace('$', '')) *
                product.qte;
            return sum + priceWithoutDollar;
        }, 0);
        this.total = Number(totalPrice.toFixed(2));
    }

    deleteProductFromCart(product: Product) {
        this.cartService.deleteProductFromCart(product);
    }
}
