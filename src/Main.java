import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many users do you want to Insert");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name of user : " + (i + 1));
            String name = scanner.next();
            System.out.println("Enter email of " + name);
            String email = scanner.next();
            System.out.println("Enter age of " + name);
            int age = scanner.nextInt();
            System.out.println("Enter account balance of " + name);
            int balance = scanner.nextInt();
            User user = new User(name, email, age, balance);
            users.add(user);
            System.out.println("User Added Successfully");
            user.display();
        }

        System.out.println("How do you want sort users \n Press 1 for Ascending \n Press any key for Descending");
        int res = scanner.nextInt();
        if (res == 1) {
            users = sortUsers(true, users);
        } else {
            users = sortUsers(false, users);
        }
        printAll(users);

        boolean shouldStop = false;

        while (!shouldStop) {
            // shouldStop = true;
            System.out.println("""
                    -----  Menu -----
                     1. Add Money
                     2. Withdraw Money
                     3. Show Balance""");

            String choice = scanner.next();
            switch (choice) {
                case "1": {
                    System.out.println("Please select user to add money ");

                    for (int j = 0; j < users.size(); j++) {
                        System.out.println(j + 1 + "  " + users.get(j).getName());
                    }

                    int id = scanner.nextInt();

                    if (id <= users.size()) {
                        User u1 = users.get(id - 1);
                        System.out.println("Please Enter Amount to Add");
                        int amount = scanner.nextInt();
                        if (amount > 0) {
                            u1.setBalance(u1.getBalance() + amount);
                            System.out.println("Transaction Successful");
                        } else {
                            System.out.println("Invalid Amount");
                        }

                    } else {
                        System.out.println("User not Found");
                    }
                    break;
                }
                case "2": {
                    System.out.println("Please select user to withdraw money ");

                    for (int j = 0; j < users.size(); j++) {
                        System.out.println(j + 1 + "  " + users.get(j).getName());
                    }

                    int id = scanner.nextInt();

                    if (id <= users.size()) {
                        User u1 = users.get(id - 1);
                        System.out.println("Please Enter Amount to withdraw");
                        int amount = scanner.nextInt();
                        if (amount > 2000) {
                            System.out.println("You cannot withdraw more than 2000 at a time \n Please try with different Amount");
                        } else if (amount < 0) {
                            System.out.println("Amount not valid \n Please try with Different Amount");
                        } else {
                            if (u1.getBalance() < amount) {
                                System.out.println("Insufficient funds");
                            } else {
                                u1.setBalance(u1.getBalance() - amount);
                                System.out.println("Transaction Successful");
                            }
                        }
                    } else {
                        System.out.println("User not Found");
                    }
                    break;
                }
                case "3": {
                    for (int j = 0; j < users.size(); j++) {
                        System.out.println(j + 1 + "  " + users.get(j).getName() + ":" + users.get(j).getBalance());
                    }
                    break;
                }
                case "exit" , "EXIT" , "Exit" : {
                    shouldStop = true;
                    break;
                }
                default: {
                    System.out.println("Invalid Response. Please Try Again");
                    break;

                }
            }


        }
    }


    public static void printAll(ArrayList<User> users) {
        for (User user : users) {
            user.display();
        }

    }

    public static ArrayList<User> sortUsers(boolean flag, ArrayList<User> users) {
        if (flag) {
            users.sort(new Comparator<User>() {
                @Override
                public int compare(User u1, User u2) {
                    return u1.getName().compareToIgnoreCase(u2.getName());
                }
            });

        } else {
            users.sort(new Comparator<User>() {
                @Override
                public int compare(User u1, User u2) {
                    if (u1.getName().compareToIgnoreCase(u2.getName()) == 0) {
                        return 1;
                    } else {
                        return 0;
                    }

                }
            });
        }
        return users;
    }
}
