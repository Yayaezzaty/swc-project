import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Receipt extends JFrame implements ActionListener {
    private String bookingType;
    private String day;
    private String date;
    private String time;
    private int adultQty;
    private int childrenQty;
    private double depositAmount = 0.00;

    public Receipt(String selectedBookingType, String selectedDay, String selectedDate, String selectedTime, int adultQty, int childrenQty, double depositAmount) {
        this.bookingType = selectedBookingType;
        this.day = selectedDay;
        this.date = selectedDate;
        this.time = selectedTime;
        this.adultQty = adultQty;
        this.childrenQty = childrenQty;
        this.depositAmount = depositAmount;

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        receiptTextArea.setFont(new Font("Calibri", Font.BOLD, 17));
        receiptTextArea.setText("\n" + 
                " Booking Type  : " + selectedBookingType + "\n\n" +
                " Day                   : " + selectedDay + "\n\n" +
                " Date                 : " + selectedDate + "\n\n" +
                " Time                 : " + selectedTime + "\n\n" +
                " Adults               : " + adultQty + "\n\n" +
                " Children            : " + childrenQty + "\n\n" +
                " Deposit             : RM" + depositAmount + "\n\n\n" +
                " Thank you for booking with PURNAMA PALACE DINE & TEA!"
        );

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        scrollPane.setPreferredSize(new Dimension(500, 500));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(closeButton, BorderLayout.SOUTH);

        setTitle("Booking Receipt");
        setSize(550, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
        System.exit(0);
    }
}