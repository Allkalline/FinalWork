abstract class Animal {
    protected String name;
    protected String dateOfBirth;
    protected String command;

    public Animal(String name, String dateOfBirth, String command) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.command = command;
    }

    public abstract String getType();

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
