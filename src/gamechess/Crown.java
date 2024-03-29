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
//import Message.Request;
import javax.swing.JPanel;

/**
 *
 * @author nthan
 */
public class Crown extends javax.swing.JFrame {

    public Coordinate chessIsCrown;
    private Main main;
    /**
     * Creates new form Crown
     */
    public Crown(Coordinate myChess, Main main) {
        initComponents();
        this.main = main;
        chessIsCrown = myChess;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Rook = new javax.swing.JButton();
        btn_Bishop = new javax.swing.JButton();
        btn_Knight = new javax.swing.JButton();
        btn_Queen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crown");

        btn_Rook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/White_Rook.png"))); // NOI18N
        btn_Rook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RookActionPerformed(evt);
            }
        });

        btn_Bishop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/White_Bishop.png"))); // NOI18N
        btn_Bishop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BishopActionPerformed(evt);
            }
        });

        btn_Knight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/White_Knight.png"))); // NOI18N
        btn_Knight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KnightActionPerformed(evt);
            }
        });

        btn_Queen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/White_Queen.png"))); // NOI18N
        btn_Queen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QueenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btn_Rook)
                .addGap(18, 18, 18)
                .addComponent(btn_Bishop)
                .addGap(18, 18, 18)
                .addComponent(btn_Queen)
                .addGap(30, 30, 30)
                .addComponent(btn_Knight)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Knight)
                    .addComponent(btn_Rook)
                    .addComponent(btn_Bishop)
                    .addComponent(btn_Queen))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RookActionPerformed
        if(chessIsCrown.getRow() == 0){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Rook(Piece.White, chessIsCrown);

        }
        if(chessIsCrown.getRow() == 7){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Rook(Piece.Black, chessIsCrown);
        }
        // PROCESS ONLINE
//        if(this.main.Mode == Main.PLAYER_ONLINE){
//            Client.requestCrown(chessIsCrown, Request.CROWNROOK);
//            if(main.capacity == Main.TO_BE_CHALLENGED){
//                BoardChess.ReverseChessBoard(BoardChess.chessBoard, BoardChess.chessBoardReverse);
//            }
//        }
        main.chessBoard.add(BoardChess.paintChessBox(new EmptyCell(-1, new Coordinate(-1, -1)),null));
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_RookActionPerformed

    private void btn_BishopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BishopActionPerformed
        if(chessIsCrown.getRow() == 0){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Bishop(Piece.White, chessIsCrown);
        }
        if(chessIsCrown.getRow() == 7){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Bishop(Piece.Black, chessIsCrown);
        }

        main.chessBoard.add(BoardChess.paintChessBox(new EmptyCell(-1, new Coordinate(-1, -1)),null));
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_BishopActionPerformed

    private void btn_QueenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QueenActionPerformed
        if(chessIsCrown.getRow() == 0){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Queen(Piece.White, chessIsCrown);
        }
        if(chessIsCrown.getRow() == 7){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Queen(Piece.Black, chessIsCrown);
        }
        // PROCESS ONLINE
//        if(this.main.Mode == Main.PLAYER_ONLINE){
//            Client.requestCrown(chessIsCrown, Request.CROWNQUEEN);
//            if(main.capacity == Main.TO_BE_CHALLENGED){
//                BoardChess.ReverseChessBoard(BoardChess.chessBoard, BoardChess.chessBoardReverse);
//            }
//        }
        main.chessBoard.add(BoardChess.paintChessBox(new EmptyCell(-1, new Coordinate(-1, -1)),null));
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_QueenActionPerformed

    private void btn_KnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KnightActionPerformed
        if(chessIsCrown.getRow() == 0){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Knight(Piece.White, chessIsCrown);
        }
        if(chessIsCrown.getRow() == 7){
            BoardChess.chessBoard[chessIsCrown.getRow()][chessIsCrown.getCol()]
            = new Knight(Piece.Black, chessIsCrown);
        }
        // PROCESS ONLINE
//        if(this.main.Mode == Main.PLAYER_ONLINE){
//            Client.requestCrown(chessIsCrown, Request.CROWNKNIGHT);
//            if(main.capacity == Main.TO_BE_CHALLENGED){
//                BoardChess.ReverseChessBoard(BoardChess.chessBoard, BoardChess.chessBoardReverse);
//            }
//        }
        main.chessBoard.add(BoardChess.paintChessBox(new EmptyCell(-1, new Coordinate(-1, -1)),null));
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_KnightActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Bishop;
    private javax.swing.JButton btn_Knight;
    private javax.swing.JButton btn_Queen;
    private javax.swing.JButton btn_Rook;
    // End of variables declaration//GEN-END:variables
}
