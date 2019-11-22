
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../services/servicios/gestionar.comic.service';
import { ResultadoDTO } from '../../dto/resultado.dto';
import { JsonPipe, DatePipe } from '@angular/common';
import { HttpParams } from '@angular/common/http';


/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css'],
    providers: [DatePipe]
})
export class GestionarComicComponent implements OnInit {

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

    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

   /**
     * Atributo que indica si se se esta editando un comic
     */ 
    public editando : boolean;

    /**
     *  Atributo que indica el indice de la lista del comic que sera editado
     */
    public index : number;

    /**
     *  Atributo que indica cuando se ha eliminado un comic
     */
    public eliminar : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarComicService : GestionarComicService,
        public datepipe: DatePipe) {
        this.gestionarComicForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null, Validators.required],
            tematicaEnum : [null],
            coleccion : [null, Validators.required],
            numeroPaginas : [null, Validators.required],
            precio : [null, Validators.required],
            autores : [null, Validators.required],
            color : [null]
        });
        this.editando = false;
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.eliminar = false;
        this.consultarComics();

    }
    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarComics() : void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */



    public crearActualizarComic() : void {
        this.submitted = true;
        if(this.gestionarComicForm.invalid) {
            return;
        }
        
        this.comic = new ComicDTO();
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematicaEnum = this.gestionarComicForm.controls.tematicaEnum.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.comic.cantidad = 12;
        this.comic.fechaVenta = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
        
        if(!this.editando){

            this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
                if(resultadoDTO.exitoso) {
                    this.consultarComics();
                    this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
            });
        }
        else{
            this.comic = this.listaComics[this.index];
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematicaEnum = this.gestionarComicForm.controls.tematicaEnum.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            this.comic.cantidad = 12;
            console.log(this.comic.id);
            this.gestionarComicService.modificarComic(this.comic).subscribe(ResultadoDTO =>{
                if (ResultadoDTO.exitoso){
                    this.consultarComics();
                    this.limpiarFormulario();
                    this.editando = false;
                }
            }, error => {
                console.log(error);
            }); 
        }
        
    } 



    /**
     * Metodo que enruta hacia el componente consultar-comic
     * @param comic 
     */
    public consultarComic(posicion : number) : void {
        let comics = this.listaComics[posicion];
        let params = new HttpParams()
                .set('idComic', comics.id);
        //this.router.navigate(['consultar-comic',{params}]);
        this.router.navigate(['consultar-comic'], {queryParams: {idComic: comics.id}});

    } 

    /**
     * Metodo para editar los atributos de un comic
     * @param posicion 
     */
    public editarComic(posicion : number)  : void {
        let comic = this.listaComics[posicion];
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematicaEnum.setValue(comic.tematicaEnum);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.editando = true;
        this.index = posicion;
    }
    /**
     * Metodo para limpiar el formulario
     */
    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematicaEnum.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }
    /**
     * Metodo para eliminar un comic
     * @param posicion 
     */
    public eliminarComic(posicion: number) : void{
        //this.listaComics.splice(posicion,1);
        let comic = this.listaComics[posicion];
        console.log(posicion);
        console.log(parseInt(comic.id));
        this.gestionarComicService.eliminarComic(parseInt(comic.id)).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarComics();
                this.eliminar = true;
            }
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }
}