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
  logout(){
    localStorage.removeItem('username');
    window.location.reload();
  }
  setUsername(username){
    localStorage.setItem('username', username);
    this.username = username.trim();
    window.location.reload();
    if (username === ""){this.logout();}
    return this.username;
    
   }
}
