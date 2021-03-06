import { Component } from '@angular/core';
import {CategoryHttpService} from "./services/category-http.service";
import {TaskHttpService} from "./services/task-http.service";
import {Task} from "./entities/Task";
import {Map} from "typescript"
import {CategoryCardType} from "./entities/CategoryCardType";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  categories: CategoryCardType[] = [];

  private categoriesMap: Map<CategoryCardType> = new Map();

  constructor(private categoryHttp: CategoryHttpService, private taskHttp: TaskHttpService) {
    const uncategorized: CategoryCardType = {
      id: -1,
      title: "Uncategorized",
      tasks: []
    };

    this.taskHttp.getTask().subscribe((tasksResponse: Task[]) => {

      tasksResponse.forEach((task: Task) => {
        if(!task.category) {
          uncategorized.tasks.push(task);
          return;
        }

        const categoryId: string = String(task.category.id);

        //get all tasks and add them to the array
        if (this.categoriesMap.has(categoryId)) {
          // @ts-ignore
          this.categoriesMap.get(categoryId).tasks.push(task);
          return;
        }

        this.categoriesMap.set(categoryId, {...task.category, tasks: [task]});
      });

      this.categoriesMap.set(String(uncategorized.id), uncategorized);
      // @ts-ignore
      this.categories = Array.from(this.categoriesMap.values());
    })
  }
}
