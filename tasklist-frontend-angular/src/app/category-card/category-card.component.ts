import { Component, OnInit } from '@angular/core';
import {Category} from "../entities/Category";

@Component({
  selector: 'app-category-card',
  templateUrl: './category-card.component.html',
  styleUrls: ['./category-card.component.css']
})
export class CategoryCardComponent implements OnInit {

  category: Category = {title: "New category", id: 354}

  constructor() { }

  ngOnInit(): void {
  }

}
