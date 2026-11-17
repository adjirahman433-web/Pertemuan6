import javax.swing.*;
import java.awt.*;

public class FormRegistrasi extends JFrame {
    public FormRegistrasi() {
        setTitle("Form Registrasi");
        setSize(500, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(7, 7, 7, 7);
        g.fill = GridBagConstraints.HORIZONTAL;

        JTextField nama = new JTextField(22), email = new JTextField(22);
        JPasswordField sandi = new JPasswordField(22);
        JRadioButton laki = new JRadioButton("Laki-laki");
        JRadioButton perempuan = new JRadioButton("Perempuan");
        ButtonGroup bg = new ButtonGroup(); bg.add(laki); bg.add(perempuan);
        JPanel gender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        gender.add(laki); gender.add(perempuan);

        JComboBox<String> prodi = new JComboBox<>(new String[]{
            "Pilih Prodi", "Informatika", "Manajemen", "Desain Komunikasi Visual"
        });
        JCheckBox coding = new JCheckBox("Coding"), membaca = new JCheckBox("Membaca"),
                olahraga = new JCheckBox("Olahraga"), musik = new JCheckBox("Musik");
        JPanel hobi = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hobi.add(coding); hobi.add(membaca); hobi.add(olahraga); hobi.add(musik);

        tambah(panel,g,0,"Nama",nama); tambah(panel,g,1,"Email",email);
        tambah(panel,g,2,"Sandi",sandi); tambah(panel,g,3,"Gender",gender);
        tambah(panel,g,4,"Prodi",prodi); tambah(panel,g,5,"Hobi",hobi);

        JButton daftar = new JButton("Daftar");
        g.gridx=1; g.gridy=6; panel.add(daftar,g);
        daftar.addActionListener(e -> {
            if (nama.getText().trim().isEmpty() || email.getText().trim().isEmpty()
                    || sandi.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this,"Nama, email, dan sandi wajib diisi.");
                return;
            }
            String jk = laki.isSelected() ? "Laki-laki" :
                    perempuan.isSelected() ? "Perempuan" : "Belum dipilih";
            StringBuilder hb = new StringBuilder();
            if(coding.isSelected()) hb.append("Coding, ");
            if(membaca.isSelected()) hb.append("Membaca, ");
            if(olahraga.isSelected()) hb.append("Olahraga, ");
            if(musik.isSelected()) hb.append("Musik, ");
            if(hb.length()>0) hb.setLength(hb.length()-2); else hb.append("Tidak ada");

            String ringkasan = "RINGKASAN REGISTRASI\\n\\nNama: " + nama.getText()
                    + "\\nEmail: " + email.getText() + "\\nGender: " + jk
                    + "\\nProdi: " + prodi.getSelectedItem() + "\\nHobi: " + hb;
            JOptionPane.showMessageDialog(this,ringkasan,"Data Registrasi",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        add(panel);
    }

    private void tambah(JPanel p, GridBagConstraints g, int y,
                        String label, JComponent komponen) {
        g.gridx=0; g.gridy=y; p.add(new JLabel(label + ":"),g);
        g.gridx=1; p.add(komponen,g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormRegistrasi().setVisible(true));
    }
}