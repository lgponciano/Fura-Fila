/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.bean.Produto;
import model.dao.ProdutoDAO;
import qr_code.Leitor;

public class CartScreen extends javax.swing.JFrame {
    
    //Chamando Classe leitor 
    Leitor telaLeitor = new Leitor();
    
    private int qtd;
    private Produto[] arrProd;
    private int pagina = 1;
    private int usuarioId = 1;

    public CartScreen() {
        initComponents();
        id1.setVisible(false);
        id2.setVisible(false);
        id3.setVisible(false);
        id4.setVisible(false);
        id5.setVisible(false);
        id6.setVisible(false);
        id7.setVisible(false);
        id8.setVisible(false);
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        readTable();
    }

    public void readTable() {
        ProdutoDAO pdao = new ProdutoDAO();

        int qtd = 0;

        for (Produto p : pdao.readCartProdutoData(usuarioId)) {
            qtd++;
        }
        this.qtd = qtd;
        this.arrProd = new Produto[qtd];
        int arrPosition = 0;
        for (Produto p : pdao.readCartProdutoData(usuarioId)) {
            arrProd[arrPosition] = p;
            arrPosition++;
        }

        for (int i = 0; i < 8; i++) {

            int numAuxiliar = 0;
            if (this.pagina == 1) {
                numAuxiliar = 0;
            } else {
                numAuxiliar = (this.pagina * 8) - 8;
            }

            switch (i) {
                case 0:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome1.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd1.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco1.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso1.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id1.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }

                case 1:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome2.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd2.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco2.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso2.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id2.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }

                case 2:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome3.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd3.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco3.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso3.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id3.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }

                case 3:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome4.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd4.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco4.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso4.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id4.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }

                case 4:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome5.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd5.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco5.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso5.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id5.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }

                case 5:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome6.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd6.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco6.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso6.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id6.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }

                case 6:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome7.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd7.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco7.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso7.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id7.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((numAuxiliar) + i <= (this.qtd - 1)) {
                        nome8.setText(arrProd[(numAuxiliar) + i].getNome());
                        qtd8.setText(String.valueOf(arrProd[(numAuxiliar) + i].getQuantidade()));
                        preco8.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPreco()));
                        peso8.setText(String.valueOf(arrProd[(numAuxiliar) + i].getPeso()));
                        id8.setText(String.valueOf(arrProd[(numAuxiliar) + i].getId()));
                        break;
                    } else {
                        break;
                    }
            }
        }

        hideElements();
    }

    private void hideElements() {

        if (nome1.getText().equals("")) {
            nome1.setVisible(false);
            asc1.setVisible(false);
            desc1.setVisible(false);
        } else {
            nome1.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }
        if (nome2.getText().equals("")) {
            nome2.setVisible(false);
            asc2.setVisible(false);
            desc2.setVisible(false);
        } else {
            nome2.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }
        if (nome3.getText().equals("")) {
            nome3.setVisible(false);
            asc3.setVisible(false);
            desc3.setVisible(false);
        } else {
            nome3.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }
        if (nome4.getText().equals("")) {
            nome4.setVisible(false);
            asc4.setVisible(false);
            desc4.setVisible(false);
        } else {
            nome4.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }
        if (nome5.getText().equals("")) {
            nome5.setVisible(false);
            asc5.setVisible(false);
            desc5.setVisible(false);
        } else {
            nome5.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }
        if (nome6.getText().equals("")) {
            nome6.setVisible(false);
            asc6.setVisible(false);
            desc6.setVisible(false);
        } else {
            nome6.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }
        if (nome7.getText().equals("")) {
            nome7.setVisible(false);
            asc7.setVisible(false);
            desc7.setVisible(false);
        } else {
            nome7.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }
        if (nome8.getText().equals("")) {
            nome8.setVisible(false);
            asc8.setVisible(false);
            desc8.setVisible(false);
        } else {
            nome8.setVisible(true);
            asc8.setVisible(true);
            desc8.setVisible(true);
        }

        if (qtd1.getText().equals("")) {
            qtd1.setVisible(false);
        } else {
            qtd1.setVisible(true);
        }
        if (qtd2.getText().equals("")) {
            qtd2.setVisible(false);
        } else {
            qtd2.setVisible(true);
        }
        if (qtd3.getText().equals("")) {
            qtd3.setVisible(false);
        } else {
            qtd3.setVisible(true);
        }
        if (qtd4.getText().equals("")) {
            qtd4.setVisible(false);
        } else {
            qtd4.setVisible(true);
        }
        if (qtd5.getText().equals("")) {
            qtd5.setVisible(false);
        } else {
            qtd5.setVisible(true);
        }
        if (qtd6.getText().equals("")) {
            qtd6.setVisible(false);
        } else {
            qtd6.setVisible(true);
        }
        if (qtd7.getText().equals("")) {
            qtd7.setVisible(false);
        } else {
            qtd7.setVisible(true);
        }
        if (qtd8.getText().equals("")) {
            qtd8.setVisible(false);
        } else {
            qtd8.setVisible(true);
        }

        if (preco1.getText().equals("")) {
            preco1.setVisible(false);
        } else {
            preco1.setVisible(true);
        }
        if (preco2.getText().equals("")) {
            preco2.setVisible(false);
        } else {
            preco2.setVisible(true);
        }
        if (preco3.getText().equals("")) {
            preco3.setVisible(false);
        } else {
            preco3.setVisible(true);
        }
        if (preco4.getText().equals("")) {
            preco4.setVisible(false);
        } else {
            preco4.setVisible(true);
        }
        if (preco5.getText().equals("")) {
            preco5.setVisible(false);
        } else {
            preco5.setVisible(true);
        }
        if (preco6.getText().equals("")) {
            preco6.setVisible(false);
        } else {
            preco6.setVisible(true);
        }
        if (preco7.getText().equals("")) {
            preco7.setVisible(false);
        } else {
            preco7.setVisible(true);
        }
        if (preco8.getText().equals("")) {
            preco8.setVisible(false);
        } else {
            preco8.setVisible(true);
        }

        if (peso1.getText().equals("")) {
            peso1.setVisible(false);
        } else {
            peso1.setVisible(true);
        }
        if (peso2.getText().equals("")) {
            peso2.setVisible(false);
        } else {
            peso2.setVisible(true);
        }
        if (peso3.getText().equals("")) {
            peso3.setVisible(false);
        } else {
            peso3.setVisible(true);
        }
        if (peso4.getText().equals("")) {
            peso4.setVisible(false);
        } else {
            peso4.setVisible(true);
        }
        if (peso5.getText().equals("")) {
            peso5.setVisible(false);
        } else {
            peso5.setVisible(true);
        }
        if (peso6.getText().equals("")) {
            peso6.setVisible(false);
        } else {
            peso6.setVisible(true);
        }
        if (peso7.getText().equals("")) {
            peso7.setVisible(false);
        } else {
            peso7.setVisible(true);
        }
        if (peso8.getText().equals("")) {
            peso8.setVisible(false);
        } else {
            peso8.setVisible(true);
        }
    }

    private void cleanTable() {
        nome1.setText("");
        nome2.setText("");
        nome3.setText("");
        nome4.setText("");
        nome5.setText("");
        nome6.setText("");
        nome7.setText("");
        nome8.setText("");

        qtd1.setText("");
        qtd2.setText("");
        qtd3.setText("");
        qtd4.setText("");
        qtd5.setText("");
        qtd6.setText("");
        qtd7.setText("");
        qtd8.setText("");

        preco1.setText("");
        preco2.setText("");
        preco3.setText("");
        preco4.setText("");
        preco5.setText("");
        preco6.setText("");
        preco7.setText("");
        preco8.setText("");

        id1.setText("");
        id2.setText("");
        id3.setText("");
        id4.setText("");
        id5.setText("");
        id6.setText("");
        id7.setText("");
        id8.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nome1 = new javax.swing.JTextField();
        nome2 = new javax.swing.JTextField();
        nome3 = new javax.swing.JTextField();
        nome4 = new javax.swing.JTextField();
        nome5 = new javax.swing.JTextField();
        nome6 = new javax.swing.JTextField();
        nome7 = new javax.swing.JTextField();
        nome8 = new javax.swing.JTextField();
        voltar = new javax.swing.JButton();
        avancar = new javax.swing.JButton();
        asc1 = new javax.swing.JButton();
        desc1 = new javax.swing.JButton();
        asc2 = new javax.swing.JButton();
        desc2 = new javax.swing.JButton();
        asc3 = new javax.swing.JButton();
        desc3 = new javax.swing.JButton();
        asc4 = new javax.swing.JButton();
        desc4 = new javax.swing.JButton();
        asc5 = new javax.swing.JButton();
        desc5 = new javax.swing.JButton();
        asc6 = new javax.swing.JButton();
        desc6 = new javax.swing.JButton();
        asc7 = new javax.swing.JButton();
        desc7 = new javax.swing.JButton();
        asc8 = new javax.swing.JButton();
        desc8 = new javax.swing.JButton();
        qtd1 = new javax.swing.JTextField();
        qtd2 = new javax.swing.JTextField();
        qtd3 = new javax.swing.JTextField();
        qtd4 = new javax.swing.JTextField();
        qtd5 = new javax.swing.JTextField();
        qtd6 = new javax.swing.JTextField();
        qtd7 = new javax.swing.JTextField();
        qtd8 = new javax.swing.JTextField();
        preco1 = new javax.swing.JTextField();
        preco2 = new javax.swing.JTextField();
        preco3 = new javax.swing.JTextField();
        preco4 = new javax.swing.JTextField();
        preco5 = new javax.swing.JTextField();
        preco6 = new javax.swing.JTextField();
        preco7 = new javax.swing.JTextField();
        preco8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        totalPeso = new javax.swing.JTextField();
        id1 = new javax.swing.JTextField();
        id2 = new javax.swing.JTextField();
        id3 = new javax.swing.JTextField();
        id4 = new javax.swing.JTextField();
        id5 = new javax.swing.JTextField();
        id6 = new javax.swing.JTextField();
        id7 = new javax.swing.JTextField();
        id8 = new javax.swing.JTextField();
        peso1 = new javax.swing.JTextField();
        peso2 = new javax.swing.JTextField();
        peso3 = new javax.swing.JTextField();
        peso4 = new javax.swing.JTextField();
        peso5 = new javax.swing.JTextField();
        peso6 = new javax.swing.JTextField();
        peso7 = new javax.swing.JTextField();
        peso8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        limparCarrinho = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bQrCode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome1ActionPerformed(evt);
            }
        });

        nome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome2ActionPerformed(evt);
            }
        });

        nome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome3ActionPerformed(evt);
            }
        });

        nome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome4ActionPerformed(evt);
            }
        });

        nome5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome5ActionPerformed(evt);
            }
        });

        nome6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome6ActionPerformed(evt);
            }
        });

        nome7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome7ActionPerformed(evt);
            }
        });

        nome8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome8ActionPerformed(evt);
            }
        });

        voltar.setText("<-");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        avancar.setText("->");
        avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avancarActionPerformed(evt);
            }
        });

        asc1.setText("+");
        asc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc1ActionPerformed(evt);
            }
        });

        desc1.setText("-");
        desc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc1ActionPerformed(evt);
            }
        });

        asc2.setText("+");
        asc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc2ActionPerformed(evt);
            }
        });

        desc2.setText("-");
        desc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc2ActionPerformed(evt);
            }
        });

        asc3.setText("+");
        asc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc3ActionPerformed(evt);
            }
        });

        desc3.setText("-");
        desc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc3ActionPerformed(evt);
            }
        });

        asc4.setText("+");
        asc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc4ActionPerformed(evt);
            }
        });

        desc4.setText("-");
        desc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc4ActionPerformed(evt);
            }
        });

        asc5.setText("+");
        asc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc5ActionPerformed(evt);
            }
        });

        desc5.setText("-");
        desc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc5ActionPerformed(evt);
            }
        });

        asc6.setText("+");
        asc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc6ActionPerformed(evt);
            }
        });

        desc6.setText("-");
        desc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc6ActionPerformed(evt);
            }
        });

        asc7.setText("+");
        asc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc7ActionPerformed(evt);
            }
        });

        desc7.setText("-");
        desc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc7ActionPerformed(evt);
            }
        });

        asc8.setText("+");
        asc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asc8ActionPerformed(evt);
            }
        });

        desc8.setText("-");
        desc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc8ActionPerformed(evt);
            }
        });

        qtd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd1ActionPerformed(evt);
            }
        });

        qtd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd2ActionPerformed(evt);
            }
        });

        qtd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd3ActionPerformed(evt);
            }
        });

        qtd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd4ActionPerformed(evt);
            }
        });

        qtd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd5ActionPerformed(evt);
            }
        });

        qtd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd6ActionPerformed(evt);
            }
        });

        qtd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd7ActionPerformed(evt);
            }
        });

        qtd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd8ActionPerformed(evt);
            }
        });

        preco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco1ActionPerformed(evt);
            }
        });

        preco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco2ActionPerformed(evt);
            }
        });

        preco3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco3ActionPerformed(evt);
            }
        });

        preco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco4ActionPerformed(evt);
            }
        });

        preco5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco5ActionPerformed(evt);
            }
        });

        preco6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco6ActionPerformed(evt);
            }
        });

        preco7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco7ActionPerformed(evt);
            }
        });

        preco8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco8ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total à pagar:");

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel2.setText("Peso total:");

        totalPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPesoActionPerformed(evt);
            }
        });

        id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id1ActionPerformed(evt);
            }
        });

        id2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id2ActionPerformed(evt);
            }
        });

        id3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id3ActionPerformed(evt);
            }
        });

        id4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id4ActionPerformed(evt);
            }
        });

        id5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id5ActionPerformed(evt);
            }
        });

        id6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id6ActionPerformed(evt);
            }
        });

        id7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id7ActionPerformed(evt);
            }
        });

        id8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id8ActionPerformed(evt);
            }
        });

        peso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso1ActionPerformed(evt);
            }
        });

        peso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso2ActionPerformed(evt);
            }
        });

        peso3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso3ActionPerformed(evt);
            }
        });

        peso4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso4ActionPerformed(evt);
            }
        });

        peso5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso5ActionPerformed(evt);
            }
        });

        peso6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso6ActionPerformed(evt);
            }
        });

        peso7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso7ActionPerformed(evt);
            }
        });

        peso8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso8ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome");

        jLabel4.setText("Preço(un)");

        jLabel5.setText("Quantidade");

        jLabel7.setText("Peso Kg(un)");

        jButton1.setText("Finalizar Compra");

        limparCarrinho.setText("Limpar Carrinho");
        limparCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCarrinhoActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bQrCode.setText("QR CODE");
        bQrCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bQrCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(limparCarrinho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bQrCode, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avancar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(preco1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addComponent(preco2)
                                .addComponent(preco3)
                                .addComponent(preco4)
                                .addComponent(preco5)
                                .addComponent(preco6)
                                .addComponent(preco7)
                                .addComponent(preco8))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(qtd1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                    .addComponent(qtd2)
                                                    .addComponent(qtd8))
                                                .addComponent(qtd3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(qtd4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(qtd5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(qtd6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(qtd7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(peso1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peso7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(peso6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(peso5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(peso4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(peso3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(peso2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peso8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asc8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desc8)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id8, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(id7)
                                    .addComponent(id6)
                                    .addComponent(id5)
                                    .addComponent(id4)
                                    .addComponent(id3)
                                    .addComponent(id2)
                                    .addComponent(id1))
                                .addGap(20, 20, 20))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(qtd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtd5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtd7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtd8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(preco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc1)
                            .addComponent(desc1)
                            .addComponent(peso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc2)
                            .addComponent(desc2)
                            .addComponent(peso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc3)
                            .addComponent(desc3)
                            .addComponent(peso3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc4)
                            .addComponent(desc4)
                            .addComponent(peso4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc5)
                            .addComponent(desc5)
                            .addComponent(peso5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc6)
                            .addComponent(desc6)
                            .addComponent(peso6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc7)
                            .addComponent(desc7)
                            .addComponent(peso7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asc8)
                            .addComponent(desc8)
                            .addComponent(peso8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(totalPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voltar)
                            .addComponent(avancar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(limparCarrinho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addComponent(bQrCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome1ActionPerformed

    }//GEN-LAST:event_nome1ActionPerformed

    private void nome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome2ActionPerformed

    }//GEN-LAST:event_nome2ActionPerformed

    private void nome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome3ActionPerformed

    }//GEN-LAST:event_nome3ActionPerformed

    private void nome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome4ActionPerformed

    }//GEN-LAST:event_nome4ActionPerformed

    private void nome5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome5ActionPerformed

    }//GEN-LAST:event_nome5ActionPerformed

    private void nome6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome6ActionPerformed

    }//GEN-LAST:event_nome6ActionPerformed

    private void nome7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome7ActionPerformed

    }//GEN-LAST:event_nome7ActionPerformed

    private void nome8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome8ActionPerformed

    }//GEN-LAST:event_nome8ActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed

        if ((this.pagina * 8) > 8) {

            this.pagina--;
            for (int i = 0; i < (this.pagina * 8); i++) {
                if (((this.pagina * 8) - 8) + i >= 0) {
                    switch (i) {
                        case 0:
                            nome1.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd1.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco1.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso1.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id1.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                        case 1:
                            nome2.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd2.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco2.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso2.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id2.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                        case 2:
                            nome3.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd3.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco3.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso3.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id3.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                        case 3:
                            nome4.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd4.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco4.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso4.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id4.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                        case 4:
                            nome5.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd5.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco5.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso5.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id5.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                        case 5:
                            nome6.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd6.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco6.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso6.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id6.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                        case 6:
                            nome7.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd7.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco7.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso7.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id7.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                        case 7:
                            nome8.setText(arrProd[((this.pagina * 8) - 8) + i].getNome());
                            qtd8.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getQuantidade()));
                            preco8.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPreco()));
                            peso8.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getPeso()));
                            id8.setText(String.valueOf(arrProd[((this.pagina * 8) - 8) + i].getId()));
                            break;
                    }
                }
            }
        }

        hideElements();
    }//GEN-LAST:event_voltarActionPerformed

    private void avancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avancarActionPerformed

        if ((this.pagina * 8) < this.qtd) {
            cleanTable();

            for (int i = 0; i < (this.pagina * 9) + 9; i++) {

                switch (i) {
                    case 0:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome1.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd1.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco1.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso1.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id1.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }

                    case 1:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome2.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd2.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco2.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso2.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id2.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }

                    case 2:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome3.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd3.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco3.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso3.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id3.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }

                    case 3:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome4.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd4.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco4.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso4.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id4.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }

                    case 4:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome5.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd5.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco5.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso5.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id5.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }

                    case 5:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome6.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd6.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco6.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso6.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id6.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }

                    case 6:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome7.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd7.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco7.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso7.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id7.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if ((this.pagina * 8) + i <= (this.qtd - 1)) {
                            nome8.setText(arrProd[(this.pagina * 8) + i].getNome());
                            qtd8.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getQuantidade()));
                            preco8.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPreco()));
                            peso8.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getPeso()));
                            id8.setText(String.valueOf(arrProd[(this.pagina * 8) + i].getId()));
                            break;
                        } else {
                            break;
                        }
                }
            }

            if ((this.pagina * 7) < this.qtd) {
                this.pagina++;
            }

        }

        hideElements();
    }//GEN-LAST:event_avancarActionPerformed

    private double totalAPagar(int id) {
        ProdutoDAO pdao = new ProdutoDAO();
        double total = pdao.readCartTotal(id);
        return total;
    }

    private double totalPeso(int id) {
        ProdutoDAO pdao = new ProdutoDAO();
        double total = pdao.readCartTotalWeight(id);
        return total;

    }

    private void qtd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd1ActionPerformed
    
    }//GEN-LAST:event_qtd1ActionPerformed

    private void qtd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd2ActionPerformed
  
    }//GEN-LAST:event_qtd2ActionPerformed

    private void qtd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd3ActionPerformed
     
    }//GEN-LAST:event_qtd3ActionPerformed

    private void qtd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd4ActionPerformed
      
    }//GEN-LAST:event_qtd4ActionPerformed

    private void qtd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd5ActionPerformed
   
    }//GEN-LAST:event_qtd5ActionPerformed

    private void qtd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd6ActionPerformed
     
    }//GEN-LAST:event_qtd6ActionPerformed

    private void qtd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd7ActionPerformed
      
    }//GEN-LAST:event_qtd7ActionPerformed

    private void qtd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd8ActionPerformed

    }//GEN-LAST:event_qtd8ActionPerformed

    private void preco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco1ActionPerformed
   
    }//GEN-LAST:event_preco1ActionPerformed

    private void preco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco2ActionPerformed
 
    }//GEN-LAST:event_preco2ActionPerformed

    private void preco3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco3ActionPerformed
     
    }//GEN-LAST:event_preco3ActionPerformed

    private void preco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco4ActionPerformed
      
    }//GEN-LAST:event_preco4ActionPerformed

    private void preco5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco5ActionPerformed
       
    }//GEN-LAST:event_preco5ActionPerformed

    private void preco6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco6ActionPerformed
      
    }//GEN-LAST:event_preco6ActionPerformed

    private void preco7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco7ActionPerformed
       
    }//GEN-LAST:event_preco7ActionPerformed

    private void preco8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco8ActionPerformed
      
    }//GEN-LAST:event_preco8ActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed

    }//GEN-LAST:event_totalActionPerformed

    private void totalPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPesoActionPerformed
    
    }//GEN-LAST:event_totalPesoActionPerformed

    private void asc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc1ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id1.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc1ActionPerformed

    private void id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id1ActionPerformed
    
    }//GEN-LAST:event_id1ActionPerformed

    private void id2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id2ActionPerformed
    
    }//GEN-LAST:event_id2ActionPerformed

    private void id3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id3ActionPerformed
    
    }//GEN-LAST:event_id3ActionPerformed

    private void id4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id4ActionPerformed
       
    }//GEN-LAST:event_id4ActionPerformed

    private void id5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id5ActionPerformed
     
    }//GEN-LAST:event_id5ActionPerformed

    private void id6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id6ActionPerformed
        
    }//GEN-LAST:event_id6ActionPerformed

    private void id7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id7ActionPerformed
       
    }//GEN-LAST:event_id7ActionPerformed

    private void id8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id8ActionPerformed
       
    }//GEN-LAST:event_id8ActionPerformed

    private void desc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc1ActionPerformed
        if (!qtd1.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id1.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc1ActionPerformed

    private void asc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc2ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id2.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc2ActionPerformed

    private void asc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc3ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id3.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc3ActionPerformed

    private void asc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc4ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id4.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc4ActionPerformed

    private void asc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc5ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id5.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc5ActionPerformed

    private void asc6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc6ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id6.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc6ActionPerformed

    private void asc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc7ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id7.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc7ActionPerformed

    private void asc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asc8ActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.updateCart(Integer.parseInt(id8.getText()));
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
    }//GEN-LAST:event_asc8ActionPerformed

    private void desc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc2ActionPerformed
        if (!qtd2.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id2.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc2ActionPerformed

    private void desc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc3ActionPerformed
        if (!qtd3.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id3.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc3ActionPerformed

    private void desc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc4ActionPerformed
        if (!qtd4.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id4.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc4ActionPerformed

    private void desc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc5ActionPerformed
        if (!qtd5.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id5.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc5ActionPerformed

    private void desc6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc6ActionPerformed
        if (!qtd6.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id6.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc6ActionPerformed

    private void desc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc7ActionPerformed
        if (!qtd7.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id7.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc7ActionPerformed

    private void desc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc8ActionPerformed
        if (!qtd8.getText().equals("0")) {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.updateCartDecrement(Integer.parseInt(id8.getText()));
            readTable();
            total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
            totalPeso.setText(String.format("%.2f", totalPeso(usuarioId)) + "Kg");
        }
    }//GEN-LAST:event_desc8ActionPerformed

    private void peso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso1ActionPerformed
      
    }//GEN-LAST:event_peso1ActionPerformed

    private void peso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso2ActionPerformed
 
    }//GEN-LAST:event_peso2ActionPerformed

    private void peso3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso3ActionPerformed
 
    }//GEN-LAST:event_peso3ActionPerformed

    private void peso4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso4ActionPerformed
  
    }//GEN-LAST:event_peso4ActionPerformed

    private void peso5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso5ActionPerformed
     
    }//GEN-LAST:event_peso5ActionPerformed

    private void peso6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso6ActionPerformed
   
    }//GEN-LAST:event_peso6ActionPerformed

    private void peso7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso7ActionPerformed
 
    }//GEN-LAST:event_peso7ActionPerformed

    private void peso8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peso8ActionPerformed

    private void limparCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCarrinhoActionPerformed
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.cleanUpCart(usuarioId);
        readTable();
        total.setText(String.format("R$%,.2f", totalAPagar(usuarioId)));
        totalPeso.setText(String.valueOf(totalPeso(usuarioId) + " Kg"));
    }//GEN-LAST:event_limparCarrinhoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ViewTable().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bQrCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQrCodeActionPerformed
        telaLeitor.setVisible(true);
    }//GEN-LAST:event_bQrCodeActionPerformed

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
            java.util.logging.Logger.getLogger(CartScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asc1;
    private javax.swing.JButton asc2;
    private javax.swing.JButton asc3;
    private javax.swing.JButton asc4;
    private javax.swing.JButton asc5;
    private javax.swing.JButton asc6;
    private javax.swing.JButton asc7;
    private javax.swing.JButton asc8;
    private javax.swing.JButton avancar;
    private javax.swing.JButton bQrCode;
    private javax.swing.JButton desc1;
    private javax.swing.JButton desc2;
    private javax.swing.JButton desc3;
    private javax.swing.JButton desc4;
    private javax.swing.JButton desc5;
    private javax.swing.JButton desc6;
    private javax.swing.JButton desc7;
    private javax.swing.JButton desc8;
    private javax.swing.JTextField id1;
    private javax.swing.JTextField id2;
    private javax.swing.JTextField id3;
    private javax.swing.JTextField id4;
    private javax.swing.JTextField id5;
    private javax.swing.JTextField id6;
    private javax.swing.JTextField id7;
    private javax.swing.JTextField id8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limparCarrinho;
    private javax.swing.JTextField nome1;
    private javax.swing.JTextField nome2;
    private javax.swing.JTextField nome3;
    private javax.swing.JTextField nome4;
    private javax.swing.JTextField nome5;
    private javax.swing.JTextField nome6;
    private javax.swing.JTextField nome7;
    private javax.swing.JTextField nome8;
    private javax.swing.JTextField peso1;
    private javax.swing.JTextField peso2;
    private javax.swing.JTextField peso3;
    private javax.swing.JTextField peso4;
    private javax.swing.JTextField peso5;
    private javax.swing.JTextField peso6;
    private javax.swing.JTextField peso7;
    private javax.swing.JTextField peso8;
    private javax.swing.JTextField preco1;
    private javax.swing.JTextField preco2;
    private javax.swing.JTextField preco3;
    private javax.swing.JTextField preco4;
    private javax.swing.JTextField preco5;
    private javax.swing.JTextField preco6;
    private javax.swing.JTextField preco7;
    private javax.swing.JTextField preco8;
    private javax.swing.JTextField qtd1;
    private javax.swing.JTextField qtd2;
    private javax.swing.JTextField qtd3;
    private javax.swing.JTextField qtd4;
    private javax.swing.JTextField qtd5;
    private javax.swing.JTextField qtd6;
    private javax.swing.JTextField qtd7;
    private javax.swing.JTextField qtd8;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalPeso;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
