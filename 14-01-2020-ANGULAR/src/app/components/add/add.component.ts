import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { DataService } from 'src/app/providers/data.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  private dataService: DataService;
  private profileForm: FormGroup;

  constructor(dataService: DataService) {
    this.dataService = dataService;

    this.profileForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z_]+$')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      website: new FormControl(''),
    });
  }

  ngOnInit() {
  }

  saveUser = () => {
    if (this.profileForm.status === "VALID") {
      this.dataService.addUser({
        username: this.profileForm.value.username,
        email: this.profileForm.value.email,
        website: this.profileForm.value.website,
      });

      this.profileForm.reset();
    } else {
      window.alert("Please enter proper data.")
    }
  };
}
