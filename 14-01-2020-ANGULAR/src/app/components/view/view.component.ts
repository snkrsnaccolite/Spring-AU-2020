import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/providers/data.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  dataService: DataService;
  users: any[];

  constructor(dataService: DataService) {
    this.dataService = dataService;
  }

  ngOnInit() {
    this.users = this.dataService.viewUsers();
  }

}
