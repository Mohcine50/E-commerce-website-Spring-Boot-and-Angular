import { Product } from './../types';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class CartService {
    numberOfProdsOnCart!: number;
    productsCart: { product: Product; qte: number }[] = [];

    constructor() {}

    addProductToCart(product: Product, qte: number) {
        if (
            !this.productsCart.find(
                (_product) => _product.product.id === product.id
            )
        ) {
            this.numberOfProdsOnCart++;
            localStorage.setItem(
                'numsOfProducts',
                this.numberOfProdsOnCart.toString()
            );

            this.productsCart.push({ product, qte });
            let products = localStorage.getItem('products');
            if (products !== null) {
                let productsJson = JSON.parse(products);
                productsJson['products'].push(product);
                localStorage.setItem(
                    'products',
                    JSON.stringify({ products: this.productsCart })
                );
            } else {
                localStorage.setItem(
                    'products',
                    JSON.stringify({ products: this.productsCart })
                );
            }
            localStorage.setItem(
                'numsOfProducts',
                this.numberOfProdsOnCart.toString()
            );
        } else {
            console.log('Product Already in Your Cart');
        }
    }

    deleteProductFromCart(product: Product) {
        const indexToRemove = this.productsCart.findIndex(
            (prodItem) => prodItem.product.id === product.id
        );

        if (indexToRemove !== -1) {
            this.productsCart.splice(indexToRemove, 1);
            this.numberOfProdsOnCart--;
            localStorage.setItem(
                'products',
                JSON.stringify({ products: this.productsCart })
            );
            localStorage.setItem(
                'numsOfProducts',
                this.numberOfProdsOnCart.toString()
            );
        }
    }
}
