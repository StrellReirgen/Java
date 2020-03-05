import java.util.HashMap;
public class TrackList {
    public void trackList(){
        // Create a trackList of type HashMap
        HashMap<String, String> tracks = new HashMap<>();
        // Add in at least 4 songs that are stored by title
        tracks.put("Un Conejito", "Un conejin, muy picaron, de colita blanca como el algodon, su mama le dijo, oye conejin, no andes tan ligero en monopatin, el desobediente pronto se cayo, mira la cola como le quedo, SUCIA");
        tracks.put("Arroz con Leche", "Arroz con leche, me quiero casa, con una señorita de portugal");
        tracks.put("Las Manitos", "Las manito, las manitos, ¿donde estan?, aqui estan");
        tracks.put("Cuncuna Amarilla","Una cuncuna Amarilla, debajo de un Hongo vivia");
        
        System.out.println("Canciones en el Hashmap");
        tracks.forEach((titulo,lirico) -> System.out.println(titulo + ": " + lirico));
        // extraccion
        System.out.println("Cancion Favorita");
        System.out.println("La letra de la cancion <Un Conejito> es: "+ tracks.get("Un Conejito"));
    }
}