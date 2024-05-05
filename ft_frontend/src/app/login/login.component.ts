import { UserService } from './../user.service';
import { CommonModule } from '@angular/common';
import { Component, ElementRef, QueryList, Renderer2, ViewChild, ViewChildren, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { User } from '../userInfo';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule, HttpClientModule],
  template: `

    <section class="Login-class">
    <div>
      <div class="login">
      <div class="box" #box></div>
     


      

  <form  class= "input-class" [formGroup] = "applyForm" (submit)="submitApplication()">
  <img src="assets/logo.png">

    <div class="inputBox">
      <input id="username" type="text" formControlName="username" required>
      <span for="username">username</span>
    </div>
    <div class="inputBox">

      <input id="password" type="password" formControlName="password" required>
      <span for="password">password</span>
    </div>
    <h3><a href="#" style="text-decoration: none; color: black">Lost password ? </a></h3>
    <div class="inputBox">
      <button type="submit" class="primary">Login</button>
  </div>
  </form>
</div></div>
  <div>About <a href="#" style="text-decoration: none; color: white;font-size: 30px">Analeetics</a></div>
    </section>
  `,
  styleUrl: './login.component.css'
})
export class LoginComponent {
  // @ViewChildren('box') boxes: QueryList<ElementRef> | undefined; 
   userService: UserService = inject(UserService);
  constructor() {}

  // ngAfterViewInit() {
  //   if(this.boxes)
  //   this.boxes.forEach(box => {
  //     this.addMouseMoveListener(box.nativeElement);
  //   });
  // }
  applyForm = new FormGroup(
    {
      username: new FormControl(''),
      password: new FormControl('')
    }
  );
  // addMouseMoveListener(element: HTMLElement) {
  //   element.addEventListener('mousemove', (e) => {
  //     let x = e.pageX - element.offsetLeft;
  //     let y = e.pageY - element.offsetTop;
  //     element.style.setProperty('--x', x + 'px');
  //     element.style.setProperty('--y', y + 'px');
  //   });
  // }
  submitApplication(){
    this.userService.submitLogin(
      this.applyForm.value.username ?? '',
      this.applyForm.value.password ?? ''
    );
  }
}


