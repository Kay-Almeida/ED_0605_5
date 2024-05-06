package view;

import javax.swing.JOptionPane;
import controller.PlayerController;
import model.Lista;
import models.Musica;

public class Principal {
    static String info;

    public static void main(String[] args) throws Exception {

        Lista<Musica> l = new Lista<Musica>();
        PlayerController pl = new PlayerController();

        int opc = 0;

        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Vitufy PlayerMusic\n 1 - Adicionar música a lista de reprodução\n 2 - Remover música da lista de reprodução\n 3 - Executar Playlist\n 9 - Finalizar programa"));
            switch (opc) {
                case 1:
                    inserirInfo();
                    pl.adicionaMusica(info, l);
                    break;
                case 2:
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição da música que será removida: "));
                    pl.removerMusica(l, posicao);
                    break;
                case 3:
                    pl.executaPlaylist(l);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Encerrando Programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        }

    }

    public static void inserirInfo() {
        String nome = (JOptionPane.showInputDialog("Insira o nome da música: "));
        String artista = (JOptionPane.showInputDialog("Insira o nome do artista: "));
        String duracao = (JOptionPane.showInputDialog("Insira a duração da música (em segundos): "));
        info = (nome + ";");
        info = info.concat(artista + ";").concat(duracao + ";");

    }
}