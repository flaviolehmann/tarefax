import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TarefasModule} from "./modules/tarefas/tarefas.module";
import {AnexosModule} from "./modules/anexos/anexos.module";

const routes: Routes = [
    { path: 'tarefas', loadChildren: () => TarefasModule, data: { breadcrumb: 'Tarefas' } },
    { path: 'anexos', loadChildren: () => AnexosModule, data: { breadcrumb: 'Anexos' } },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
