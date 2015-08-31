package entidades;


/**
 * @category ESPOL
 * @version 8.0
 * @author Villacis, Marmolejo, Espinosa.
 */
public class Peliculas implements java.io.Serializable {
	
	  private String  id;
	  private String  titulo;
	  private String  clasificacion;
	  private String  genero;
	  private String  idioma;
	  private String  actor;
	  private String  director;
	  private String  sinopsis;
	  private int     año;
	  private int     duracion;
	/**
	 * @param id
	 * @param titulo
	 * @param clasificacion
	 * @param genero
	 * @param idioma
	 * @param actor
	 * @param director
	 * @param sinopsis
	 * @param año
	 * @param duracion
	 */
	  
	  
	public Peliculas(String id, String titulo, String clasificacion,
			String genero, String idioma, String actor, String director,
			String sinopsis, int año, int duracion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.clasificacion = clasificacion;
		this.genero = genero;
		this.idioma = idioma;
		this.actor = actor;
		this.director = director;
		this.sinopsis = sinopsis;
		this.año = año;
		this.duracion = duracion;
	}
	
	/**
	 * 
	 */
	public Peliculas() {
		super();
	}

	public Peliculas(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	  
	  
}
