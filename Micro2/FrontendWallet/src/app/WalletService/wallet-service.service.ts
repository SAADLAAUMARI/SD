import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class WalletServiceService {
  private apiUrl = 'http://localhost:8888/WALLET-SERVICE/wallets'; // Changez selon votre URL backend

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}`);
  }

  save(wallet: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}`, wallet);
  }

  update(id: number, wallet: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, wallet);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
