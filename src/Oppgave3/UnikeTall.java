package Oppgave3;

import javax.swing.*;

public class UnikeTall {
    private int[] tilfeldigeHeltall;

    public UnikeTall(int listeLengde) {
        tilfeldigeHeltall = new int[listeLengde];
    }

    private boolean tallEksisterer(int tall) {
        boolean sjekk = false;
        for (int i = 0;i< tilfeldigeHeltall.length;i++) {
            if (tall == tilfeldigeHeltall[i]) {
                sjekk = true;
                break;
            }
        }
      return sjekk;
    }

    public void fyllListe() {
        for (int i = 0;i<tilfeldigeHeltall.length;i++) {
            int trektTall = (int) (Math.random() * (900) + 100);
            while (tallEksisterer(trektTall)) {
                trektTall = (int) (Math.random() * (900) + 100);
            }
            tilfeldigeHeltall[i] = trektTall;
        }
    }

    private int minsteTall() {
        int minste = tilfeldigeHeltall[0];
        for (int i : tilfeldigeHeltall) {
            if(i<minste){
                minste = i;
            }
        }
        return minste;
    }

    private int storsteTall() {
        int storste = tilfeldigeHeltall[0];
        for (int i : tilfeldigeHeltall) {
            if(i>storste){
                storste = i;
            }
        }
        return storste;
    }

    private double beregnGjennomsnitt() {
        double totalsum = 0;
        for(int i = 0;i< tilfeldigeHeltall.length;i++) {
            totalsum += tilfeldigeHeltall[i];
        }
        return totalsum / (double) tilfeldigeHeltall.length;
    }

    public void utskrift() {
        String sammenlagtUtskrift = "";
        int teller = 0;
        for (int i = 0;i< tilfeldigeHeltall.length;i++) {
            sammenlagtUtskrift += " "+tilfeldigeHeltall[i];
            teller++;
            if(teller % 8 == 0) {
                sammenlagtUtskrift += "\n";
            }
        }
        JOptionPane.showMessageDialog(
                null, sammenlagtUtskrift
                +"\n \n Minste tall er " + minsteTall()
                +"\n Største tall er " + storsteTall()
                +"\n Gjennomsnittsverdien er " + String.format("%.1f" , beregnGjennomsnitt())
        );
    }
}
