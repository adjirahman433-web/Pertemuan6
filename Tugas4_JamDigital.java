import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Tugas4_JamDigital {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tugas 4 - Jam Digital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JLabel lblJam = new JLabel("", SwingConstants.CENTER);
        lblJam.setFont(new Font("Monospaced", Font.BOLD, 36));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        // Set waktu awal langsung saat jendela terbuka
        lblJam.setText(LocalTime.now().format(formatter));

        // Timer berdetak setiap 1000 ms (1 detik)
        Timer timer = new Timer(1000, e -> {
            lblJam.setText(LocalTime.now().format(formatter));
        });
        timer.start();

        frame.add(lblJam);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
