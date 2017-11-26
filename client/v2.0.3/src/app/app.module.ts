import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { MaterializeModule } from 'ng2-materialize';
import { DataTablesModule } from 'angular-datatables';

import { AuthService } from './login/auth.service';
import { HttpService } from './http.service';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { routing } from './app.routing';

import { configuracoesRouting } from "./configuracoes/configuracoes.routing";
import { ConfiguracoesModule } from "./configuracoes/configuracoes.module";

import { aprendizesRouting } from "./aprendizes/aprendizes.routing";
import { AprendizesModule } from "./aprendizes/aprendizes.module";

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterializeModule.forRoot(),
    ConfiguracoesModule,
    configuracoesRouting,
    AprendizesModule,
    aprendizesRouting,
    routing,
    DataTablesModule
  ],
  providers: [HttpService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
