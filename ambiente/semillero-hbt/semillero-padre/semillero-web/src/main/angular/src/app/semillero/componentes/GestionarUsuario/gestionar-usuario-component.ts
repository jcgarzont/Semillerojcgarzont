import { OnInit, Component } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { GestionarUsuarioService } from '../../services/servicios/gestionar.usuario.service';
import { UsuarioDTO } from '../../dto/usuario.dto';
import { DatePipe } from '@angular/common';

/**
 *  @description Componenenete para gestionar un usuario
 *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
 */
@Component({
    selector: 'gestionar-usuario',
    templateUrl: './gestionar-usuario-component.html',
    styleUrls: ['./gestionar-usuario-component.css'],
    providers: [DatePipe]
})

export class GestionarUsuarioComponent implements OnInit {

    public gestionarUsuarioForm : FormGroup;

    public usuario : UsuarioDTO;

    public listaUsuarios: Array<UsuarioDTO>;

    public id: String;

    public existe : Boolean;

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
     */
    ngOnInit(): void {
        this.activatedRoute.queryParams.subscribe(params => {
            this.id = params["idPersona"];
            this.consultarUsuarios();
          });
    }

      /**
     * @description Constructor del componente GestionarUsuarioComponent
     *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
     */
    constructor(private fb : FormBuilder,private router : Router,private activatedRoute: ActivatedRoute,
        private gestionarUsuarioService : GestionarUsuarioService, public datepipe: DatePipe){

        this.gestionarUsuarioForm = this.fb.group({
            nombre : [null, Validators.required],
            fechaCreacion : [null],
            estadoEnum: [null]
        });
    }
    
    /**
     * Metodo para consultar un usuario
     * @param posicion 
     */
    public consultarUsuario(posicion : any) : void {
        this.gestionarUsuarioService.consultarUsuario(parseInt(posicion)).subscribe(usuario => {
            this.usuario = usuario;
            this.llenarFormulario()
        }, error => {
            console.log(error);
        });
    }
    /**
     * Metodo para consultar los usuarios
     */
    public consultarUsuarios() : void {
        this.gestionarUsuarioService.consultarUsuarios().subscribe(listaUsuarios => {
            this.listaUsuarios = listaUsuarios;
        }, error => {
            console.log(error);
        });
    }
    /**
     * Metodo para crear usuarios
     */
    public crearUsuario() :void {
        this.usuario = new UsuarioDTO;
        this.usuario.idPersona = this.id;
        this.usuario.fechaCreacion = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
        this.usuario.estadoEnum = "ACTIVO";
        this.gestionarUsuarioService.crearUsuario(this.usuario).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarUsuario(this.id);
                this.llenarFormulario();
                console.log("Exito");
                this.existe = true;
            }
        }, error => {
            console.log(error);
        });
    }
    /**
     * Metodo para desplegar el formulario
     */
    public llenarFormulario():void {
        this.gestionarUsuarioForm.controls.nombre.setValue(this.usuario.nombre);
        this.gestionarUsuarioForm.controls.estadoEnum.setValue(this.usuario.estadoEnum);
        this.gestionarUsuarioForm.controls.nombre.disable();
        this.gestionarUsuarioForm.controls.estadoEnum.disable();
    }
}