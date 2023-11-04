class Donkey extends PackAnimal {

    public Donkey(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }
    @Override
    public String getType() {
        return "Осел";
    }
}
