package caixa;
//Paulo Vinicius Cruz Rodrigues - Matricula: 2268566
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfaceCaixa extends JFrame {

    private List<Caixa> caixas;

    private JTextField modeloField, tipoField, tamanhoField, valorField;
    private JLabel resultadoLabel;

    public InterfaceCaixa() {
        caixas = new ArrayList<>();

        setTitle("Cadastro e Listagem de Caixas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        add(modeloField);

        add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        add(tipoField);

        add(new JLabel("Tamanho:"));
        tamanhoField = new JTextField();
        add(tamanhoField);

        add(new JLabel("Valor:"));
        valorField = new JTextField();
        add(valorField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCaixa();
            }
        });
        add(cadastrarButton);

        JButton listarButton = new JButton("Listar Caixas");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirCaixas();
            }
        });
        add(listarButton);

        resultadoLabel = new JLabel();
        add(resultadoLabel);

        setVisible(true);
    }

    private void cadastrarCaixa() {
        String modelo = modeloField.getText();
        String tipo = tipoField.getText();
        int tamanho = Integer.parseInt(tamanhoField.getText());
        double valor = Double.parseDouble(valorField.getText());

        Caixa caixa = new Caixa(modelo, tipo, tamanho, valor);
        caixas.add(caixa);

        resultadoLabel.setText("Caixa cadastrada com sucesso!");
        limparCampos();
    }

    private void exibirCaixas() {
        JFrame resultadoFrame = new JFrame("Lista de Caixas");
        resultadoFrame.setSize(400, 300);
        resultadoFrame.setLayout(new BorderLayout());

        JTextArea resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);

        resultadoTextArea.append("Lista de Caixas:\n");
        for (Caixa caixa : caixas) {
            resultadoTextArea.append("Modelo: " + caixa.getModelo() +
                    ", Tipo: " + caixa.getTipo() +
                    ", Tamanho: " + caixa.getTamanho() +
                    ", Valor: " + caixa.getValor() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(resultadoTextArea);

        resultadoFrame.add(scrollPane, BorderLayout.CENTER);

        resultadoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultadoFrame.setVisible(true);
    }

    private void limparCampos() {
        modeloField.setText("");
        tipoField.setText("");
        tamanhoField.setText("");
        valorField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceCaixa();
            }
        });
    }
}
