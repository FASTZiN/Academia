import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class GUIAjuda extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JList list1;
    private JButton OKButton;
    private Agachamento agachamento = new Agachamento();

    public GUIAjuda() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(OKButton);
        OKButton.setEnabled(false);

        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list1.getSelectedIndex() == -1) {
                    //No selection, disable fire button.
                    OKButton.setEnabled(false);

                } else {
                    //Selection, enable the fire button.
                    OKButton.setEnabled(true);
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        if(list1.getSelectedValue().equals("Agachamento")){
            agachamento.main(null);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {

        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }

        GUIAjuda dialog = new GUIAjuda();
        dialog.pack();
        dialog.setVisible(true);
    }
}
