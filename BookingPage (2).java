import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BookingPage implements ActionListener {
    private JFrame frame;
    private JComboBox<String> bookingTypesBox, daysBox, datesBox, timeBox;
    private JTextField adultsField, childrenField, depositField;
    private JButton btnNext;
    private String time = "";

    public BookingPage() {
        String[] bookingTypes = {"Dinner", "High-Tea"};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] dates = {"April 27, 2024", "April 28, 2024", "April 29, 2024", "May 3, 2024", "May 4, 2024", "May 5, 2024"}; // Sample dates
        String[] dinnerTimes = {"7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM"};
        String[] highTeaTimes = {"3:00 PM", "4:00 PM", "5:00 PM"};

        bookingTypesBox = new JComboBox<>(bookingTypes);
        daysBox = new JComboBox<>(days);
        datesBox = new JComboBox<>(dates);
        timeBox = new JComboBox<>();

        JScrollPane scrollPane = new JScrollPane(frame);
        scrollPane.setPreferredSize(new Dimension(500, 800));
        
        JPanel panelBookingTypes = new JPanel();
        panelBookingTypes.setLayout(new GridLayout(1, 0));
        panelBookingTypes.setBorder(BorderFactory.createTitledBorder("Select Booking Type"));
        panelBookingTypes.add(bookingTypesBox);

        JPanel panelDay = new JPanel();
        panelDay.setLayout(new GridLayout(1, 0));
        panelDay.setBorder(BorderFactory.createTitledBorder("Choose Day"));
        panelDay.add(daysBox);

        JPanel panelDates = new JPanel();
        panelDates.setLayout(new GridLayout(1, 0));
        panelDates.setBorder(BorderFactory.createTitledBorder("Choose Date"));
        panelDates.add(datesBox);

        JPanel panelTime = new JPanel();
        panelTime.setLayout(new GridLayout(1, 0));
        panelTime.setBorder(BorderFactory.createTitledBorder("Choose Time"));
        panelTime.add(timeBox);

        JPanel panelReservation = new JPanel();
        panelReservation.setLayout(new GridLayout(3, 2));
        panelReservation.setBorder(BorderFactory.createTitledBorder("Enter Amount of People & Deposit (RM30 for Booking Fee)"));
        JLabel adultsLabel = new JLabel("Number of Adults:");
        adultsField = new JTextField();
        JLabel childrenLabel = new JLabel("Number of Children:");
        childrenField = new JTextField();
        JLabel depositLabel = new JLabel("Deposit (RM):");
        depositField = new JTextField();
        panelReservation.add(adultsLabel);
        panelReservation.add(adultsField);
        panelReservation.add(childrenLabel);
        panelReservation.add(childrenField);
        panelReservation.add(depositLabel);
        panelReservation.add(depositField);

        btnNext = new JButton("NEXT");
        btnNext.setPreferredSize(new Dimension(200, 30)); 

        JPanel panelButton = new JPanel();
        panelButton.add(btnNext);
        
        frame = new JFrame();
        frame.setFont(new Font("Calibri", Font.PLAIN, 26));
        frame.setTitle("Booking Page");
        frame.setSize(540, 490);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panelBookingTypes);
        frame.add(panelDay);
        frame.add(panelDates);
        frame.add(panelTime);
        frame.add(panelReservation);
        frame.add(panelButton); // Added button panel to the frame

        bookingTypesBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedBookingType = (String) bookingTypesBox.getSelectedItem();
                timeBox.removeAllItems();
                if (selectedBookingType.equals("Dinner")) {
                    for (String time : dinnerTimes) {
                        timeBox.addItem(time);
                    }
                } else if (selectedBookingType.equals("High-Tea")) {
                    for (String time : highTeaTimes) {
                        timeBox.addItem(time);
                    }
                }
            }
        });

        btnNext.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            // Validation
            if (adultsField.getText().isEmpty() || childrenField.getText().isEmpty() || depositField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Parse input
            String selectedBookingType = (String) bookingTypesBox.getSelectedItem();
            String selectedDay = (String) daysBox.getSelectedItem();
            String selectedDate = (String) datesBox.getSelectedItem();
            String selectedTime = (String) timeBox.getSelectedItem();
            int adultQty = Integer.parseInt(adultsField.getText());
            int childrenQty = Integer.parseInt(childrenField.getText());
            double depositAmount = 0.00;
            try {
                depositAmount = Double.parseDouble(depositField.getText());
                if (depositAmount < 30) {
                    JOptionPane.showMessageDialog(frame, "Deposit must be RM30.", "Invalid Deposit", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid deposit amount.", "Invalid Deposit", JOptionPane.ERROR_MESSAGE);
                return;
            }
            frame.dispose();
            new Receipt(selectedBookingType, selectedDay, selectedDate, selectedTime, adultQty, childrenQty, depositAmount);
        }
    }

    public static void main(String[] args) {
        new BookingPage();
    }
}
