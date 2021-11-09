import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import {CommonModule} from "@angular/common";

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
        CommonModule
    ],
    providers: [],
    exports: [
        PRIMENG_IMPORTS,
        CommonModule
    ]
})
export class SharedModule { }
