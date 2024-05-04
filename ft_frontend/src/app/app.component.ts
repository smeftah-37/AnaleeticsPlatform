import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';

@Component({
  selector: 'app-root',
  standalone: true,

  imports: [RouterOutlet,LoginComponent,RouterModule,],
  template:  `<main>   <section class="content">
      <router-outlet></router-outlet>
    </section>
  </main>`,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'login';
}
