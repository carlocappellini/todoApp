import {Injectable} from '@angular/core';

import {Todo} from "./todo";

import {Headers, Http} from "@angular/http";

import 'rxjs/add/operator/topromise';


@Injectable()

export class TodoService {
  private baseUrl = 'http://localhost:8080';


  constructor(private http: Http) {
  }

  getTodos(): Promise<Todo[]> {

    return this.http.get(this.baseUrl + ' /api/todos/')

      .toPromise()
      .then(response => response.json() as Todo[])
      .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {

    console.error("Some error occurred", error);

    return Promise.reject(error.message || error);


  }


  createTodo(todoData: Todo): Promise<Todo> {

    return this.http.post(this.baseUrl + '/api/todos/', todoData)
      .toPromise().then(response => response.json() as Todo)
      .catch(this.handleError);

  }


  update(todoData: Todo): Promise<Todo> {
    return this.http.put(this.baseUrl + "/api/todos/", todoData)
      .toPromise().then(response => response.json() as Todo)
      .catch(this.handleError);
  }

  deleteTodo(id: string): Promise<Todo> {

    return this.http.delete(this.baseUrl + "/api/todos/" + id)
      .toPromise()
      .catch(this.handleError);


  }


}
