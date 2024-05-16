package sv.edu.udb.practico03dsm.Model

class ModelRecursos {

    var titulo: String? = null
    var tipo: String? = null
    var descripcion: String? = null
    var imagen: String? = null
    var enlace: String? = null

    constructor() {}
    constructor(
        titulo: String?,
        tipo: String?,
        descripcion: String?,
        imagen: String?,
        enlace: String?
    ) {
        this.titulo = titulo
        this.tipo = tipo
        this.descripcion = descripcion
        this.imagen = imagen
        this.enlace =  enlace
    }


}