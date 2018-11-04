import {HttpClient, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class MediaService {
  constructor(private httpClient: HttpClient) {}

  public getBooks(term: string): Promise<Array<VolumeItem>> {
    let params = new HttpParams();
    if (term) {
      params = params.append('term', term);
    }
    return this.httpClient
      .get<Array<VolumeItem>>('/api/books', {params: params})
      .toPromise();
  }

  public getAlbums(term: string, countryCode?: string): Promise<AlbumTrack[]> {
    let params = new HttpParams();
    if (term) {
      params = params.append('term', term);
    }
    if (countryCode) {
      params = params.append('country', countryCode);
    }
    return this.httpClient
      .get<AlbumTrack[]>('/api/albums', {params: params})
      .toPromise();
  }
}

export interface VolumeItem {
  id: string;
  volumeInfo: VolumeInfo;
  type: string;
}

export interface VolumeInfo {
  title: string;
  authors: Array<string>;
}

export interface AlbumTrack {
  trackName: string;
  artistName: string;
  type: string;
}

export interface Item {
  title: string;
  author: string;
  type: string;
}
