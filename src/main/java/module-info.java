module com.example.inventorybonus {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.inventorybonus to javafx.fxml;
    exports com.example.inventorybonus;
}