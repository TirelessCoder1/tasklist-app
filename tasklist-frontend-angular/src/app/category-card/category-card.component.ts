import {Component, Input, OnInit} from '@angular/core';
import {Category} from "../entities/Category";
import {CategoryCardType} from "../entities/CategoryCardType";

@Component({
  selector: 'app-category-card',
  templateUrl: './category-card.component.html',
  styleUrls: ['./category-card.component.css']
})

export class CategoryCardComponent implements OnInit {

  constructor() {}

  @Input()
  category: CategoryCardType | undefined;

  ngOnInit(): void {
  }

}
