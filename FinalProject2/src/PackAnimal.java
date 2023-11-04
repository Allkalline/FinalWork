class PackAnimal extends Animal {

    public PackAnimal(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }

    @Override
    public String getType() {
        return "Вьючное животное";
    }
}