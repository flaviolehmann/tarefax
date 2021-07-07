import { NgModule } from '@angular/core';
import { TarefasComponent } from './pages/tarefas/tarefas.component';
import {RouterModule} from "@angular/router";
import {TarefasRoute} from "./tarefas.routes";
import {SharedModule} from "../../shared/shared.module";


@NgModule({
    declarations: [TarefasComponent],
    imports: [
        RouterModule.forChild(TarefasRoute),
        SharedModule
    ]
})
export class TarefasModule { }
