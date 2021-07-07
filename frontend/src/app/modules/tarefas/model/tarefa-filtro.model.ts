export class TarefaFiltroModel {

    constructor(
        public titulo?: string,
        public dataInicioPrevista?: Date | string,
        public dataTerminoPrevista?: Date | string,
        public dataInicio?: Date | string,
        public dataTermino?: Date | string,
        public nomeResponsavel?: string
    ) { }

    formatarData(): TarefaFiltroModel {
        const copy = {...this};
        if (!!this.dataInicioPrevista) {
            copy.dataInicioPrevista = this.dataInicioPrevista.toString().split('/').reverse().join('-');
        }
        if (!!this.dataTerminoPrevista) {
            copy.dataTerminoPrevista = this.dataTerminoPrevista.toString().split('/').reverse().join('-');
        }
        if (!!this.dataInicio) {
            copy.dataInicio = this.dataInicio.toString().split('/').reverse().join('-');
        }
        if (!!this.dataTermino) {
            copy.dataTermino = this.dataTermino.toString().split('/').reverse().join('-');
        }
        return copy;
    }
}
