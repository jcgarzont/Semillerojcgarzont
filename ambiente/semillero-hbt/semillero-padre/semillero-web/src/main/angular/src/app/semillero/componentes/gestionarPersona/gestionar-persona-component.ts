import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PersonaDTO } from '../../dto/persona.dto';
import { GestionarPersonaService } from '../../services/servicios/gestionar.persona.service';
import { ResultadoDTO } from '../../dto/resultado.dto';
import { HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';


/**
 *  @description Componenenete para crear una persona
 *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
 */

@Component({
    selector: 'gestionar-persona',
    templateUrl: './gestionar-persona-component.html',
    styleUrls: ['./gestionar-persona-component.css']
})

export class GestionarPersonaComponent implements OnInit {


    public gestionarPersonaForm : FormGroup;

    public persona: PersonaDTO;

    public listaPersonas : Array<PersonaDTO>;

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
     */
    ngOnInit(): void {
        this.persona = new PersonaDTO();
        this.listaPersonas = new Array<PersonaDTO>();
        this.consultarPersonas();
    }

     /**
     * @description Constructor del componente GestionarPersonaComponent
     *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
     */
    constructor(private fb : FormBuilder, private gestionarPersonaService : GestionarPersonaService,
        private router : Router){

        this.gestionarPersonaForm = this.fb.group({
            nombre : [null, Validators.required],
            numeroIdentificacion : [null]
        });
    }

    /**
     * Metodo para crear una persona
     */
    public crearPersona(){
        
        this.persona = new PersonaDTO();
        this.persona.nombre = this.gestionarPersonaForm.controls.nombre.value;
        this.persona.numeroIdentificacion = this.gestionarPersonaForm.controls.numeroIdentificacion.value;
        console.log(this.persona);

        this.gestionarPersonaService.crearPersona(this.persona).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.limpiarFormulario();
            }
        }, error => {
            console.log(error);
        });

    }

    /**
     * Metodo para limpiar el formulario
     */
    private limpiarFormulario() : void {
        this.gestionarPersonaForm.controls.nombre.setValue(null);
        this.gestionarPersonaForm.controls.numeroIdentificacion.setValue(null);
    }

    /**
     * Metodo para consultar personas
     */
    public consultarPersonas() : void {
        this.gestionarPersonaService.consultarPersonas().subscribe(listaPersonas => {
            this.listaPersonas = listaPersonas;
        }, error => {
            console.log(error);
        });
    }
     /**
     * Metodo para enrutar hacia el componente gestionar-usuario
     */
    public gestionarUsuario(posicion : number) : void {
        let persona = this.listaPersonas[posicion];
        let params = new HttpParams()
                .set('idPersona', persona.id);
        this.router.navigate(['gestionar-usuario'], {queryParams: {idPersona: persona.id}});
    } 
    /**
     * Metodo que obtienen los controles y sus propiedades
     */
    get f() { 
        return this.gestionarPersonaForm.controls;
    }
}