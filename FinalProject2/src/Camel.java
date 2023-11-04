class Camel extends PackAnimal {

    public Camel(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }
    @Override
    public String getType() {
        return "Верблюд";
    }
}