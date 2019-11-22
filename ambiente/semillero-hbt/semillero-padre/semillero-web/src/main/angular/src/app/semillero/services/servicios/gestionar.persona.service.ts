import { Injectable, Injector } from '@angular/core';
import { AbstractService } from '../template.service';
import { PersonaDTO } from '../../dto/persona.dto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';



@Injectable({
    providedIn: 'root'
  })
    export class GestionarPersonaService extends AbstractService {
  
    /**
     * Constructor de la clase
     */
    constructor(injector: Injector, private httpClient : HttpClient) {
      super(injector);
    }
    public crearPersona(personaDTO : PersonaDTO): Observable<any> {
        return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarPersona/crear',personaDTO);
    }
    public consultarPersonas(): Observable<any> {
      return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersona/consultarPersonas');
    }
}