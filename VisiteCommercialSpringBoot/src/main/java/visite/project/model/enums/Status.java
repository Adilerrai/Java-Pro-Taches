package visite.project.model.enums;

public enum Status {
    PLANIFIEE,
    REALISEE,
    ANNULEE;

    public static boolean contains(String status) {
        for (Status s : Status.values()) {
            if (s.name().equals(status)) {
                return true;
            }
        }
        return false;
    }
}
