import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
// tslint:disable-next-line: max-line-length
import { GCConsultarDatosComponent } from './semillero/componentes/gestionarComic/gestionarComicConsultarDatos/gestionarComicConsultarDatos';
import { GestionarAfiliadoComponent } from './semillero/componentes/gestionar-afiliado/gestionar-afiliado.component';
import { GestionarUsuarioComponent } from './semillero/componentes/gestionarUsuario/gestionar-usuario.component';
import { ConsultarDatosUsuarioComponent } from './semillero/componentes/gestionarUsuario/consultar-datos-usuario/consultar-datos-usuario.component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  {path: 'gestionar-afiliado', component: GestionarAfiliadoComponent},
  {path: 'gestionar-usuario', component:   GestionarUsuarioComponent},
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'gCConsultarDatos', component: GCConsultarDatosComponent, data : null},
  { path: 'app-consultar-datos-usuario', component: ConsultarDatosUsuarioComponent, data : null}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
