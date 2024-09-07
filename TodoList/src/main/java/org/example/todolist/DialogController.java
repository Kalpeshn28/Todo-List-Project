package org.example.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.todolist.datamodel.TodoData;
import org.example.todolist.datamodel.TodoItem;

import java.time.LocalDate;


public class DialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
    public void modifyItemDetails(TodoItem item)
    {
        item.setShortDescription(shortDescriptionField.getText());
        item.setDetails(detailsArea.getText());
        item.setDeadline(deadlinePicker.getValue());
    }

    public void adoptItemDetails(TodoItem edited)
    {
        shortDescriptionField.setText(edited.getShortDescription());
        detailsArea.setText(edited.getDetails());
        deadlinePicker.setValue(edited.getDeadline());
    }
}
