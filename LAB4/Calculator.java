import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.text.MessageFormat;

import org.mariuszgromada.math.mxparser.*;

import static java.awt.event.KeyEvent.VK_RIGHT;
import static javax.swing.JFrame.*;

public class Calculator extends JFrame implements ActionListener, KeyListener, CaretListener {

    JMenuItem Exit;
    JMenuItem Reset;
    JTextArea textArea;
    JTextField textField;
    JButton button;
    String lastText;
    public double result = 0;
    JScrollPane scroll;
    DefaultListModel<MathFunctions> Function;
    JList list;


    public Calculator() {


        super("Calculator");
        JPanel mainPanel = createMainPanel();
        add(mainPanel);

        JPanel listPanel = createListPanel();
        add(listPanel, BorderLayout.EAST);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createMainPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Main Panel"));

        /************************MENU BAR Z MENU ITEMS*************************/
        JMenu menu = new JMenu("Options");
        JMenuBar menubar = new JMenuBar();
        menubar.add(menu);
        panel.add(menubar);


        Reset = new JMenuItem("Reset");
        Reset.addActionListener(this);
        menu.add(Reset);

        Exit = new JMenuItem("Exit");
        Exit.addActionListener(this);
        menu.add(Exit);


        /************************TEXT AREA*************************/
        textArea = new JTextArea();
        textArea.setEditable(false); //read-only
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(textArea);


        /************************SCROLLER *************************/
        JScrollPane scroller = new JScrollPane(textArea);
        JScrollBar bar = new JScrollBar();
        scroller.add(bar);
        panel.add(scroller, BorderLayout.EAST);


        /************************TEXT FIELD*************************/
        textField = new JTextField();
        textField.addActionListener(this);
        textField.addKeyListener(this);

        panel.add(new JLabel("Enter your formula", JLabel.LEFT));
        panel.add(textField);

        return panel;
    }

    private JPanel createListPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Functions"));

        DefaultListModel<MathFunctions> Function = createListofFunction();
        MathFunctions last = new MathFunctions("Last result", Double.toString(result));
        Function.addElement(last);


        //list = new JList(Function);
        JList<MathFunctions> list = new JList<>(Function);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //textField.addCaretListener(this);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedItem = list.getSelectedIndex();
                    switch (selectedItem) {
                        case 0:
                            textField.setText(textField.getText()+"sin()");
                            textField.requestFocus();
                            textField.setCaretPosition(textField.getCaretPosition() - 1);
                            break;
                        case 1:
                            textField.setText(textField.getText()+"cos()");
                            textField.requestFocus();
                            textField.setCaretPosition(textField.getCaretPosition() - 1);
                            break;
                        case 2:
                            textField.setText(textField.getText()+"tg()");
                            textField.requestFocus();
                            textField.setCaretPosition(textField.getCaretPosition() - 1);
                            break;
                        case 3:
                            textField.setText(textField.getText()+"ctg()");
                            textField.requestFocus();
                            textField.setCaretPosition(textField.getCaretPosition() - 1);
                            break;
                        case 4:
                            textField.setText(textField.getText()+"log10()");
                            textField.requestFocus();
                            textField.setCaretPosition(textField.getCaretPosition() - 1);
                            break;
                        case 5:
                            textField.setText(textField.getText()+"pi");
                            break;
                        case 6:
                            textField.setText(textField.getText()+"e");
                            break;
                        case 7:
                            textField.setText(textField.getText()+"[phi]");
                            break;
                        case 8:
                            textField.setText(textField.getText()+"+");
                            break;
                        case 9:
                            textField.setText(textField.getText()+"-");
                            break;
                        case 10:
                            textField.setText(textField.getText()+"*");
                            break;
                        case 11:
                            textField.setText(textField.getText()+Double.toString(result));
                            break;


                    }
                }
            }

        };
        list.addMouseListener(mouseListener);

        //list.addListSelectionListener(ListSelectionListener());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        panel.add(list, c);
        //panel.a(mathFunction);

        /************************ BUTTON *************************/
        button = new JButton("Evaluate");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 0.5;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        panel.add(button, c);
        //panel.add(button);
        button.setSize(10, 10);
        button.addActionListener(this);
        return panel;
    }

    private void setAction() {
        Reset.addActionListener(this);
        Exit.addActionListener(this);

    }

    public void keyPressed(KeyEvent ke) {
        /************************ ARROW UP *************************/
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            textField.setText(lastText);
        }
    }


    public void actionPerformed(ActionEvent eve) {
        /************************ ACTIONS *************************/
        if (eve.getSource() == Reset) {
            textArea.setText(null);
            textField.setText(null);
        } else if (eve.getSource() == Exit) {
            System.exit(1);
        } else if (eve.getSource() == textField || eve.getSource() == button) {
            String text = textField.getText();
            lastText = text;
            Expression expression = new Expression(text);
            if (expression.checkSyntax()) {
                result = expression.calculate();
                MessageFormat form = new MessageFormat(text +
                        " = " + result + "\n");

                textArea.append(form.toPattern());
            } else {
                JOptionPane.showMessageDialog(null, "WRONG FORMULA",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            textField.setText(null);
        } else {
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        /*int c =evt.getKeyCode();
        JOptionPane.showMessageDialog(null,"Nacisnąłeś: "+c);*/
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }

    public void caretUpdate(CaretEvent e) {
        int index = e.getDot();

    }


    javax.swing.DefaultListModel
            <MathFunctions> createListofFunction() {
        MathFunctions sinus = new MathFunctions("sinus", "sin()");
        MathFunctions cosinus = new MathFunctions("cosinus", "cos()");
        MathFunctions tangens = new MathFunctions("tangens", "tg()");
        MathFunctions cotangens = new MathFunctions("cotangens", "ctg()");
        MathFunctions log10 = new MathFunctions("log10", "log10()");
        MathFunctions pi = new MathFunctions("pi", "pi");
        MathFunctions euler = new MathFunctions("Euler's number", "e");
        MathFunctions phi = new MathFunctions("golden ratio", "[phi]");
        MathFunctions plus = new MathFunctions("plus", "+");
        MathFunctions minus = new MathFunctions("minus", "-");
        MathFunctions multi = new MathFunctions("multiplication", "*");
        Function = new DefaultListModel<>();
        Function.addElement(sinus);
        Function.addElement(cosinus);
        Function.addElement(tangens);
        Function.addElement(cotangens);
        Function.addElement(log10);
        Function.addElement(pi);
        Function.addElement(euler);
        Function.addElement(phi);
        Function.addElement(plus);
        Function.addElement(minus);
        Function.addElement(multi);
        return Function;
    }


}
