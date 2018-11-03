import {Component, OnInit} from '@angular/core';
import {MediaService} from "./services/media.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private mediaService: MediaService) {

  }

  ngOnInit(): void {
    this.mediaService
      .getMedia('queryTerm')
      .then(books => {
        let response = books;
        console.log(response);
      });
  }
}
