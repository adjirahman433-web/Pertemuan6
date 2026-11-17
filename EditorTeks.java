import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class EditorTeks extends JFrame {
    private final JTextArea area = new JTextArea();

    public EditorTeks() {
        setTitle("Editor Teks");
        setSize(800,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        area.setFont(new Font(Font.MONOSPACED,Font.PLAIN,14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        add(new JScrollPane(area),BorderLayout.CENTER);
        setJMenuBar(menuFileEdit());

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        tombol(toolbar,"Baru",() -> area.setText(""));
        tombol(toolbar,"Buka",() -> buka());
        tombol(toolbar,"Simpan",() -> simpan());
        toolbar.addSeparator();
        tombol(toolbar,"Potong",() -> area.cut());
        tombol(toolbar,"Salin",() -> area.copy());
        tombol(toolbar,"Tempel",() -> area.paste());
        add(toolbar,BorderLayout.NORTH);
    }

    private void tombol(JToolBar bar,String nama,Runnable aksi) {
        JButton b = new JButton(nama);
        b.addActionListener(e -> aksi.run());
        bar.add(b);
    }

    private JMenuBar menuFileEdit() {
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File"), edit = new JMenu("Edit");
        item(file,"Baru",() -> area.setText(""));
        item(file,"Buka",() -> buka());
        item(file,"Simpan",() -> simpan());
        file.addSeparator();
        item(file,"Keluar",() -> dispose());
        item(edit,"Potong",() -> area.cut());
        item(edit,"Salin",() -> area.copy());
        item(edit,"Tempel",() -> area.paste());
        mb.add(file); mb.add(edit);
        return mb;
    }

    private void item(JMenu menu,String nama,Runnable aksi) {
        JMenuItem i = new JMenuItem(nama);
        i.addActionListener(e -> aksi.run());
        menu.add(i);
    }

    private void buka() {
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            try {
                area.setText(Files.readString(f.toPath(),StandardCharsets.UTF_8));
            } catch(IOException ex) {
                JOptionPane.showMessageDialog(this,"Gagal membuka: "+ex.getMessage());
            }
        }
    }

    private void simpan() {
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            try {
                Files.writeString(f.toPath(),area.getText(),StandardCharsets.UTF_8);
                JOptionPane.showMessageDialog(this,"File berhasil disimpan.");
            } catch(IOException ex) {
                JOptionPane.showMessageDialog(this,"Gagal menyimpan: "+ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EditorTeks().setVisible(true));
    }
}