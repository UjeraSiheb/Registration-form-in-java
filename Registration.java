import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Registration extends JFrame implements ActionListener {
    JButton submit;
    JLabel label1, label2, label3, label4, label5;
    JTextField t1, t2;
    JComboBox<String> day, year, month;
    JTextArea ta1, screen;
    JCheckBox terms;
    JRadioButton male, female;
    JLabel msg;

    Registration(){
        setTitle("Registration Form");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        label1 = new JLabel("Name");
        label1.setBounds(20, 50, 100, 20);
        c.add(label1);
        t1 = new JTextField();
        t1.setBounds(130, 50, 100, 20);
        c.add(t1);

        label2 = new JLabel("Mobile");
        label2.setBounds(20, 100, 100, 20);
        c.add(label2);
        t2 = new JTextField();
        t2.setBounds(130, 100, 100, 20);
        c.add(t2);

        label3 = new JLabel("Gender");
        label3.setBounds(20, 150, 100, 20);
        c.add(label3);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(130, 150, 80, 20);
        female.setBounds(220, 150, 80, 20);
        male.setSelected(true);
        c.add(female);
        c.add(male);
        ButtonGroup gender = new ButtonGroup();
        gender.add(female);
        gender.add(male);

        label4 = new JLabel("DOB");
        label4.setBounds(20, 200, 100, 20);
        c.add(label4);

        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        day = new JComboBox<>(days);
        day.setBounds(130, 200, 50, 20);
        c.add(day);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        month = new JComboBox<>(months);
        month.setBounds(190, 200, 80, 20);
        c.add(month);

        String[] years = {"2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003"};
        year = new JComboBox<>(years);
        year.setBounds(280, 200, 60, 20);
        c.add(year);

        label5 = new JLabel("Address");
        label5.setBounds(20, 250, 100, 20);
        ta1 = new JTextArea();
        ta1.setBounds(130, 250, 200, 50);
        c.add(ta1);
        c.add(label5);
        terms = new JCheckBox("Please accept terms and conditions");
        terms.setBounds(50, 300, 250, 20);
        c.add(terms);
        submit = new JButton("Submit");
        submit.setBounds(150, 350, 80, 20);
        c.add(submit);
        screen = new JTextArea();
        screen.setBounds(350, 50, 300, 300);
        c.add(screen);
        msg = new JLabel("");
        msg.setBounds(20, 400, 250, 20);
        c.add(msg);

        submit.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (terms.isSelected()) {
            msg.setText("Registration successful");

            String name = t1.getText();
            String mobile = t2.getText();
            String gender = "Male";
            if (female.isSelected()) {
                gender = "Female";
            }
            String dob = day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
            String address = ta1.getText();

            screen.setText("Name: " + name + "\n" + "Mobile: " + mobile + "\n" + "Gender: " + gender + "\n" + "DOB: " + dob + "\n" + "Address: " + address);

        } else {
            msg.setText("Please accept terms and conditions.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Registration();
        });
    }
}
