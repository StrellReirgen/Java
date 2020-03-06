package Projecto_Class;

public class Project {
	//Establece los Campos del Proyecto
    private String name;
    private String description;
    private double initialCost ;
    //Sobrecarga el método del constructor según la información proporcionada durante la creación de instancias de los Objetos del Projecto.
    public Project() {
    }
    public Project(String name){
        this.name = name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Project(String name, double costoInicial, String description){
        this.name = name;
        this.initialCost  = costoInicial;
        this.description = description;
    }
    // Imprime la informacion de los objetos del Projecto
    public void elevatorPitch(){
        System.out.println(name+" ("+initialCost +"): "+description);
    }
    // Establece el Nombre del Proyecto
    public void setName(String name){
        this.name = name;
    }
    // Establece la descripcion del Proyecto
    public void setDescription(String description){
        this.description = description;
    }
    // Establece el Costo Inicial del proyecto
    public void setInitialCost(double initialCost){
        this.initialCost  = initialCost;
    }
    // Devuelve el Nombre del Proyecto
    public String getName() {
        return name;
    }
    // Devuelve la descripcion del Proyecto
    public String getDescription() {
        return description;
    }
    // Devuelve el costo inicial del Proyecto
    public double getInitialCost(){
        return initialCost ;
    }
}
