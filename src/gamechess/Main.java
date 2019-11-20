/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamechess;

import Piece.Bishop;
import Piece.Coordinate;
import Piece.EmptyCell;
import Piece.Rook;
import Piece.Knight;
import Piece.Queen;
import Piece.Piece;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckBox;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nthan
 */
public class Main extends javax.swing.JFrame {

    public static final int PLAYER_PLAYER = 100;
    public static final int PLAYER_COMPUTER = 101;
    public static final int PLAYER_ONLINE = 102;
    public static final int CHALLENGE = 103;
    public static final int TO_BE_CHALLENGED = 104;
    public static int Mode;
    public int rowBefor = -1;
    public int columBefor = -1;
    public static ArrayList<Coordinate> listCoordinate;
    public static boolean checkSelect = false;
    public static Coordinate pieceSelect = new Coordinate(-1, -1);
    public static boolean checkSaveas = false;
    public static Thread listenner;
    public static int capacity = -1;
    public static boolean waitForEnemy;
    public static Main instance;

    //--------------------------------------------------------------------------
    public static boolean checkKingWhiteMove = false;
    public static boolean checkKingBlackMove = false;
    public static boolean checkRookLeftWhiteMove = false;
    public static boolean checkRookLeftBlackMove = false;
    public static boolean checkRookRightWhiteMove = false;
    public static boolean checkRookRightBlackMove = false;

    public static Main getInstance() {

        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public Main() {

        // paint Board chess\
        initComponents();
        chessBoard.removeAll();
        this.getContentPane().setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("image/MAIN.jpg");
        JLabel label = new JLabel();
        label.setIcon(icon);
        chessBoard.add(label);
        chessBoard.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        chessBoard = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btn_home = new javax.swing.JButton();
        btn_newGame = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lb_turn = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        chessBoard.setPreferredSize(new java.awt.Dimension(600, 600));
        chessBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chessBoardMouseClicked(evt);
            }
        });
        chessBoard.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar1.setRollover(true);

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Home.png"))); // NOI18N
        btn_home.setFocusable(false);
        btn_home.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_home.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_home);

        btn_newGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new.png"))); // NOI18N
        btn_newGame.setFocusable(false);
        btn_newGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_newGame.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newGameActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_newGame);

        jButton4.setText("jButton4");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lb_turn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_turn.setText("PLAY ONLINE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_turn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(lb_turn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(chessBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chessBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chessBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chessBoardMouseClicked
        //chon quan co: bang cach lay toa do cot va hang da nhan
        // 75 la do rong cua o co
        columBefor = evt.getX() / 75;
        rowBefor = evt.getY() / 75;

        //xoa tat cac component tren chessboard
        chessBoard.removeAll();

        if (checkSelect == false) {
            pieceSelect.setRow(rowBefor);
            pieceSelect.setCol(columBefor);

            // neu den luot trang an vao quan co trang thi thuc hien neu khong thi khong thuc hien gi ca
            if (BoardChess.turn == BoardChess.chessBoard[rowBefor][columBefor].getColor()) {
                System.out.println(BoardChess.chessBoard[rowBefor][columBefor].getName());
                listCoordinate = new ArrayList<Coordinate>(BoardChess.chessBoard[rowBefor][columBefor].getPossibleMove(BoardChess.chessBoard));
                if (waitForEnemy == false && Mode == PLAYER_ONLINE) {
                    return;
                }
                checkSelect = true;
                // CHECK RESULT: WIN OR CLOSE OR HOA
                checkResult();

                chessBoard.add(BoardChess.paintChessBox(BoardChess.chessBoard[pieceSelect.getRow()][pieceSelect.getCol()], listCoordinate));
                chessBoard.setVisible(true);
                this.setVisible(true);
            }
        } else {
            boolean isCrown = false;
            if (listCoordinate != null || listCoordinate.size() > 0) {

                for (int i = 0; i < listCoordinate.size(); i++) {
                    // kiem tra vi tri chon co phai la vi tri di chuyen dc hay khong neu dc thi di chuyen
                    if (rowBefor == listCoordinate.get(i).getRow()
                            && columBefor == listCoordinate.get(i).getCol()) {

                        // di chuyen qua co
                        Piece temp = BoardChess.chessBoard[rowBefor][columBefor];
                        temp.getCoordinate().setRow(rowBefor);
                        temp.getCoordinate().setCol(columBefor);

                        BoardChess.chessBoard[rowBefor][columBefor]
                                = BoardChess.chessBoard[pieceSelect.getRow()][pieceSelect.getCol()];
                        BoardChess.chessBoard[rowBefor][columBefor].getCoordinate().setRow(rowBefor);
                        BoardChess.chessBoard[rowBefor][columBefor].getCoordinate().setCol(columBefor);
                        BoardChess.chessBoard[pieceSelect.getRow()][pieceSelect.getCol()]
                                = new EmptyCell(-1, new Coordinate(pieceSelect.getRow(), pieceSelect.getCol()));

                        // kiem tra thang thua
                        checkResult();

                        //kiem tra neu bi chieu tuong thi hien thong bao
                        if (BoardChess.checkMate() == true) {
                            JOptionPane.showMessageDialog(null, ""
                                    + "You have been checkmate", "Error", JOptionPane.ERROR_MESSAGE);

                            // di chuyen quan co tro lai vi tri ban dau
                            BoardChess.chessBoard[pieceSelect.getRow()][pieceSelect.getCol()]
                                    = BoardChess.chessBoard[rowBefor][columBefor];
                            BoardChess.chessBoard[pieceSelect.getRow()][pieceSelect.getCol()]
                                    .getCoordinate().setRow(pieceSelect.getRow());
                            BoardChess.chessBoard[pieceSelect.getRow()][pieceSelect.getCol()]
                                    .getCoordinate().setCol(pieceSelect.getCol());

                            BoardChess.chessBoard[rowBefor][columBefor] = temp;
                            BoardChess.chessBoard[rowBefor][columBefor].getCoordinate().setRow(rowBefor);
                            BoardChess.chessBoard[rowBefor][columBefor].getCoordinate().setCol(columBefor);
                            return;
                        } else {

                            // kiem tra nhap thanh
                            switch (BoardChess.chessBoard[pieceSelect.getRow()][pieceSelect.getCol()].getName()) {
                                case "White_King":
                                    Main.checkKingWhiteMove = true;
                                    break;
                                case "Black_King":
                                    Main.checkKingBlackMove = true;
                                    break;
                                case "White_Rook":
                                    if (pieceSelect.getCol() == 0) {
                                        Main.checkRookLeftWhiteMove = true;
                                    }
                                    if (pieceSelect.getCol() == 7) {
                                        System.out.println("checkRookRightWhiteMove");
                                        Main.checkRookRightWhiteMove = true;
                                    }
                                    break;
                                case "Black_Rook":
                                    if (pieceSelect.getCol() == 7) {
                                        Main.checkRookLeftBlackMove = true;
                                    }
                                    if (pieceSelect.getCol() == 0) {
                                        Main.checkRookRightBlackMove = true;
                                    }
                                    break;
                            }
                            // Enter into

                            // ento into King Black 
                            if (BoardChess.chessBoard[rowBefor][columBefor].
                                    getName().equals("Black_King")) {
                                // KING ENTO INTO LEFT
                                if (rowBefor == 0 && columBefor == 2
                                        && !Main.checkRookRightBlackMove) {

                                    BoardChess.chessBoard[0][3]
                                            = BoardChess.chessBoard[0][0];
                                    BoardChess.chessBoard[0][3].getCoordinate().setCol(3);
                                    BoardChess.chessBoard[0][0] = new EmptyCell(-1,
                                            new Coordinate(0, 0));

                                }
                                // KING ENTER INTO RIGHT
                                if (rowBefor == 0 && columBefor == 6
                                        && !Main.checkRookLeftBlackMove) {

                                    BoardChess.chessBoard[0][5]
                                            = BoardChess.chessBoard[0][7];
                                    BoardChess.chessBoard[0][5].getCoordinate().setCol(5);
                                    BoardChess.chessBoard[0][7] = new EmptyCell(-1,
                                            new Coordinate(0, 7));

                                }
                            }

                            // KING WHITE ENTER INTO 
                            if (BoardChess.chessBoard[rowBefor][columBefor].
                                    getName().equals("White_King")) {
                                // ENTER INTO LEFT
                                if (rowBefor == 7 && columBefor == 2
                                        && !Main.checkRookLeftWhiteMove) {

                                    BoardChess.chessBoard[7][3]
                                            = BoardChess.chessBoard[7][0];
                                    BoardChess.chessBoard[7][3].getCoordinate().setCol(3);
                                    BoardChess.chessBoard[7][0] = new EmptyCell(-1,
                                            new Coordinate(7, 0));

                                }
                                if (rowBefor == 7 && columBefor == 6
                                        && !Main.checkRookRightWhiteMove) {

                                    BoardChess.chessBoard[7][5]
                                            = BoardChess.chessBoard[7][7];
                                    BoardChess.chessBoard[7][5].getCoordinate().setCol(5);
                                    BoardChess.chessBoard[7][7] = new EmptyCell(-1,
                                            new Coordinate(7, 7));

                                }

                            }

                            if (BoardChess.turn == Piece.White) {
                                isCrown = Crown();
                                BoardChess.turn = Piece.Black;
                            } else {
                                isCrown = Crown();
                                BoardChess.turn = Piece.White;
                            }
                        }
                    }
                }
                checkSelect = false;
                if (!isCrown) {

                    //ve lai ban co
                    chessBoard.add(BoardChess.paintChessBox(new EmptyCell(-1, new Coordinate(-1, -1)), null));
                    chessBoard.setVisible(true);
                    this.setVisible(true);
                }
            }
        }

    }//GEN-LAST:event_chessBoardMouseClicked

    private void btn_newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newGameActionPerformed
        newGamePlayerAndPlayer();
    }//GEN-LAST:event_btn_newGameActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        loadHome();
    }//GEN-LAST:event_btn_homeActionPerformed

    public void checkResult() {
        if (BoardChess.checkResult() == 1) {
            String temp;
            if (BoardChess.turn == Piece.White) {
                temp = "Chess Black Win";
            } else {
                temp = "Chess White Win";
            }
            JOptionPane.showMessageDialog(new JFrame(), temp, "Notification",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (BoardChess.checkResult() == 2) {
            JOptionPane.showMessageDialog(new JFrame(), "ICE", "Notification",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public boolean Crown() {
        if (BoardChess.turn == Piece.White) {
            for (int iCol = 0; iCol < 8; iCol++) {
                if (BoardChess.chessBoard[0][iCol].getName().equals("White_Pawn")) {
                    new Crown(new Coordinate(0, iCol), this).setVisible(true);
                    return true;
                }
            }
        }

        if (BoardChess.turn == Piece.Black) {
            for (int iCol = 0; iCol < 8; iCol++) {
                if (BoardChess.chessBoard[7][iCol].getName().equals("Black_Pawn")) {
                    new Crown(new Coordinate(7, iCol), this).setVisible(true);
                    return true;
                }
            }
        }
        return false;

    }

    // Tao moi ban co
    public void newGamePlayerAndPlayer() {
        // xoa tat ca cac component ra khoi ban co
        chessBoard.removeAll();

        //khoi tao cac gia tri cua ban
        BoardChess.initValue();
        capacity = CHALLENGE;

        //hien thi luot di
        if (BoardChess.turn == Piece.Black) {
            lb_turn.setText("Turn of Black");
        }
        if (BoardChess.turn == Piece.White) {
            lb_turn.setText("Turn of White");
        }

        // ve ban co bang cach add cac quan co vao ban co
        chessBoard.add(BoardChess.paintChessBox(new EmptyCell(-1, new Coordinate(-1, -1)), null));

        // hien thi ban co
        chessBoard.setVisible(true);
        this.setVisible(true);
    }

    public void loadHome() {
        BoardChess.initValue();
        chessBoard.removeAll();
        this.getContentPane().setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("image/MAIN.jpg");
        JLabel label = new JLabel();
        label.setIcon(icon);
        chessBoard.add(label);
        chessBoard.setVisible(true);
        this.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main.getInstance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_newGame;
    public javax.swing.JPanel chessBoard;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JLabel lb_turn;
    // End of variables declaration//GEN-END:variables

}