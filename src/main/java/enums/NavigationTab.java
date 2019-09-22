package enums;

public enum NavigationTab {
    PRODUCTS("Products"),
    KIDS("Kids"),
    TRAVEL("Travel"),
    LONDON("London"),
    ACTIVITIES("Activities");

    private final String label;

    NavigationTab(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
