
/**
 * @description Clase UsuarioDTO que contiene la informacion de un usuario
 * 
 * @author Juan Camilo Garzon Tellez <camilo_tellez04@hotmail.com>
 */

export class UsuarioDTO {

    /**
     * ID del usuario
     */
    public id: String;
    /**
     * nombre de usuario
     */
    public nombre: String;
    /**
     * fecha de creacion
     */
    public fechaCreacion: String;
    /**
     * estado del usuario
     */
    public estadoEnum: String;
    /**
     * ID de la persona a la que pertenece el usuario
     */
    public idPersona: String; 

}