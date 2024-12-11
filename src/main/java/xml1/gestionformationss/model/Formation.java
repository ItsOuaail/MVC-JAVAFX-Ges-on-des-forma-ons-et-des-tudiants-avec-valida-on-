package xml1.gestionformationss.model;


public class Formation {
    private String id;
    private String name;

    public Formation(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return name; // Pour afficher directement le nom dans la ComboBox
    }
}
