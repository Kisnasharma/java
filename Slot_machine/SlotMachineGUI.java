import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlotMachineGUI extends JFrame {
    private JLabel slot1, slot2, slot3, balanceLabel, resultLabel;
    private JTextField betField;
    private JButton spinButton;
    private double currentBalance = 100.0;
    private String[] symbols = {"🍒", "🍉", "🍊", "🍎", "🍓"};
    private ImageIcon[] icons;

    public SlotMachineGUI() {
        setTitle("Java Slots");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load and resize images
        icons = new ImageIcon[5];
        icons[0] = resizeImage(new ImageIcon("cherry.jpg"), 80, 80); // Resize to 80x80 pixels
        icons[1] = resizeImage(new ImageIcon("watermelon.jpg"), 80, 80);
        icons[2] = resizeImage(new ImageIcon("orange.jpg"), 80, 80);
        icons[3] = resizeImage(new ImageIcon("apple.jpg"), 80, 80);
        icons[4] = resizeImage(new ImageIcon("strawberry.jpg"), 80, 80);

        // Create slots
        JPanel slotsPanel = new JPanel();
        slot1 = new JLabel(icons[0]);
        slot2 = new JLabel(icons[1]);
        slot3 = new JLabel(icons[2]);
        slotsPanel.add(slot1);
        slotsPanel.add(slot2);
        slotsPanel.add(slot3);
        add(slotsPanel, BorderLayout.CENTER);

        // Create control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));

        balanceLabel = new JLabel("Current Balance: $" + currentBalance);
        controlPanel.add(balanceLabel);

        JPanel betPanel = new JPanel();
        betPanel.add(new JLabel("Bet Amount: "));
        betField = new JTextField(10);
        betPanel.add(betField);
        controlPanel.add(betPanel);

        spinButton = new JButton("Spin");
        spinButton.addActionListener(new SpinButtonListener());
        controlPanel.add(spinButton);

        add(controlPanel, BorderLayout.SOUTH);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        add(resultLabel, BorderLayout.NORTH);
    }

    // Helper method to resize images
    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the icon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Return the resized image as an ImageIcon
    }

    private class SpinButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double betAmount = Double.parseDouble(betField.getText());
            if (betAmount > currentBalance || betAmount <= 0) {
                resultLabel.setText("Invalid bet amount!");
                return;
            }

            Random random = new Random();
            int index1 = random.nextInt(5);
            int index2 = random.nextInt(5);
            int index3 = random.nextInt(5);

            slot1.setIcon(icons[index1]);
            slot2.setIcon(icons[index2]);
            slot3.setIcon(icons[index3]);

            int count = 0;
            if (index1 == index2 && index2 == index3) {
                count = 3;
            } else if (index1 == index2 || index1 == index3 || index2 == index3) {
                count = 2;
            }

            if (count == 2) {
                currentBalance += 0.5 * betAmount;
                resultLabel.setText("You won $" + (0.5 * betAmount));
            } else if (count == 3) {
                currentBalance += betAmount;
                resultLabel.setText("You won $" + betAmount);
            } else {
                currentBalance -= betAmount;
                resultLabel.setText("Sorry, you lost this round.");
            }

            balanceLabel.setText("Current Balance: $" + currentBalance);

            if (currentBalance <= 0) {
                resultLabel.setText("Game Over! Your balance is $0.");
                spinButton.setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SlotMachineGUI frame = new SlotMachineGUI();
            frame.setVisible(true);
        });
    }
}