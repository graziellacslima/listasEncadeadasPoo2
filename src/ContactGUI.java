import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactGUI {
    private ContactList contactList;
    private JTextArea contactArea; // Área para exibir os contatos

    public ContactGUI() {
        contactList = new ContactList(); // Instanciação da lista de contatos
        contactArea = new JTextArea();   // Instanciação da área de texto para exibir os contatos
        // Inicialização e configuração da interface gráfica (JFrame, botões, etc.)
    }

    // Método para configurar a interface e eventos (como botões)
    public void initGUI() {
        JFrame frame = new JFrame("Gerenciador de Contatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        JButton listButton = new JButton("Listar Contatos");

        // Área de texto para exibir a lista de contatos
        contactArea.setEditable(false);

        // Adiciona ação ao botão "Listar Contatos"
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listContacts();
            }
        });

        panel.add(listButton);
        frame.add(panel);
        frame.add(new JScrollPane(contactArea), "South");
        frame.setVisible(true);
    }

    // Método ajustado para listar os contatos e exibi-los no JTextArea
    public void listContacts() {
        String allContacts = contactList.listContacts(); // Obtem a lista de contatos em formato String
        if (allContacts.isEmpty()) {
            contactArea.setText("Nenhum contato encontrado.");
        } else {
            contactArea.setText(allContacts); // Exibe a lista de contatos no JTextArea
        }
    }

    public static void main(String[] args) {
        ContactGUI gui = new ContactGUI();
        gui.initGUI(); // Inicializa a interface gráfica
    }
}
