package tiket;
import view.login.LoginForm;

public class Tiket {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(
                new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    
}
