package xml1.gestionformationss.model;


public class Student {
    private String id;
    private String name;
    private float moyenne;
    private String formationId;

    public Student(String id, String name, float moyenne, String formationId) {
        this.id = id;
        this.name = name;
        this.moyenne = moyenne;
        this.formationId = formationId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float getMoyenne() { return moyenne; }
    public void setMoyenne(float moyenne) { this.moyenne = moyenne; }

    public String getFormationId() { return formationId; }
    public void setFormationId(String formationId) { this.formationId = formationId; }
}
