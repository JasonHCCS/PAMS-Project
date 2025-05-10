import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AppointmentBST {

    DateFormat dateFormat = new SimpleDateFormat("hh:mm");

    private AppointmentNode root;

    public AppointmentBST() {
        root = null;
    }

    public void addAppointment(PatientAppointment appointment) {
        root = insertRec(root, appointment);
    }

    private AppointmentNode insertRec(AppointmentNode root, PatientAppointment appointment) {
        // TODO: Implement logic to insert by appointment time (avoid duplicates)
        if(root == null) {
            return new AppointmentNode(appointment);
        }

        try{
            Date rootDate = dateFormat.parse(root.data.appointmentTime);
            Date newDate = dateFormat.parse(appointment.appointmentTime);

            if(rootDate == newDate){
                return root;
            }
            if (newDate.compareTo(rootDate) < 0){
                root.left = insertRec(root.left, appointment);
            }
            else {
                root.right = insertRec(root.right, appointment);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return root;
    }

    public void inOrderTraversal(AppointmentNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public AppointmentNode getRoot() {
        return root;
    }
}
