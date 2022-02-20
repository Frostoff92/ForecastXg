package first.frost.develop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableChampionship extends JFrame{
    private JLabel JLGames;
    private JLabel JLWin;
    private JLabel JLDraw;
    private JLabel JLLoser;
    private JLabel JLScore;
    private JLabel JLMiss;
    private JLabel JLHomeTeam;
    private JLabel JLAwayTeam;
    private JTextField JTFHomeGames;
    private JTextField JTFHomeWin;
    private JTextField JTFHomeDraw;
    private JTextField JTFHomeLoser;
    private JTextField JTFHomeScore;
    private JTextField JTFHomeMiss;
    private JTextField JTFAwayGames;
    private JTextField JTFAwayWin;
    private JTextField JTFAwayDraw;
    private JTextField JTFAwayLoser;
    private JTextField JTFAwayScore;
    private JTextField JTFAwayMiss;
    private JPanel JPanelSheets;
    private JButton JBCalcTotalResult;
    private JButton JBClear;
    private JTextField JTFTotalHomeScore;
    private JTextField JTFTotalAwayScore;

    public TableChampionship()    {
        setTitle("Champions table");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        JBClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
            }
        });
        JBCalcTotalResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result();
            }
        });
    }
//    Clear textFields
    public void clearTextFields()   {
        JTFHomeGames.setText("");
        JTFHomeWin.setText("");
        JTFHomeDraw.setText("");
        JTFHomeLoser.setText("");
        JTFHomeScore.setText("");
        JTFHomeMiss.setText("");
        JTFAwayGames.setText("");
        JTFAwayWin.setText("");
        JTFAwayDraw.setText("");
        JTFAwayLoser.setText("");
        JTFAwayScore.setText("");
        JTFAwayMiss.setText("");
        JTFTotalHomeScore.setText("");
        JTFTotalAwayScore.setText("");
    }

    public void result ()  {
       int homeGames = Integer.parseInt(JTFHomeGames.getText());
       int homeWin = Integer.parseInt(JTFHomeWin.getText())*3;
       int homeDraw = Integer.parseInt(JTFHomeDraw.getText())*1;
       int homeLose = Integer.parseInt(JTFHomeLoser.getText());
       int homeScore = Integer.parseInt(JTFHomeScore.getText());
       int homeMiss = Integer.parseInt(JTFHomeMiss.getText());

        int homeTeamScore = homeScore / homeGames;
        int homeTeamMiss = homeMiss / homeGames;

        int awayGames = Integer.parseInt(JTFAwayGames.getText());
        int awayWin = Integer.parseInt(JTFAwayWin.getText());
        int awayDraw = Integer.parseInt(JTFAwayDraw.getText());
        int awayLose = Integer.parseInt(JTFAwayLoser.getText());
        int awayScore = Integer.parseInt(JTFAwayScore.getText());
        int awayMiss = Integer.parseInt(JTFAwayMiss.getText());

        int awayTeamScore = awayScore / awayGames;
        int awayTeamMiss = awayMiss / awayGames;

        int avgHome = homeTeamScore * awayTeamMiss;
        int avgAway = awayTeamScore * homeTeamMiss;

        int xHome = (avgHome + 1) / (avgHome + avgAway);
        int xAway = (avgAway + 1) / (avgAway + avgHome);

        int totalHome = (int) Math.abs(Math.round(avgHome*xHome+0.2));
        JTFTotalHomeScore.setText(String.valueOf(totalHome));
        int totalAway = (int) Math.abs(Math.round(avgAway*xAway-0.2));
        JTFTotalAwayScore.setText(String.valueOf(totalAway));

//        int pointsHome = (homeWin * 3 + homeDraw * 1) / (homeGames);
//        int pointsAway = (awayWin * 3 + awayDraw * 1) / (awayGames);
    }


    public static void main(String[] args) {

        TableChampionship table = new TableChampionship();
        table.setVisible(true);
        table.setContentPane(new TableChampionship().JPanelSheets);
        table.pack();
    }
}
