import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
// tslint:disable-next-line: max-line-length
import { GCConsultarDatosComponent } from './semillero/componentes/gestionarComic/gestionarComicConsultarDatos/gestionarComicConsultarDatos';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'gCConsultarDatos', component: GCConsultarDatosComponent, data : null}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }