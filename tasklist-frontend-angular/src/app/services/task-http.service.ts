import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../entities/Task";

@Injectable()
export class TaskHttpService {

  readonly backendUrl = "http://192.168.1.20:8080";

  constructor (private httpClient: HttpClient) {

  }

  public getTask (): Observable<Task[]> {
    return this.httpClient.get<Task[]>(this.backendUrl + "/task/all");
  }
}
