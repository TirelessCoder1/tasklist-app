import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {CategoryCardComponent} from './category-card/category-card.component';
import {MatCardModule} from '@angular/material/card';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {CategoryHttpService} from "./services/category-http.service";
import {TaskHttpService} from "./services/task-http.service";

@NgModule({
  declarations: [
    AppComponent,
    CategoryCardComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatCardModule,
    MatCheckboxModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    CategoryHttpService,
    TaskHttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
