class Cat extends Pet {

    public Cat(String name, String dateOfBirth, String command) {
        super(name, dateOfBirth, command);
    }
    @Override
    public String getType() {
        return "Кошка";
    }
}