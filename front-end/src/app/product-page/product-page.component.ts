import { Product } from './../types';
import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { ProductComponent } from '../product/product.component';
import { ProductService } from '../services/product.service';

@Component({
    selector: 'app-product-page',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './product-page.component.html',
})
export class ProductPageComponent {
    productId: string = '';
    @Input()
    prdCartQuantity: number = 1;

    product?: Product;

    constructor(
        private router: ActivatedRoute,
        private cartService: CartService,
        private productService: ProductService
    ) {}

    ngOnInit() {
        this.productId = this.router.snapshot.params['id'];
        this.product = this.productService.getProductById(this.productId);
    }

    handlePlusProdCartQua() {
        this.prdCartQuantity++;
    }
    handleMinusProdCartQua() {
        if (this.prdCartQuantity > 1) {
            this.prdCartQuantity--;
        }
    }

    handleAddTocart() {
        this.cartService.addProductToCart(
            this.product as Product,
            this.prdCartQuantity
        );
    }
}
