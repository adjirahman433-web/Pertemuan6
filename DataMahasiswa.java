import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataMahasiswa extends JFrame {
    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"NIM","Nama","Prodi","IPK"},0);

    public DataMahasiswa() {
        setTitle("Data Mahasiswa");
        setSize(750,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Data contoh, silakan sesuaikan dengan data tugas sebelumnya.
        model.addRow(new Object[]{"3012610702","Adji Imas Rahman","Informatika",3.75});
        model.addRow(new Object[]{"3012610703","Yuni Thresya Bakara","Informatika",3.75});
        model.addRow(new Object[]{"3012610008","Syaifa Putria Jannati","Informatika",3.60});
        model.addRow(new Object[]{"3012610031","Lia Qurrotul Aini","Informatika",3.60});
        model.addRow(new Object[]{"3012610034","Naura Danadhia Fildzah","Informatika",3.60});

        JTable tabel = new JTable(model);
        tabel.setRowHeight(25);
        tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tabel),BorderLayout.CENTER);

        JButton ubah = new JButton("Ubah Data Terpilih");
        JPanel bawah = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bawah.add(ubah);
        add(bawah,BorderLayout.SOUTH);

        ubah.addActionListener(e -> {
            int baris = tabel.getSelectedRow();
            if(baris==-1) {
                JOptionPane.showMessageDialog(this,"Pilih data mahasiswa terlebih dahulu.");
                return;
            }
            JTextField nim = new JTextField(model.getValueAt(baris,0).toString());
            JTextField nama = new JTextField(model.getValueAt(baris,1).toString());
            JTextField prodi = new JTextField(model.getValueAt(baris,2).toString());
            JTextField ipk = new JTextField(model.getValueAt(baris,3).toString());

            JPanel form = new JPanel(new GridLayout(0,2,8,8));
            form.add(new JLabel("NIM:")); form.add(nim);
            form.add(new JLabel("Nama:")); form.add(nama);
            form.add(new JLabel("Prodi:")); form.add(prodi);
            form.add(new JLabel("IPK:")); form.add(ipk);

            int hasil = JOptionPane.showConfirmDialog(this,form,
                    "Ubah Data Mahasiswa",JOptionPane.OK_CANCEL_OPTION);
            if(hasil==JOptionPane.OK_OPTION) {
                try {
                    double nilai = Double.parseDouble(ipk.getText().trim());
                    if(nim.getText().trim().isEmpty() || nama.getText().trim().isEmpty()
                            || prodi.getText().trim().isEmpty() || nilai<0 || nilai>4)
                        throw new IllegalArgumentException();
                    model.setValueAt(nim.getText().trim(),baris,0);
                    model.setValueAt(nama.getText().trim(),baris,1);
                    model.setValueAt(prodi.getText().trim(),baris,2);
                    model.setValueAt(nilai,baris,3);
                } catch(IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Data tidak valid. IPK harus angka antara 0 sampai 4.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataMahasiswa().setVisible(true));
    }
}