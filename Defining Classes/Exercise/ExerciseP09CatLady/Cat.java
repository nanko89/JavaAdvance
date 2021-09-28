package ExerciseP09CatLady;

public class Cat {
    private String breed;
    private Cymric cymric;
    private Siamese siamese;
    private StreetExtraordinaire streetExtraordinaire;

    public Cat(String breed, Cymric cymric) {
        this.breed = breed;
        this.cymric = cymric;
    }

    public Cat(String breed, Siamese siamese) {
        this.breed = breed;
        this.siamese = siamese;
    }

    public Cat(String breed, StreetExtraordinaire streetExtraordinaire) {
        this.breed = breed;
        this.streetExtraordinaire = streetExtraordinaire;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.breed + " ");
        if (this.breed.equals("Siamese")) {
            sb.append(this.siamese.getName() + " " + String.format("%.2f", this.siamese.getEarSize()));
        } else if (this.breed.equals("Cymric")) {
            sb.append(this.cymric.getName() + " " + String.format("%.2f", this.cymric.getFurLength()));
        } else {
            sb.append(this.streetExtraordinaire.getName() + " " + String.format("%.2f", this.streetExtraordinaire.getDecibelsOfMeows()));
        }

        return sb.toString();
    }
}
