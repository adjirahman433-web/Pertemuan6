import java.awt.*;
import javax.swing.*;

public class Tugas2_Login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tugas 2 - Form Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Jarak antar komponen

        // Label & Input Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField txtUsername = new JTextField(15);
        panel.add(txtUsername, gbc);

        // Label & Input Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPasswordField txtPassword = new JPasswordField(15);
        panel.add(txtPassword, gbc);

        // Tombol Masuk
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        JButton btnMasuk = new JButton("Masuk");
        panel.add(btnMasuk, gbc);

        // Validasi input kosong
        btnMasuk.addActionListener(e -> {
            String user = txtUsername.getText().trim();
            String pass = new String(txtPassword.getPassword()).trim();

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "Username dan Password tidak boleh kosong!", 
                    "Peringatan", 
                    JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, 
                    "Selamat datang, " + user + "!", 
                    "Login Berhasil", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}