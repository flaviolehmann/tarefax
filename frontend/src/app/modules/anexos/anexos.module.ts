import {NgModule} from '@angular/core';
import {AnexosComponent} from './pages/anexos/anexos.component';
import {SharedModule} from "../../shared/shared.module";
import {RouterModule} from "@angular/router";
import {AnexosRoute} from "./anexos.routes";


@NgModule({
    declarations: [AnexosComponent],
    imports: [
        RouterModule.forChild(AnexosRoute),
        SharedModule
    ]
})
export class AnexosModule { }
