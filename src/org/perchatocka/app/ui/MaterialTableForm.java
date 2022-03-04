package org.perchatocka.app.ui;

import org.perchatocka.app.entity.MaterialEntity;
import org.perchatocka.app.manager.MaterialEntityManager;
import org.perchatocka.app.util.BaseForm;
import org.perchatocka.app.util.CustomTableModel;
import org.perchatocka.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MaterialTableForm extends BaseForm {
    private JTable table;
    private JButton helpButton;
    private JButton askButton;
    private JPanel mainPanel;
    private JLabel title;

    private CustomTableModel<MaterialEntity> model;

    public MaterialTableForm() {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();

        setVisible(true);
    }

    public void initTable() {
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);
        try {
            model = new CustomTableModel<>(
                    MaterialEntity.class,
                    new String[]{"ID", "Название", "Количество в упаковке", "Единиза измерения", "Количество на складе", "Минимальное количество", "Пояснение", "Стоимость", "Путь до картинки", "Тип материала", "Картинка"},
                    MaterialEntityManager.selectAll());
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
        helpButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "В данной таблице вы можете посмотреть список материалов");
        });
        askButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Для связи с разработчиком вы можете написать на почту lalal@mail.ru");
        });
    }
}
