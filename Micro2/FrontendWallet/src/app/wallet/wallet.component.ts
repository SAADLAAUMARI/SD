import { Component, OnInit } from '@angular/core';
import { WalletServiceService } from '../../app/WalletService/wallet-service.service';

interface Wallet {
  id?: number;
  name: string;
  balance: number;
}

@Component({
  selector: 'app-wallets',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {
  wallets: Wallet[] = [];
  newWallet: Wallet = { name: '', balance: 0 };

  constructor(private walletService: WalletServiceService) { }

  ngOnInit(): void {
    this.loadWallets();
  }

  loadWallets(): void {
    this.walletService.getAll().subscribe(data => this.wallets = data);
  }

  saveWallet(): void {
    this.walletService.save(this.newWallet).subscribe(() => {
      this.loadWallets();
      this.newWallet = { name: '', balance: 0 }; // Reset form
    });
  }

  updateWallet(wallet: Wallet): void {
    if (wallet.id) {
      this.walletService.update(wallet.id, wallet).subscribe(() => this.loadWallets());
    }
  }

  deleteWallet(id: number): void {
    this.walletService.delete(id).subscribe(() => this.loadWallets());
  }
}
