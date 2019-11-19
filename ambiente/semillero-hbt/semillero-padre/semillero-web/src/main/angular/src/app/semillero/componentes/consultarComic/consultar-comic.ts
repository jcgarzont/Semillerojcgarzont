import { OnInit, Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ComicDTO } from '../../dto/comic.dto';
import { GestionarComicService } from '../../services/servicios/gestionar.comic.service';

/**
 *  @description Componenenete para visualizar la informacion de un comic
 *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
 */
@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic.html',
    styleUrls: ['./consultar-comic.css']
})
export class ConsultarComicComponent implements OnInit {
    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;
    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;
    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;


    
    /**
     * @description Este es el constructor del componente ConsultarComicComponent
     *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
     */
    constructor(private router : Router, private activatedRoute: ActivatedRoute, private fb : FormBuilder,
        private gestionarComicService : GestionarComicService) {
        console.log("entro al constructor del componente bienvenida");
        this.gestionarComicForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : [null],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     *  @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
     */
    ngOnInit(): void {

        //let params = this.activatedRoute.queryParams        
        this.activatedRoute.queryParams.subscribe(params => {
            console.log(params); 
            console.log(params["idComic"]);
            this.consultarComic(parseInt(params["idComic"]));
          });
    }
    /**
     * Metodo para desplegar la informacion del comic
     * @param comic 
     */
    public consultarComic(posicion : any) : void {
        this.gestionarComicService.consultarComic(parseInt(posicion)).subscribe(comic => {
            this.comic = comic;
            this.llenarFormulario(this.comic);
        }, error => {
            console.log(error);
        });
    }
    public llenarFormulario(comic : any) : void {
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();
    }
    /**
     * Metodo para enrutar hacia el componente gestionar-comic
     */
    public gestionarComic() : void {
        this.router.navigate(['gestionar-comic']);
    }
    /**
     * Metodo que obtienen los controles y sus propiedades
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }
}
