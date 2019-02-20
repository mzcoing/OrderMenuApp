import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor() { }
  // public username: string;
  ngOnInit() {
    localStorage.getItem('username');
  }
  username = localStorage.getItem('username');
  logout(){
    localStorage.setItem('username', "");
    window.location.reload();
  }
  setUsername(username){
    localStorage.setItem('username', username);
    this.username = username.trim();
    if (username === ""){this.logout();}
    window.location.reload();
    return this.username;
    
   }
}
