module cf.mindaugas.jfxdemodelete {
    requires java.naming;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens cf.mindaugas.jfxdemodelete to javafx.fxml, org.hibernate.orm.core;
    exports cf.mindaugas.jfxdemodelete;
    exports cf.mindaugas.jfxdemodelete.logic;
    opens cf.mindaugas.jfxdemodelete.logic to javafx.fxml, org.hibernate.orm.core;
    exports cf.mindaugas.jfxdemodelete.data;
    opens cf.mindaugas.jfxdemodelete.data to javafx.fxml, org.hibernate.orm.core;
}