import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';

/**
 * @description La clase CrearPersonaComponent permite crear personas
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'crear-persona',
    templateUrl: './crear-persona-component.html'
})
export class CrearPersonaComponent implements OnInit{
    
    private nombreInstructorGlobalPrivado : string;
    public nombreInstructorGlobalPublic : string;

    public listaApellidos : Array<any> = new Array<any>();
    public listaNombres = null;

    public comicDTO : ComicDTO;

    ngOnInit() : void {
        

    }


}