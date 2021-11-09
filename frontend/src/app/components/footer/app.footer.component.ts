import { Component } from '@angular/core';
import { version } from '../../../../package.json';

@Component({
    selector: 'app-footer',
    templateUrl: './app.footer.component.html'
})
export class AppFooterComponent {

    versao = version;

}
