class Pet extends Animal {

    public Pet(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }

    @Override
    public String getType() {
        return "Домашнее животное";
    }
}