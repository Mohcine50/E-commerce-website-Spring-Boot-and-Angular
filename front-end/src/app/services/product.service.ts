import { Injectable } from '@angular/core';
import { Product } from '../types';

@Injectable({
    providedIn: 'root',
})
export class ProductService {
    products: Product[] = [
        {
            id: '0',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '1',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '2',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '3',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '4',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '5',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '5',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '6',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
        {
            id: '7',
            title: 'Razer v3 Electornic',
            imageUrl: '../../assets/images/product.jpg',
            price: '39.99 $',
            brand: 'unbranded',
        },
    ];
    constructor() {}

    getAllProducts() {
        return this.products;
    }
    getProductById(id: string) {
        return this.products.find((product) => product.id === id);
    }
}
