import java.awt.*;
import javax.swing.*;

public class Tugas1_Layout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tugas 1 - FlowLayout ke GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // Panel utama menggunakan FlowLayout terlebih dahulu
        JPanel panel = new JPanel(new FlowLayout());

        JButton btn1 = new JButton("Tombol 1");
        JButton btn2 = new JButton("Tombol 2");
        JButton btn3 = new JButton("Ubah ke GridLayout");

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        // Aksi untuk mengubah layout dari FlowLayout ke GridLayout (1 baris, 3 kolom)
        btn3.addActionListener(e -> {
            panel.setLayout(new GridLayout(1, 3, 5, 5));
            btn3.setText("GridLayout 1x3");
            panel.revalidate(); // Memperbarui tata letak komponen
            panel.repaint();
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}