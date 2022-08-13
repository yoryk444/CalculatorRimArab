enum ArithmeticOperations {
    ADD("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String meaning;

    public String getMeaning() {
        return meaning;
    }

    ArithmeticOperations(String meaning) {
        this.meaning = meaning;
    }
}