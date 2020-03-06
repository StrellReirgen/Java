package Projecto_Class;
import java.util.ArrayList;

public class Portfolio {
	 //Creando un nuevo arraylist
    ArrayList<Project> projects = new ArrayList<>();
    // Adds a Project object to the projects ArrayList
    public void addProject(Project project) {
        this.projects.add(project);
    }
    // Suma y devuelve el costo inicial de todos los proyectos del portafolio.
    public double getPortfolioCost() {
        double cost = 0;
        for(Project project: this.projects){
            cost += project.getInitialCost();
        }
        return cost;
    }
    // imprime todos los proyectos del portafolio y ademas el costo del mismo.
    public void showPortfolio() {
        System.out.println("Proyectos del Portafolio:");
        for(Project project: this.projects){
            project.elevatorPitch();
        }
        System.out.println("El Costo de este Portafolio es: $"+getPortfolioCost());
    }
}
