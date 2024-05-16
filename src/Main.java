import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Social social = Social.getInstance();
        Utente loggedUser = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("Social Network Menu:");
            System.out.println("1. Login");
            System.out.println("2. Create Group");
            System.out.println("3. Write Message to Group");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter mail: ");
                    String mail = scanner.nextLine();
                    for (Utente u : Social.getListaUtenti()){
                        if (u.getUsername().equalsIgnoreCase(mail)){
                            System.out.print("Enter password: ");
                            String pass = scanner.nextLine();

                            if (u.authentication(mail,pass) == 1){
                                System.out.println("User successfully logged in!");
                                loggedUser = u;
                            }
                            else {
                                System.out.print("Enter user name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter user surname: ");
                                String surname = scanner.nextLine();
                                System.out.print("Enter username: ");
                                String username = scanner.nextLine();
                                Utente utente = new Utente(name,surname,username,mail,pass);
                                loggedUser = utente;
                                Social.getListaUtenti().add(utente);
                                System.out.println("User successfully created!");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter group name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter group topic: ");
                    String topic = scanner.nextLine();
                    Gruppo gruppo = new Gruppo(name, topic);
                    Social.getListaGruppi().add(gruppo);
                    System.out.println("Group created successfully!");
                    break;
                case 3:
                    System.out.print("Enter group name: ");
                    String groupName = scanner.nextLine();
                    System.out.print("Enter message text: ");
                    String messageText = scanner.nextLine();

                    Messaggio m = new Messaggio(messageText);

                    Gruppo g = null;
                    if (loggedUser != null) {
                        g = loggedUser.cercaGruppo(groupName);
                    }

                    if (g != null) {
                        loggedUser.scriviMess(groupName, messageText);
                        Pubblicazione p = new Pubblicazione(loggedUser, m);
                        System.out.println("Message written to group successfully!");
                    } else {
                        System.out.println("Group not found!");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }

        scanner.close();
    }
}
