import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PersonaDTO } from '../../dto/persona.dto';
import { GestionarPersonaService } from '../../services/servicios/gestionar.persona.service';
import { ResultadoDTO } from '../../dto/resultado.dto';




@Component({
    selector: 'gestionar-persona',
    templateUrl: './gestionar-persona-component.html',
    styleUrls: ['./gestionar-persona-component.css']
})

export class GestionarPersonaComponent implements OnInit {


    public gestionarPersonaForm : FormGroup;

    public persona: PersonaDTO;

    public listaPersonas : Array<PersonaDTO>;


    ngOnInit(): void {
        this.persona = new PersonaDTO();
    }

    constructor(private fb : FormBuilder, private gestionarPersonaService : GestionarPersonaService,){

        this.gestionarPersonaForm = this.fb.group({
            nombre : [null, Validators.required],
            numeroIdentificacion : [null]
        });
    }

    public crearPersona(){
        
        this.persona = new PersonaDTO();
        //this.persona.id = "10";
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

    private limpiarFormulario() : void {
        this.gestionarPersonaForm.controls.nombre.setValue(null);
        this.gestionarPersonaForm.controls.numeroIdentificacion.setValue(null);
    }

    public consultarComics() : void {
        this.gestionarPersonaService.consultarPersonas().subscribe(listaPersonas => {
            this.listaPersonas = listaPersonas;
        }, error => {
            console.log(error);
        });
    }

    get f() { 
        return this.gestionarPersonaForm.controls;
    }
}