package hotel.management.system;

import javax.swing.*;
import java.util.*;

public class ValidityCheck {
    public static void validateFields(JTextField tfname, JTextField tfage, JRadioButton rbmale, JRadioButton rbfemale, JTextField tfsalary, JTextField tfphone, JTextField tfemail, JTextField tfnid) throws ValidationException {
        StringBuilder missingFields = new StringBuilder();
        StringBuilder errors = new StringBuilder();
        if (tfname.getText().isEmpty()) {
            missingFields.append("Name, ");
        }
        if (tfage.getText().isEmpty() || !tfage.getText().matches("\\d+")) {
            missingFields.append("Age, ");
        }
        if (!(rbmale.isSelected() || rbfemale.isSelected())) {
            missingFields.append("Gender, ");
        }
//        if (cbjob.getSelectedItem() == null || cbjob.getSelectedItem().toString().isEmpty()) {
//            missingFields.append("Shift, ");
//        }
        if (tfsalary.getText().isEmpty() || !tfsalary.getText().matches("\\d+")) {
            missingFields.append("Salary, ");
        }
        if (tfphone.getText().isEmpty()) {
            missingFields.append("Phone, ");
        }

        if (tfnid.getText().isEmpty()) {
            missingFields.append("NID, ");
        }
        /*
        if (!tfemail.getText().isEmpty() && !tfemail.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"))
            errors.append("Email format incorrect, ");
    */
        if (!tfemail.getText().isEmpty() &&
                !tfemail.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$")) {
            errors.append("Email format incorrect, ");
        }

        if (!tfnid.getText().isEmpty() && !tfnid.getText().matches("\\d{11}"))
            errors.append("NID must be 11 digits, ");

        if (!tfphone.getText().isEmpty() && !tfphone.getText().matches("\\d{11}"))
            errors.append("Phone number must be 11 digits, ");

        // Remove trailing comma and space, throw exception if errors exist
        if (!errors.isEmpty()) {
            errors.delete(errors.length() - 2, errors.length());
            throw new ValidationException("Please correct the following fields: " + errors.toString());
        }

        if (!missingFields.isEmpty()) {
            missingFields.delete(missingFields.length() - 2, missingFields.length());
            throw new ValidationException("The following fields must be filled properly: " + missingFields.toString());
        }
    }
}