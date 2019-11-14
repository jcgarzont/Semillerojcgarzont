import { OnInit, Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ComicDTO } from '../../dto/comic.dto';

/**
 *  @description
 *  @author 
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
    
    constructor(private router : Router, private activatedRoute: ActivatedRoute, private fb : FormBuilder,) {
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

    ngOnInit(): void {
        let comic = this.activatedRoute.snapshot.params;
        this.consultarComic(comic);
    }

    //public consultarComic(posicion : number) : void {
    public consultarComic(comic : any) : void {
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
    public gestionarComic() : void {
        this.router.navigate(['gestionar-comic']);
    }
    get f() { 
        return this.gestionarComicForm.controls;
    }
}
