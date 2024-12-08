import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Transfert {
  id?: number;
  createdAt: Date;
  walletSourceId: string;
  walletDestinationId: string;
  montant: number;
  etat: string;
}

@Injectable({
  providedIn: 'root'
})
export class TransfertServiceService {
  private apiUrl = 'http://localhost:8080/transfers'; // Changez selon votre URL backend

  constructor(private http: HttpClient) { }

  getAll(): Observable<Transfert[]> {
    return this.http.get<Transfert[]>(`${this.apiUrl}`);
  }

  save(transfert: Transfert): Observable<Transfert> {
    return this.http.post<Transfert>(`${this.apiUrl}`, transfert);
  }

  update(id: number, transfert: Transfert): Observable<Transfert> {
    return this.http.put<Transfert>(`${this.apiUrl}/${id}`, transfert);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
