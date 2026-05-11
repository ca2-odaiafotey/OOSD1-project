package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShopGUI extends JFrame {
    private ArrayList<StockItem> stockList;
    private JTextArea displayArea;
    private JTextField codeField, qtyField, priceField, addQtyField, sellQtyField, newPriceField;
    private JComboBox<String> typeBox;
    private JComboBox<String> itemSelectBox;

    public ShopGUI() {
        stockList = new ArrayList<>();
        setTitle("Car Parts and Accessories Shop");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel - Add Item
        JPanel topPanel = new JPanel(new GridLayout(2, 5));
        topPanel.setBorder(BorderFactory.createTitledBorder("Add New Stock Item"));
        
        topPanel.add(new JLabel("Type:"));
        typeBox = new JComboBox<>(new String[]{"StockItem", "NavSys", "DashCam", "CarMats", "AirFreshener"});
        topPanel.add(typeBox);
        
        topPanel.add(new JLabel("Code:"));
        codeField = new JTextField();
        topPanel.add(codeField);
        
        topPanel.add(new JLabel("Qty:"));
        qtyField = new JTextField();
        topPanel.add(qtyField);
        
        topPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        topPanel.add(priceField);
        
        JButton addButton = new JButton("Create Item");
        topPanel.add(addButton);
        
        add(topPanel, BorderLayout.NORTH);

        // Center Panel - Display
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Stock Information"));
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel - Actions
        JPanel bottomPanel = new JPanel(new GridLayout(3, 3));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Manage Selected Item"));
        
        bottomPanel.add(new JLabel("Select Item:"));
        itemSelectBox = new JComboBox<>();
        bottomPanel.add(itemSelectBox);
        
        JButton refreshButton = new JButton("Refresh Info");
        bottomPanel.add(refreshButton);
        
        bottomPanel.add(new JLabel("Add Stock Qty:"));
        addQtyField = new JTextField();
        bottomPanel.add(addQtyField);
        
        JButton addStockBtn = new JButton("Add Stock");
        bottomPanel.add(addStockBtn);
        
        bottomPanel.add(new JLabel("Sell Stock Qty:"));
        sellQtyField = new JTextField();
        bottomPanel.add(sellQtyField);
        
        JButton sellStockBtn = new JButton("Sell Stock");
        bottomPanel.add(sellStockBtn);
        
        bottomPanel.add(new JLabel("New Price:"));
        newPriceField = new JTextField();
        bottomPanel.add(newPriceField);
        
        JButton changePriceBtn = new JButton("Change Price");
        bottomPanel.add(changePriceBtn);
        
        add(bottomPanel, BorderLayout.SOUTH);

        // Event Listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String type = (String) typeBox.getSelectedItem();
                    String code = codeField.getText();
                    int qty = Integer.parseInt(qtyField.getText());
                    double price = Double.parseDouble(priceField.getText());
                    
                    StockItem item = null;
                    if (type.equals("StockItem")) {
                        item = new StockItem(qty, price, code);
                    } else if (type.equals("NavSys")) {
                        item = new NavSys(qty, price, code);
                    } else if (type.equals("DashCam")) {
                        item = new DashCam(qty, price, code, "1080p");
                    } else if (type.equals("CarMats")) {
                        item = new CarMats(qty, price, code, "Black");
                    } else if (type.equals("AirFreshener")) {
                        item = new AirFreshener(qty, price, code, "Pine");
                    }
                    
                    if (item != null) {
                        stockList.add(item);
                        updateItemSelectBox();
                        displayArea.setText("Item created!\n" + item.toString());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers for Qty and Price.");
                }
            }
        });

        refreshButton.addActionListener(e -> {
            StockItem item = getSelectedItem();
            if (item != null) {
                displayArea.setText(item.toString());
            }
        });

        addStockBtn.addActionListener(e -> {
            StockItem item = getSelectedItem();
            if (item != null) {
                try {
                    int amt = Integer.parseInt(addQtyField.getText());
                    item.addStock(amt);
                    displayArea.setText("Stock added (check console for errors).\n" + item.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount");
                }
            }
        });

        sellStockBtn.addActionListener(e -> {
            StockItem item = getSelectedItem();
            if (item != null) {
                try {
                    int amt = Integer.parseInt(sellQtyField.getText());
                    boolean success = item.sellStock(amt);
                    if (success) {
                        displayArea.setText("Stock sold successfully.\n" + item.toString());
                    } else {
                        displayArea.setText("Failed to sell stock (check console for errors).\n" + item.toString());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount");
                }
            }
        });

        changePriceBtn.addActionListener(e -> {
            StockItem item = getSelectedItem();
            if (item != null) {
                try {
                    double price = Double.parseDouble(newPriceField.getText());
                    item.setPrice(price);
                    displayArea.setText("Price changed.\n" + item.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid price");
                }
            }
        });
    }

    private void updateItemSelectBox() {
        itemSelectBox.removeAllItems();
        for (StockItem item : stockList) {
            itemSelectBox.addItem(item.getStockCode());
        }
    }

    private StockItem getSelectedItem() {
        int idx = itemSelectBox.getSelectedIndex();
        if (idx >= 0 && idx < stockList.size()) {
            return stockList.get(idx);
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShopGUI().setVisible(true);
        });
    }
}
