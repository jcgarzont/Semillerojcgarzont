import { Component } from "@angular/core";


/**
 * @description Componente para agregar mi informacion personal
 * @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
 */

 @Component({
     selector: 'mi-nombre',
     templateUrl: './mi-nombre-component.html',
     styleUrls: ['./mi-nombre-component.css']
 })

 export class MiNombre{
     nombreConCiudad = "Juan Camilo Garzon Tellez - Armenia";
 }