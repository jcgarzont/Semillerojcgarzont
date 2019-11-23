import { Injectable, Injector } from '@angular/core';
import { AbstractService } from '../template.service';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioDTO } from '../../dto/usuario.dto';




@Injectable({
    providedIn: 'root'
  })

export class GestionarUsuarioService extends AbstractService {
   
/**
* Constructor de la clase
*/
constructor(injector: Injector, private httpClient : HttpClient) {
        super(injector);
    }

    public consultarUsuario(idPersona : number): Observable<any> {
        //let params = new HttpParams().set('idPersona', String(idPersona));

        //return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuario',{params});
        return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuario',idPersona);
    
    }

    public consultarUsuarios(): Observable<any> {
        return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuarios');
    }
    
    public crearUsuario(usuarioDTO : UsuarioDTO): Observable<any> {
        return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crear',usuarioDTO);
    }


}