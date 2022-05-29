import { Component } from '@angular/core';
import {CategoryHttpService} from "./services/category-http.service";
import {Category} from "./entities/Category";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  categories: Category[] = [];
  constructor(private categoryHttp: CategoryHttpService) {
    this.categoryHttp.getCategories().subscribe((some:any) => {
      this.categories = some;
      console.log(this.categories);
    })
  }
}
