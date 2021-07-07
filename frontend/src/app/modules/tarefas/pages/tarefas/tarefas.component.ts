import {Component, OnInit} from '@angular/core';
import {TarefaModel} from "../../model/tarefa.model";
import {TarefasService} from "../../services/tarefas.service";
import {TarefaFiltroModel} from "../../model/tarefa-filtro.model";
import {finalize} from "rxjs/operators";
import {BlockUI, NgBlockUI} from "ng-block-ui";

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.css']
})
export class TarefasComponent implements OnInit {

    @BlockUI() blockUI: NgBlockUI;

    tarefas: TarefaModel[] = [];
    filtro: TarefaFiltroModel = new TarefaFiltroModel();

    constructor(
        private tarefasService: TarefasService
    ) { }

    ngOnInit(): void {
        this.buscarTarefas();
    }

    onBuscar(): void {
        this.buscarTarefas();
    }

    private buscarTarefas(): void {
        this.blockUI.start();
        this.tarefasService.search(this.filtro)
            .pipe(finalize(() => this.blockUI.stop()))
            .subscribe(tarefas => this.tarefas = tarefas.content);
    }

}
