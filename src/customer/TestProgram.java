package customer;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;

public class TestProgram {

    public static JCheckBox[] checkList = new JCheckBox[10];

    public static void main(String[] args) {

        Listener listener = new Listener();

        for (int i = 0; i < 10; ++i) {
            checkList[i] = new JCheckBox("CheckBox-" + i);
            checkList[i].addItemListener((ItemListener) listener);
        }

        //
        // The rest of the GUI layout job ...
        //
    }

    static class Listener implements ItemListener {

        private final int MAX_SELECTIONS = 3;

        private int selectionCounter = 0;

      
        public void itemStateChanged(ItemEvent e) {
            JCheckBox source = (JCheckBox) e.getSource();

            if (source.isSelected()) {
                selectionCounter++;
                // check for max selections:
                if (selectionCounter == MAX_SELECTIONS)
                    for (JCheckBox box: checkList)
                        if (!box.isSelected())
                            box.setEnabled(false);
            }
            else {
                selectionCounter--;
                // check for less than max selections:
                if (selectionCounter < MAX_SELECTIONS)
                    for (JCheckBox box: checkList)
                        box.setEnabled(true);
            }
        }
    }
}
