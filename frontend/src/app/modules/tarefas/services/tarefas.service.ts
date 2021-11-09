import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TarefaModel} from "../model/tarefa.model";
import {environment} from "../../../../environments/environment";
import {TarefaFiltroModel} from "../model/tarefa-filtro.model";
import {PageModel} from "../../../shared/page.model";

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

    apiUrl = environment.apiUrl + '/tarefas';

    constructor(
        private httpClient: HttpClient
    ) { }

    search(filtro: TarefaFiltroModel): Observable<PageModel<TarefaModel[]>> {
        return this.httpClient.post<PageModel<TarefaModel[]>>(`${this.apiUrl}/_search`, filtro);
    }

}
