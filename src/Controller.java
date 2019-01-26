
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Broutade-W
 */
public class Controller {

    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void modifyFile() {
        File file = view.chooseFile();
        try {
            RWCSVFile.createNewCSV(file);
            view.showSuccessRWCSV(file.getName());
        } catch(IOException e) {
            System.out.println("Erreur");
        }
    }

    void initialize(View view) {
        view.showFileChooserButton();
    }

}
