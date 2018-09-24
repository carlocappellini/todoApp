import { Component, OnInit } from '@angular/core';
import { Todo } from './todo';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'todo-list',
  templateUrl: './todo-list.component.html'
})

export class TodoListComponent implements OnInit {
  todos: Todo[];
  newTodo: Todo = new Todo();
  editing: boolean = false;
  editingTodo: Todo = new Todo();

  ngOnInit(): void {
    this.getTodos();
  }

  getTodos(): void {

  }

  createTodo(todoForm: NgForm): void {

  }

  deleteTodo(id: string): void {

  }

  updateTodo(todoData: Todo): void {

  }

  toggleCompleted(todoData: Todo): void {

  }

  editTodo(todoData: Todo): void {

  }

  clearEditing(): void {

  }
}
