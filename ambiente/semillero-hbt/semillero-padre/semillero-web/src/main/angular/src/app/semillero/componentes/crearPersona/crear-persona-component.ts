import { Component, OnInit } from "@angular/core";


/**
 * @description Componente para crear personas
 * @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
 */

 @Component({
     selector: 'crear-persona',
     templateUrl: './crear-persona-component.html'
 })

 export class CrearPersonaComponent implements OnInit{
    public nombreInstructorGlobal :string;
    public listaApellidos :  Array<any> = new Array<any>();
    

     ngOnInit() :void{

        let nombreInstructor = "Diego Alvarez";
        let nombreInstructorString :string = "Diego Alvarez String"

        let miVariableAny :any = {
            id:1,
            nombre:"juan",
            direccion:"calle 34",
            colores:[0,1,2,3,4]
        };
        miVariableAny.genero="masculino";
     }
     public inicializarComponente() : Array<string> {
        let retorno : any;
        let objeto = undefined;
        if(objeto !== null && objeto !== undefined){
            console.log("No es nulo")
        } else {
            console.log("Si es nulo");
        }
        
        console.log(1 == 1);
        //console.log("1" == 1);
        console.log(1 === 1);
        //console.log("1" === 1);

        return retorno;
    }
 }