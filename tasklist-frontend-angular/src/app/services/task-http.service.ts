import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class TaskHttpService {

  readonly backendUrl = "http://192.168.1.20:8080";

  constructor (private httpClient: HttpClient) {

  }

  public getTask () {
    return this.httpClient.get(this.backendUrl + "/task/all");
  }
}
