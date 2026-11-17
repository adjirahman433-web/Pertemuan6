import java.awt.*;
import javax.swing.*;

public class Tugas3_DaftarBelanja {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tugas 3 - Daftar Belanja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));

        // Panel Atas: Input dan Tombol Tambah
        JPanel panelAtas = new JPanel(new BorderLayout(5, 5));
        panelAtas.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        
        JTextField txtItem = new JTextField();
        JButton btnTambah = new JButton("Tambah");
        panelAtas.add(txtItem, BorderLayout.CENTER);
        panelAtas.add(btnTambah, BorderLayout.EAST);

        // Panel Tengah: JList dengan DefaultListModel
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listBelanja = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listBelanja);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Panel Bawah: Tombol Hapus Terpilih
        JPanel panelBawah = new JPanel();
        JButton btnHapus = new JButton("Hapus Terpilih");
        panelBawah.add(btnHapus);

        // Event Tambah Item
        btnTambah.addActionListener(e -> {
            String item = txtItem.getText().trim();
            if (!item.isEmpty()) {
                listModel.addElement(item);
                txtItem.setText("");
                txtItem.requestFocus();
            } else {
                JOptionPane.showMessageDialog(frame, "Masukkan nama barang terlebih dahulu!");
            }
        });

        // Event Hapus Item Terpilih
        btnHapus.addActionListener(e -> {
            int selectedIndex = listBelanja.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih item yang ingin dihapus!");
            }
        });

        frame.add(panelAtas, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelBawah, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}