class Horse extends PackAnimal {

    public Horse(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }
    @Override
    public String getType() {
        return "Лошадь";
    }
}