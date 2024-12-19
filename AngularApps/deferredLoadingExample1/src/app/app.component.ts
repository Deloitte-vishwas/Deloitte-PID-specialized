import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'deferredLoading';
  user = {
    name: 'John Doe',
    age: 30,
    email: 'john.doe@cloudthat.com'
  }

  isLoading = true;

  constructor(){
    setTimeout(()=>{
      this.isLoading = false;
    }, 5000);
  }
}
