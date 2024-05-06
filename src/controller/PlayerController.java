package controller;

import javax.swing.JOptionPane;
import model.Lista;
import models.Musica;

public class PlayerController {

    public PlayerController() {
        super();
    }

    public void adicionaMusica(String info, Lista<Musica> l) throws Exception {
        String[] vetor = info.split(";");

        String nome = vetor[0];
        String nomeArtista = vetor[1];
        int duracao = Integer.parseInt(vetor[2]);
        Musica musicas = new Musica(nome, nomeArtista, duracao);

        if (l.isEmpty()) {
            l.addFirst(musicas);
        } else {
            l.addLast(musicas);
        }
    }

    public void removerMusica(Lista<Musica> l, int posicao) throws Exception {
        if (l.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há músicas para retirar");
        } else {
            System.out.println("Removendo Musica: " + l.get(posicao).getNome());
            l.remove(posicao);
        }
    }

    public void executaPlaylist(Lista<Musica> l) throws Exception {
        if (l.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há músicas para executar");
        } else {
            for (int i = 0; i < l.size(); i++) {
                Musica musica = l.get(i);
                System.out.println("[Música: " + musica.getNome() + " - Artista: " + musica.getNomeArtista() + " - Duração: " + musica.getDuracao() + "]");
                System.out.println("Tocando...");
                Thread.sleep(musica.getDuracao() * 1000); 
            }
        }
    }
}