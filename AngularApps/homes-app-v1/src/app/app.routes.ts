import { Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { DetailsComponent } from './pages/details/details.component';

export const routes: Routes = [
    {
        path: '',
        component: HomePageComponent,
        title:'Home Page'
    },
    {
        path: 'details/:id',
        component: DetailsComponent,
        title: 'Details Page'
    }
];
