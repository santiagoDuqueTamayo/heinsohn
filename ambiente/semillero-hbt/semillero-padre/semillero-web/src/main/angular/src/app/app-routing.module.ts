import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { MostrarObjetoTarea } from './semillero/componentes/mostrarObjetoTarea/Mostrar-objeto-tarea-component';
import { DatosComponent } from './semillero/componentes/mostrarDatos/datos-components';


const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent },
  {path: 'mostrar-objeto-tarea', component: MostrarObjetoTarea }
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
