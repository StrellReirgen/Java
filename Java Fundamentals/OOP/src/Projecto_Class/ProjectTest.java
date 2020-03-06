package Projecto_Class;

public class ProjectTest {

	public static void main(String[] args) {
		// Creando Proyectos es 4 formas
        Project project = new Project();
        Project project2 = new Project("Proyecto Lazaro");
        Project project3 = new Project("Proyecto Odyssey", "Exploracion y terraformacion de los planetas del sistema Solar.");
        Project project4 = new Project("Proyecto Gaia", 5000000, "Reparacion e la flora y fauna de la tierra.");

        // Creando un nuevo portafolio
        Portfolio portfolio = new Portfolio();

        // Estableciendo nombre, descripcion, y costo inicial del primer proyecto
        project.setName("Primer Proyecto Valkiria!");
        project.setDescription("Crear robots que simulen la conciencia de antiguos Guerreros.");
        project.setInitialCost(3000000);

        // Imprimir el tercer proyecto
        // System.out.println(project3.getName());
        // System.out.println(project3.getDescription());

        // Imprimir la informacion de todos los proyectos
        // project.elevatorPitch();
        // project2.elevatorPitch();
        // project3.elevatorPitch();
        // project4.elevatorPitch();

        // Agregar los 4 proyectos al portafolio
        portfolio.addProject(project);
        portfolio.addProject(project2);
        portfolio.addProject(project3);
        portfolio.addProject(project4);

        // Imprimir el costo del portafolio
        // System.out.println(portfolio.getPortfolioCost());
        
        // Muestra el protafolio completo
        portfolio.showPortfolio();

	}

}
