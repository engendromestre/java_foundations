import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String n1String = JOptionPane.showInputDialog("Digite o primeiro número");
        String n2String = JOptionPane.showInputDialog("Digite o segundo número");
        double n1 = Double.parseDouble(n1String);
        double n2 = Double.parseDouble(n2String);
        
        Calculo c1 = new Calculo();
        c1.setN1(n1);
        c1.setN2(n2);

        c1.visualizar("+");
    }
}
