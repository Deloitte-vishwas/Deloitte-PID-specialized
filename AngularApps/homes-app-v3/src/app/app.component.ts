import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HAFooterComponent } from './components/hafooter/hafooter.component';
import { HAHeaderComponent } from './components/haheader/haheader.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HAFooterComponent, HAHeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'homes-app';
}
