import {Component, OnInit} from '@angular/core';
import {AlbumTrack, Item, MediaService, VolumeItem} from "./services/media.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  items: Item[];

  mediaForm: FormGroup;
  pageLoadingCompleted: boolean =  false;

  constructor(private mediaService: MediaService, private formBuilder: FormBuilder) {
    this.items = [];
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

    Promise
      .all([this.getBooks(searchTerm), this.getAlbums(searchTerm)])
      .then(values => {
        const books = values[0];
        const albums = values[1];
        this.items = this.booksToItems(books);
        this.items = this.items.concat(this.albumsToItems(albums));
        this.items.sort((a, b) => {return a.title.localeCompare(b.title)});
        this.pageLoadingCompleted = true;
      },
        error => {
          console.log(error);
          this.pageLoadingCompleted = false;
        });
  }

  private getBooks(searchTerm: string): Promise<VolumeItem[]> {
    return this.mediaService.getBooks(searchTerm);
  }

  private getAlbums(searchTerm: string): Promise<AlbumTrack[]> {
    return this.mediaService.getAlbums(searchTerm);
  }

  private booksToItems(books: VolumeItem[]): Item[] {
    return books
      .map(book => this.toItem(book.volumeInfo.title, book.volumeInfo.authors, book.type));
  }

  private albumsToItems(albums: AlbumTrack[]): Item[] {
    return albums
      .map(album => this.toItem(album.trackName, album.artistName, album.type));
  }

  private toItem(title: string, author: any, type: string): Item {
    return {
      'title': title,
      'author': author,
      'type': type
    };
  }
}
