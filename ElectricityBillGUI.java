import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ElectricityBillGUI extends JFrame implements ActionListener {
    // Declare GUI components
    private JTextField nameField, idField, unitsField;
    private JTextArea outputArea;
    private JButton calculateButton;

    // Constructor to setup the GUI
    public ElectricityBillGUI() {
        // Set up the JFrame
        setTitle("Electricity Billing System");
        setSize(1350, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 20, 20)); // 6 rows, 2 columns, 10px gap

        // Create and add components
        add(new JLabel("Customer Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Customer ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Units Consumed:"));
        unitsField = new JTextField();
        add(unitsField);

        // Button to calculate bill
        calculateButton = new JButton("Calculate Bill");
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Output area to display the bill details (with better styling)
        outputArea = new JTextArea(15, 20);
        outputArea.setEditable(true);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));  // Use monospaced font
        outputArea.setForeground(Color.black);  // Set text color to blue
        outputArea.setMargin(new Insets(10, 10, 10, 10));  // Add padding
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));  // Add border
        JScrollPane scrollPane = new JScrollPane(outputArea);  // Make it scrollable
        add(scrollPane);

        // Set visibility and layout
        setVisible(true);
    }

    // Action listener method that performs the bill calculation
    @Override
    public void actionPerformed(ActionEvent e) {
        // Fetch input values
        String customerName = nameField.getText();
        int customerID = Integer.parseInt(idField.getText());
        int unitsConsumed = Integer.parseInt(unitsField.getText());

        // Calculate the bill
        double billAmount = calculateBill(unitsConsumed);

        // Display the bill details in the output area
        outputArea.setText("");  // Clear the previous output
        outputArea.append("======= Electricity Bill =======\n");
        outputArea.append(String.format("%-20s : %s\n", "Customer Name", customerName));
        outputArea.append(String.format("%-20s : %d\n", "Customer ID", customerID));
        outputArea.append(String.format("%-20s : %d\n", "Units Consumed", unitsConsumed));
        outputArea.append(String.format("%-20s : Rs %.2f\n", "Total Bill Amount", billAmount));
        outputArea.append("================================\n");
    }

    // Method to calculate the bill based on the units consumed
    private double calculateBill(int unitsConsumed) {
        double ratePerUnit;

        if (unitsConsumed <= 100) {
            ratePerUnit = 1.5;
        } else if (unitsConsumed <= 300) {
            ratePerUnit = 2.0;
        } else {
            ratePerUnit = 3.0;
        }

        return unitsConsumed * ratePerUnit;
    }

    // Main method to run the GUI application
    public static void main(String[] args) {
        new ElectricityBillGUI();
    }
}
