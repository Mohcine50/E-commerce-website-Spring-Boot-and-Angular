import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ClientComponent } from './client/client.component';
import { FaqComponent } from './faq/faq.component';
import { ShopComponent } from './shop/shop.component';
import { BlogComponent } from './blog/blog.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CartComponent } from './cart/cart.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { AccountComponent } from './account/account.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { AuthGuard } from './guards/auth.guard';
import { AdminGuard } from './guards/admin.guard';
import { isSignedInGuard } from './guards/is-signed-in.guard';

const routes: Routes = [
    {
        path: '',
        component: ClientComponent,
        children: [
            { path: '', component: HomeComponent },
            { path: 'blog', component: BlogComponent },
            { path: 'shop', component: ShopComponent },
            { path: 'faq', component: FaqComponent },
            { path: 'cart', component: CartComponent },
            {
                path: 'login',
                component: LoginComponent,
                canActivate: [isSignedInGuard],
            },
            {
                path: 'account',
                component: AccountComponent,
                canActivate: [AuthGuard],
            },

            {
                path: 'register',
                component: RegisterComponent,
                canActivate: [isSignedInGuard],
            },
            { path: 'product/:id', component: ProductPageComponent },
            {
                path: 'checkout/:id',
                component: CheckoutComponent,
                canActivate: [AuthGuard],
            },
            { path: '404', component: NotFoundComponent },
        ],
    },
    { path: 'admin', component: AdminComponent, canActivate: [AdminGuard] },
    { path: '**', redirectTo: '404' },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
