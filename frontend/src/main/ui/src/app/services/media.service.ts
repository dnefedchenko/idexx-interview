import {HttpClient, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class MediaService {
  constructor(private httpClient: HttpClient) {}

  public getMedia(term: string): Promise<Array<VolumeItem>> {
    let params = new HttpParams();
    if (term) {
      params = params.append('term', term);
    }
    return this.httpClient
      .get<Array<VolumeItem>>('/api/books', {params: params})
      .toPromise();
  }
}

export interface VolumeItem {
  id: string;
  volumeInfo: VolumeInfo;
}

export interface VolumeInfo {
  title: string;
  authors: Array<string>;
}
