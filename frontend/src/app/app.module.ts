import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LOCALE_ID, NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SharedModule} from './shared/shared.module';
import {AppTopbarComponent} from './components/topbar/app.topbar.component';
import {AppFooterComponent} from './components/footer/app.footer.component';
import {HashLocationStrategy, LocationStrategy, registerLocaleData} from '@angular/common';
import {environment} from '../environments/environment';
import {HttpClientModule} from '@angular/common/http';
import {BreadcrumbModule, ErrorStackModule, MenuModule, PageNotificationModule} from '@nuvem/primeng-components';
import {ErrorModule, SecurityModule, VersionTagModule} from '@nuvem/angular-base';
import {DiarioErrosComponent} from './components/diario-erros/diario-erros.component';
import {BlockUIModule} from 'ng-block-ui';
import localePt from '@angular/common/locales/pt';

registerLocaleData(localePt);

@NgModule({
    declarations: [
        AppComponent,
        AppTopbarComponent,
        AppFooterComponent,
        DiarioErrosComponent
    ],
    imports: [
        BlockUIModule.forRoot({
            message: "Carregando..."
          }),
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        SharedModule,
        HttpClientModule,
        PageNotificationModule,
        BreadcrumbModule,
        ErrorStackModule,
        ErrorModule,
        VersionTagModule,
        SecurityModule.forRoot(environment.auth),
        MenuModule
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy },
        { provide: LOCALE_ID, useValue: 'pt-BR' }
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
