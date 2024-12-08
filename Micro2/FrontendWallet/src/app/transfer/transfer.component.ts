import { Component, OnInit } from '@angular/core';
import { TransfertServiceService } from '../../app/TransfertService/transfert-service.service';

interface Transfert {
  id?: number;
  createdAt: Date;
  walletSourceId: string;
  walletDestinationId: string;
  montant: number;
  etat: string;
}

@Component({
  selector: 'app-transfers',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  transfers: Transfert[] = [];

  // Initialisation de l'objet newTransfer
  newTransfer: Transfert = {
    createdAt: new Date(),
    walletSourceId: '',
    walletDestinationId: '',
    montant: 0,
    etat: 'PENDING'
  };

  constructor(private transferService: TransfertServiceService) { }

  ngOnInit(): void {
    this.loadTransfers();
  }

  loadTransfers(): void {
    this.transferService.getAll().subscribe(data => this.transfers = data);
  }

  // Méthode pour sauvegarder un transfert
  saveTransfer(): void {
    this.transferService.save(this.newTransfer).subscribe(() => {
      this.loadTransfers();
      // Réinitialisation du formulaire après l'ajout
      this.newTransfer = {
        createdAt: new Date(),
        walletSourceId: '',
        walletDestinationId: '',
        montant: 0,
        etat: 'PENDING'
      };
    });
  }

  // Méthode pour mettre à jour un transfert
  updateTransfer(transfer: Transfert): void {
    if (transfer.id) {
      this.transferService.update(transfer.id, transfer).subscribe(() => this.loadTransfers());
    }
  }

  // Méthode pour supprimer un transfert
  deleteTransfer(id: number): void {
    this.transferService.delete(id).subscribe(() => this.loadTransfers());
  }
}
