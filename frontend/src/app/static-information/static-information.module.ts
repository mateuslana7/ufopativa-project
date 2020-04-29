import {NgModule} from '@angular/core'
import {RouterModule, Routes} from '@angular/router'

import { ContactUsComponent } from './contact-us/contact-us.component'
import { AboutComponent } from './about/about.component'

const ROUTES: Routes = [
    {path: 'sobre', component: AboutComponent},
    {path: 'fale-conosco', component: ContactUsComponent}
]

@NgModule({
    declarations: [AboutComponent, ContactUsComponent],
    imports: [RouterModule.forChild(ROUTES)]
})

export class StaticInformationModule {

}