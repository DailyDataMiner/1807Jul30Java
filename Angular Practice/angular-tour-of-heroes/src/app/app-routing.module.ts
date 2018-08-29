import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/compiler/src/core';
import { HeroesComponent } from './heroes/heroes.component';


@NgModule({
  imports: [
    CommonModule
  ],
  declarations: []
})
export class AppRoutingModule {}

const routes: Routes = [
  { path: 'heroes', component: HeroesComponent}
]
