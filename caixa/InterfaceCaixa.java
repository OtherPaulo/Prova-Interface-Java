package caixa;
//Paulo Vinicius Cruz Rodrigues - Matricula: 2268566
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfaceCaixa implements ActionListener {

    JFrame tela = new JFrame("Cadastro de Caixas");
    JPanel painel = new JPanel();

    JLabel lbmodelo = new JLabel("Modelo: ");
    JTextField textModel = new JTextField();
    JLabel lbtipo = new JLabel("Tipo: ");
    JTextField textTipo = new JTextField();
    JLabel lbtamanho = new JLabel("Tamanho: ");
    JTextField textTamanho = new JTextField();
    JLabel lbvalor = new JLabel("Valor: ");
    JTextField textValor = new JTextField();
    JLabel resultadoLabel = new JLabel();

    JButton salvar = new JButton("Salvar");
    JButton btExibirLista = new JButton("Exibir Lista");

    List<Caixa> caixas = new ArrayList<>();

    public InterfaceCaixa() {
        tela.setSize(400, 250);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        painel.setLayout(null);

        lbmodelo.setBounds(10, 10, 100, 30);
        painel.add(lbmodelo);

        textModel.setBounds(70, 15, 120, 20);
        painel.add(textModel);

        lbtipo.setBounds(10, 40, 100, 30);
        painel.add(lbtipo);

        textTipo.setBounds(70, 45, 120, 20);
        painel.add(textTipo);

        lbtamanho.setBounds(10, 70, 100, 30);
        painel.add(lbtamanho);

        textTamanho.setBounds(70, 75, 120, 20);
        painel.add(textTamanho);

        lbvalor.setBounds(10, 110, 100, 30);
        painel.add(lbvalor);

        textValor.setBounds(70, 115, 120, 20);
        painel.add(textValor);

        salvar.setBounds(10, 150, 75, 35);
        salvar.addActionListener(this);
        painel.add(salvar);

        btExibirLista.setBounds(110, 150, 120, 35);
        btExibirLista.addActionListener(this);
        painel.add(btExibirLista);

        resultadoLabel.setBounds(10, 200, 300, 35);
        painel.add(resultadoLabel);

        tela.getContentPane().add(painel);
        tela.setVisible(true);
    }

    public static void main(String[] args) {
        InterfaceCaixa interfaceCaixa = new InterfaceCaixa();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salvar) {
            String modelo = textModel.getText();
            String tipo = textTipo.getText();
            int tamanho = Integer.parseInt(textTamanho.getText());
            double valor = Double.parseDouble(textValor.getText());

            Caixa caixa = new Caixa(modelo, tipo, tamanho, valor);
            caixas.add(caixa);

            resultadoLabel.setText("Caixa cadastrada com sucesso!");
            limparCampos();
        }

        if (e.getSource() == btExibirLista) {
            exibirListaCaixas();
        }
    }

    private void exibirListaCaixas() {
        JFrame listaFrame = new JFrame("Lista de Caixas");
        listaFrame.setSize(400, 300);
        listaFrame.setLayout(new BorderLayout());

        JTextArea listaTextArea = new JTextArea();
        listaTextArea.setEditable(false);

        for (Caixa caixa : caixas) {
            listaTextArea.append("Modelo: " + caixa.getModelo()
                    + ", Tipo: " + caixa.getTipo()
                    + ", Tamanho: " + caixa.getTamanho()
                    + ", Valor: " + caixa.getValor() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(listaTextArea);
        listaFrame.add(scrollPane, BorderLayout.CENTER);

        listaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listaFrame.setVisible(true);
    }

    private void limparCampos() {
        textModel.setText("");
        textTipo.setText("");
        textTamanho.setText("");
        textValor.setText("");
    }
}

