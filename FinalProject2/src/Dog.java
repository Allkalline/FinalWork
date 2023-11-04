class Dog extends Pet {

    public Dog(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }
    @Override
    public String getType() {
        return "Собака";
    }
}