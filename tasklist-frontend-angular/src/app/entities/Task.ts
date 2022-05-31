import {Category} from "./Category";

export interface Task {
  id: number;
  title: string;
  completed: boolean;
  date: Date;
  category: Category;
}
