class Hamster extends Pet {

    public Hamster(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }
    @Override
    public String getType() {
        return "Хомяк";
    }
}