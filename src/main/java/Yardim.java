
package javaprojeodevi.Yardim;

import javax.swing.JOptionPane;


public class Yardim {
    public static void showMsg(String str){
        String msg;
        switch(str){
            case "fill":
            msg="Lutfen tum alanlari doldurun...";
            break;
            default:
                msg=str;
    }
        JOptionPane.showMessageDialog(null,msg,"Mesaj",JOptionPane.INFORMATION_MESSAGE);
        }
}
