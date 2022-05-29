import { Component } from '@angular/core';
import {CategoryHttpService} from "./services/category-http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private categoryHttp: CategoryHttpService) {
    this.categoryHttp.getCategories().subscribe((some) => {
      console.log(some)
    })
  }
}
