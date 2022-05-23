/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author Intel i3-4010U
 */
public class ProdutoDAO {

    public void create(Produto p, String table) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        if (table.equals("produto")) {

            try {
                stmt = con.prepareStatement("INSERT INTO produto (nome, descricao, quantidade, preco, localizacao, peso) VALUES(?,?,?,?,?,?)");
                // stmt.setNull(1, p.getId());
                stmt.setString(1, p.getNome());
                stmt.setString(2, p.getDescricao());
                stmt.setInt(3, p.getQuantidade());
                stmt.setDouble(4, p.getPreco());
                stmt.setString(5, p.getLocalizacao());
                stmt.setDouble(6, p.getPeso());

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        } else if (table.equals("carrinho")) {
            try {
                stmt = con.prepareStatement("INSERT INTO carrinho (id_usuario, id_produto, qtd) VALUES(?,?,?)");
                // stmt.setNull(1, p.getId());
                stmt.setInt(1, 1);
                stmt.setInt(2, p.getId());
                stmt.setInt(3, 1);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    }

    public List<Produto> read(String table) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        if (table.equals("produto")) {

            try {
                stmt = con.prepareStatement("SELECT * FROM produto");
                rs = stmt.executeQuery();

                while (rs.next()) {

                    Produto produto = new Produto();

                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setLocal(rs.getString("localizacao"));
                    produto.setPeso(rs.getDouble("peso"));
                    produtos.add(produto);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return produtos;
        } else if (table.equals("carrinhoQtd")) {

            try {
                stmt = con.prepareStatement("SELECT qtd FROM carrinho");
                rs = stmt.executeQuery();

                while (rs.next()) {

                    Produto produto = new Produto();

                    produto.setQtd(rs.getInt("qtd"));
                    produtos.add(produto);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        } else if (table.equals("carrinhoPreco")) {

            try {
                stmt = con.prepareStatement("SELECT produto.preco FROM produto INNER JOIN carrinho ON produto.id = carrinho.id_produto");
                rs = stmt.executeQuery();

                while (rs.next()) {

                    Produto produto = new Produto();

                    produto.setPreco(rs.getDouble("preco"));
                    produtos.add(produto);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        return produtos;
    }

    public int readCart(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;

        try {

            stmt = con.prepareStatement("SELECT SUM(qtd) FROM carrinho where id_usuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1); // note that indexes are one-based
            }

            System.out.println(count);

            return count;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return count;
    }

    public List<Produto> readCartProdutoData(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT produto.* , carrinho.qtd FROM produto INNER JOIN carrinho ON carrinho.id_usuario = ? AND produto.id = carrinho.id_produto");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setLocal(rs.getString("localizacao"));
                produto.setPeso(rs.getDouble("peso"));
                produtos.add(produto);
            }

            return produtos;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            return produtos;
        }
    }

    public int existInCart(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;

        try {

            stmt = con.prepareStatement("SELECT COUNT(id_produto) FROM carrinho WHERE id_produto = ? ");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1); // note that indexes are one-based
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return count;
    }

    public void update(Produto p, String table) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET nome = ?, descricao = ?, quantidade = ?, preco = ?, localizacao = ?, peso = ? where id = ?");
            // stmt.setNull(1, p.getId());
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getQuantidade());
            stmt.setDouble(4, p.getPreco());
            stmt.setString(5, p.getLocalizacao());
            stmt.setDouble(6, p.getPeso());
            stmt.setInt(7, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void updateCart(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carrinho SET qtd = qtd + 1 where id_produto = ? ");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void updateCartDecrement(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carrinho SET qtd = qtd - 1 where id_produto = ? ");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public double readCartTotal(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double count = 0;

        try {
            stmt = con.prepareStatement("SELECT SUM(c.qtd * p.preco) total FROM produto p INNER JOIN carrinho c ON c.id_produto = p.id WHERE c.id_usuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                count = rs.getDouble("total");
            }
            return count;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            return count;
        }
    }

    public double readCartTotalWeight(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double count = 0;

        try {
            stmt = con.prepareStatement("SELECT SUM(c.qtd * p.peso) total FROM produto p INNER JOIN carrinho c ON c.id_produto = p.id WHERE c.id_usuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                count = rs.getDouble("total");
            }
            return count;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            return count;
        }
    }

    public List<Produto> readById(int id, String table) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM produto WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setLocal(rs.getString("localizacao"));
                produto.setPeso(rs.getDouble("peso"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;
    }

    public void delete(int id, String table) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setInt(1, id);
            System.out.println(id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void cleanUpCart(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM carrinho WHERE id_usuario = ?");
            stmt.setInt(1, id);
            System.out.println(id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar : " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
