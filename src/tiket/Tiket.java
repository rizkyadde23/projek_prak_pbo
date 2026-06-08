package tiket;

import exceptions.DatabaseException;
import view.login.LoginForm;

public class Tiket {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(
                new Runnable() {
            @Override
            public void run() {
                try {
                    new LoginForm().setVisible(true);
                } catch (DatabaseException ex) {
                    System.getLogger(Tiket.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });
    }

}
