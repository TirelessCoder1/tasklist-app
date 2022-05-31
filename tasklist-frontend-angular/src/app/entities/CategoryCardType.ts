import {Category} from "./Category";
import {Task} from "./Task"

export interface CategoryCardType extends Category {
  tasks: Task[];
}
