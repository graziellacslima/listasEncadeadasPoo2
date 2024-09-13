import java.util.Scanner;

public class ContactManager {
    private ContactList contactList;

    public ContactManager() {
        contactList = new ContactList();
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Exibe o menu antes de cada iteração
            System.out.println("Sistema de Gerenciamento de Contatos");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma Opção: ");

            String optionInput = scanner.nextLine();
            int option;

            try {
                option = Integer.parseInt(optionInput);
            } catch (NumberFormatException e) {
                System.out.println("Opção Inválida. Por favor, digite um número inteiro.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Digite o Nome Completo: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o Número de Telefone: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Digite o E-mail: ");
                    String email = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber, email);
                    contactManager.contactList.addContact(contact);
                    System.out.println("Contato Adicionado!");
                    break;
                case 2:
                    System.out.print("Digite o Nome ou Número de Telefone Para Buscar: ");
                    String searchQuery = scanner.nextLine();
                    Contact foundContact = contactManager.contactList.searchContact(searchQuery);
                    if (foundContact != null) {
                        System.out.println("Contato Encontrado: " + foundContact.toString());
                    } else {
                        System.out.println("Contato Não Encontrado");
                    }
                    break;
                case 3:
                    System.out.print("Digite o Nome ou Número de Telefone Para Remover: ");
                    String removeQuery = scanner.nextLine();
                    contactManager.contactList.removeContact(removeQuery);
                    System.out.println("Contato Removido (se existia)!");
                    break;
                case 4:
                    String allContacts = contactManager.contactList.listContacts();
                    if (allContacts.isEmpty()) {
                        System.out.println("Nenhum contato encontrado.");
                    } else {
                        System.out.println("Lista de Contatos:");
                        System.out.println(allContacts);
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }
}
