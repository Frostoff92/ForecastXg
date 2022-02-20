/**
 *
 * My experiment program for calculating
 * forecast result soccer matches
 *
 * @author  Michael Frost
 * @version 1.0
 *
 */

package first.frost.develop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ForecastXG extends JFrame {
    private JTextField jTFScoreHome;    //      Home score
    private JTextField jTFMissHome;     //      Home missed
    private JTextField jTFScoreAway;    //      Away score
    private JTextField jTFMissAway;     //      Away missed
    private JTextField jTFScoreHome_xG; //      xG Home
    private JTextField jTFMissHome_xG;  //      miss xG Home
    private JTextField jTFScoreAway_xG; //      xG Away
    private JTextField jTFMissAway_xG;  //      miss xG Away
    private JPanel jPanel;
    private JButton calcButton;
    private JLabel awayLabel;
    private JLabel homeLabel;
    private JLabel missedLabel;
    private JLabel missedXGLabel;
    private JLabel scoreXGLabel;
    private JLabel scoreLabel;
    private JButton clrButton;
    private JLabel vsLabel;
    private JLabel totalLabel;
    private JTextField jTFTotalHome;
    private JTextField jTFTotalAway;


    public ForecastXG() {
        setTitle("Forecast goals with xG");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

//        Clear text fields
        clrButton.addActionListener(e -> clrTextField());
        clrButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode()==KeyEvent.VK_DELETE) { clrTextField(); }
            }
        });

//        Calculate total scores
        calcButton.addActionListener(e -> result());
        calcButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode()==KeyEvent.VK_ENTER) { result(); }
            }
        });
    }

    public void clrTextField()  {
        jTFScoreHome.setText("");
        jTFMissHome.setText("");
        jTFScoreAway.setText("");
        jTFMissAway.setText("");
        jTFScoreHome_xG.setText("");
        jTFMissHome_xG.setText("");
        jTFScoreAway_xG.setText("");
        jTFMissAway_xG.setText("");
        jTFTotalHome.setText("");
        jTFTotalAway.setText("");
    }

    public void result()    {
        try {

            float scHome = Float.parseFloat(jTFScoreHome.getText());
            float miHome = Float.parseFloat(jTFMissHome.getText());
            float scAway = Float.parseFloat(jTFScoreAway.getText());
            float miAway = Float.parseFloat(jTFMissAway.getText());
            float scHome_xG = Float.parseFloat(jTFScoreHome_xG.getText());
            float miHome_xG = Float.parseFloat(jTFMissHome_xG.getText());
            float scAway_xG = Float.parseFloat(jTFScoreAway_xG.getText());
            float miAway_xG = Float.parseFloat(jTFMissAway_xG.getText());

             //Forecast score home team
             float avg_scHome = scHome + miAway;
             float exp_scHome_xG = scHome_xG - miHome_xG;
             float totalHome = (avg_scHome + exp_scHome_xG) / 2;
             float rndTHome = (float) (Math.round(totalHome * 100.0) / 100.0);
             jTFTotalHome.setText(String.valueOf(rndTHome));

            //Forecast score away team
             float avg_scAway = miHome + scAway;
             float exp_scAway_xG = scAway_xG - miAway_xG;
             float totalAway = (avg_scAway + exp_scAway_xG) / 2;
             float rndTAway = (float) (Math.round(totalAway * 100.0) /100.0);
             jTFTotalAway.setText(String.valueOf(rndTAway));

        } catch (NumberFormatException e)   {
            JOptionPane.showMessageDialog(null, "This field is empty! Please input number!");
        }
    }


    public static void main(String[] args) {

        ForecastXG forecast = new ForecastXG();
        forecast.setSize(1000, 600);
        forecast.setVisible(true);
        forecast.setResizable(false);
        forecast.setContentPane(new ForecastXG().jPanel);
        forecast.pack();


    }

}
