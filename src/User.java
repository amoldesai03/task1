public class User implements Comparable {
    private String _name;
    private String _email;
    private int _age;
    private int _balance;

    public User(String name, String email, int age, int balance) {
        _name = name;
        _email = email;
        _age = age;
        _balance = balance;
    }

    public void display() {
        System.out.println("Name :" + _name + "\n" +
                "Email :" + _email + "\n" +
                "Age :" + _age + "\n" +
                "Balance :" + _balance + "\n");
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    public int getBalance() {
        return _balance;
    }

    public void setBalance(int balance) {
        this._balance = balance;
    }

    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        return _name.compareToIgnoreCase(u.getName());
    }


}
