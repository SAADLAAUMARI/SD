import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TransferComponent} from "./transfer/transfer.component";
import {WalletComponent} from "./wallet/wallet.component";

const routes: Routes = [
  {path:"transfers",component:TransferComponent},
  {path:"wallets",component:WalletComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
