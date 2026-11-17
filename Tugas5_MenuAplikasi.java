import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Tugas5_MenuAplikasi {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tugas 5 - Aplikasi dengan JMenuBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 180);

        // 1. Membuat Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // 2. Menu File -> Keluar
        JMenu menuFile = new JMenu("File");
        JMenuItem itemKeluar = new JMenuItem("Keluar");
        itemKeluar.addActionListener(e -> System.exit(0));
        menuFile.add(itemKeluar);

        // 3. Menu Bantuan -> Tentang
        JMenu menuBantuan = new JMenu("Bantuan");
        JMenuItem itemTentang = new JMenuItem("Tentang");
        itemTentang.addActionListener(e -> 
            JOptionPane.showMessageDialog(frame, 
                "Aplikasi Jam Digital v1.0\nTugas 2 - Pemrograman 1 (Minggu 6)", 
                "Tentang Aplikasi", 
                JOptionPane.INFORMATION_MESSAGE)
        );
        menuBantuan.add(itemTentang);

        // Menambahkan menu ke MenuBar, lalu memasangnya ke JFrame
        menuBar.add(menuFile);
        menuBar.add(menuBantuan);
        frame.setJMenuBar(menuBar);

        // Isi aplikasi (Jam Digital)
        JLabel lblJam = new JLabel("", SwingConstants.CENTER);
        lblJam.setFont(new Font("Monospaced", Font.BOLD, 36));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblJam.setText(LocalTime.now().format(formatter));

        Timer timer = new Timer(1000, e -> lblJam.setText(LocalTime.now().format(formatter)));
        timer.start();

        frame.add(lblJam);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}