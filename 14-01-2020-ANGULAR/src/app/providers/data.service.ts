import { Injectable } from '@angular/core';

interface User {
  username: string;
  email: string;
  website?: string;
}

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private users: User[];

  constructor() {
    this.users = [];
  }

  addUser = (user: User): number => {
    this.users.push(user);
    return this.users.length - 1;
  };

  removeUser = (username: string): User => {
    const userIndex = this.users.findIndex(u => u.username === username);
    const user: User = this.users[userIndex];

    this.users.splice(this.users.findIndex(u => u.username === username), 1);

    return user;
  };

  viewUsers = (): User[] => {
    return this.users;
  };
}
