import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-haheader',
  imports: [RouterLink],
  templateUrl: './haheader.component.html',
  styleUrl: './haheader.component.css'
})
export class HAHeaderComponent {
  currentTheme: string = 'light';

  toggleTheme() {
    this.currentTheme = this.currentTheme === 'light' ? 'dark' : 'light';
    document.documentElement.setAttribute('data-theme', this.currentTheme);
  }
}
