import { Component, OnInit } from "@angular/core";


/**
 * @description Componente para mostrar los comics
 * @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
 */

 @Component({
     selector: 'mi-nombre',
     templateUrl: './mi-nombre-component.html',
     styleUrls: ['./mi-nombre-component.css']
 })

 export class MiNombreComponent implements OnInit{
     public nombreConCiudad :string;
     public listaComics :  Array<any> = new Array<any>();
     public nombreEliminado :string = "";
     public mostrarMensaje :boolean;

     constructor() { }
     /**
      * Evento angular que se ejecuta al invocar el componente
      */
     ngOnInit(): void {  
        this.mostrarMensaje = false; 
        this.nombreConCiudad = "Juan Camilo Garzon Tellez - Armenia";
        this.CrearComic('1','batman','marvel','accion',50,60500.99,"Pedrito Barrera", true, new Date("2019-10-10"),"activo");
        this.CrearComic('2','superman','marvel','accion',50,60500.99,"Pedrito Barrera", true, new Date("2019-10-10"),"activo");
        this.CrearComic('3','acuaman','marvel','accion',50,60500.99,"Pedrito Barrera", true, new Date("2019-10-10"),"activo");
        this.CrearComic('4','flash','marvel','accion',50,60500.99,"Pedrito Barrera", true, new Date("2019-10-10"),"activo");
        this.CrearComic('5','deadpool','marvel','accion',50,60500.99,"Pedrito Barrera", true, new Date("2019-10-10"),"activo");
        //alert(JSON.stringify(this.listaComics[0].nombre));
    }

     /**
      * Metodo para crear y agregar un comic a la lista
      */
     public CrearComic(id:string, nombre:string, editorial:string, tematica:string,  
        numeroPaginas:number, precio:number, autores:string, aColor:boolean, fechaVenta:Date,
        estado:string) :void{
        let MiComic: MiComic;
        MiComic = {id, nombre, editorial, tematica, numeroPaginas, precio, autores, aColor,
        fechaVenta, estado};
        this.AgregarComic(this.listaComics,MiComic);
     }
     /**
      * Metodo para agregar un comic a la lista
      */
     public AgregarComic(listaComics:Array<any>, MiComic:MiComic) :void{
         listaComics.push(MiComic);
     }

     /**
      * Evento para eliminar un objeto de la lista  
      */
     public eliminarEventoClick(index:number) :void{
         this.nombreEliminado = this.listaComics[index].nombre;
         this.listaComics.splice(3, 1);
         this.mostrarMensaje = true;
     }
     /**
      * Evento para ocultar el mensaje de comic eliminado
      */
     public ocultarEventoClick() :void{
         this.mostrarMensaje = false;
     }
 }
 /**
  * clase para con los atributos de un comic
  */
class MiComic {

    /**
    * Indicador de resultado.
    */
    public id: string;

    /**
    * Indicador de resultado.
    */
    public nombre: string;

    /**
    * Indicador de resultado.
    */
    public editorial: string;

    /**
    * Indicador de resultado.
    */
    public tematica: string;

    /**
    * Indicador de resultado.
    */
    public numeroPaginas: number;

    /**
    * Indicador de resultado.
    */
    public precio: number;

    /**
    * Indicador de resultado.
    */
    public autores: string;

    /**
    * Indicador de resultado.
    */
    public aColor: boolean;

    /**
    * Indicador de resultado.
    */
    public fechaVenta: Date;

    /**
    * Indicador de resultado.
    */
    public estado: string;
}