import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor() { }
  public username: string;
  ngOnInit() {
  }
  setUsername(username){
    localStorage.setItem('username', username);
    this.username = username;
    return this.username;
    
   }
}
