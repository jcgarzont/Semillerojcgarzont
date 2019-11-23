import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ConsultarComicComponent } from './semillero/componentes/consultarComic/consultar-comic';
import { GestionarPersonaComponent } from './semillero/componentes/gestionarPersona/gestionar-persona-component';
import { GestionarUsuarioComponent } from './semillero/componentes/GestionarUsuario/gestionar-usuario-component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'consultar-comic', component: ConsultarComicComponent, data:null},
  { path: 'gestionar-persona', component: GestionarPersonaComponent },
  { path: 'gestionar-usuario', component: GestionarUsuarioComponent, data:null}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
