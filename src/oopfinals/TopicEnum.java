package OOPFinals;

public enum TopicEnum {
    CONTROL_STRUCTURES_AND_ARRAY("Control Structures and Array"),
    ENCAPSULATION_AND_INHERITANCE("Encapsulation and Inheritance"),
    POLYMORPHISM_AND_ABSTRACTION("Polymorphism and Abstraction"),
    EXCEPTIONS_AND_ASSERTIONS("Exceptions and Assertions"),
    COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM("Collections and Input and Output Stream"),
    MIXED_TOPICS("Mixed Topics");
    
    private final String displayName;

    TopicEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
