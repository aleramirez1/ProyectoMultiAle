module com.ale.vererinaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.display;


    opens com.ale.application to javafx.fxml;
    exports com.ale.application;
    exports com.ale.application.controllers;
    opens com.ale.application.controllers to javafx.fxml;
}