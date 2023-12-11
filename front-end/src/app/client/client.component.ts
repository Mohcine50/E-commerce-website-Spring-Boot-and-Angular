import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { Router, RouterOutlet } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
@Component({
    selector: 'app-client',
    standalone: true,
    templateUrl: './client.component.html',
    imports: [
        NavbarComponent,
        FontAwesomeModule,
        NavbarComponent,
        RouterOutlet,
        FooterComponent,
    ],
})
export class ClientComponent {
    faCoffee = faCoffee;
    constructor(private router: Router) {}
}
