import {Component, OnInit} from '@angular/core';
import {MediaService, VolumeItem} from "./services/media.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  books: VolumeItem[];
  mediaForm: FormGroup;
  pageLoadingCompleted: boolean =  false;

  constructor(private mediaService: MediaService, private formBuilder: FormBuilder) {
    this.books = [];
  }

  ngOnInit(): void {
    this.initMediaForm();
  }

  private initMediaForm() {
    this.mediaForm = this.formBuilder.group({
      searchTerm: ''
    });
  }

  search(): void {
    const searchTerm = this.mediaForm.get('searchTerm').value;
    this.mediaService
      .getMedia(searchTerm)
      .then(books => {
        this.books = books;
        this.pageLoadingCompleted = true;
      }, error => {
        console.log(error);
        this.pageLoadingCompleted = false;
      });
  }
}
