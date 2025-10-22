package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.JogoInvalidoException;
import school.sptech.exception.JogoNaoEncontradoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nome;
    private List<Jogo> jogos;

    public Empresa() {
        this.jogos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void adicionarJogo(Jogo jogo) {
        if (jogo == null) {
            throw new JogoInvalidoException("Jogo não pode ser nulo.");
        }

        if (isNuloOuBranco(jogo.getCodigo())) {
            throw new JogoInvalidoException("Código do jogo inválido.");
        }


        if (isNuloOuBranco(jogo.getNome())) {
            throw new JogoInvalidoException("Nome do jogo inválido.");
        }

        if (isNuloOuBranco(jogo.getGenero())) {
            throw new JogoInvalidoException("Gênero do jogo inválido.");
        }


        if (jogo.getPreco() == null || jogo.getPreco() <= 0) {
            throw new JogoInvalidoException("Preço do jogo deve ser maior que zero.");
        }

        if (jogo.getAvaliacao() == null || jogo.getAvaliacao() < 0 || jogo.getAvaliacao() > 5) {
            throw new JogoInvalidoException("Avaliação do jogo deve estar entre 0 e 5.");
        }

        if (jogo.getDataLancamento() == null) {
            throw new JogoInvalidoException("Data de lançamento inválida.");
        }
        LocalDate hoje = LocalDate.now();
        if (jogo.getDataLancamento().isAfter(hoje)) {
            throw new JogoInvalidoException("Data de lançamento não pode ser futura.");
        }

        jogos.add(jogo);
    }
    public Jogo buscarJogoPorCodigo(String codigo) {
        if (isNuloOuBranco(codigo)) {
            throw new ArgumentoInvalidoException("Código inválido.");
        }

        for (Jogo j : jogos) {
            if (j.getCodigo() != null && j.getCodigo().equals(codigo)) {
                return j;
            }
        }

        throw new JogoNaoEncontradoException("Jogo não encontrado para o código informado.");
    }


    public void removerJogoPorCodigo(String codigo) {
        if (isNuloOuBranco(codigo)) {
            throw new ArgumentoInvalidoException("Código inválido.");
        }

        Jogo encontrado = buscarJogoPorCodigo(codigo);

        jogos.remove(encontrado);
    }

    public Jogo buscarJogoComMelhorAvaliacao() {
        if (jogos.isEmpty()) {
            throw new JogoNaoEncontradoException("Não há jogos cadastrados.");
        }

        Jogo melhor = null;

        for (Jogo atual : jogos) {
            if (melhor == null) {
                melhor = atual;
            } else {
                double avMelhor = melhor.getAvaliacao() != null ? melhor.getAvaliacao() : -1.0;
                double avAtual = atual.getAvaliacao() != null ? atual.getAvaliacao() : -1.0;

                if (avAtual > avMelhor) {
                    melhor = atual;
                } else if (avAtual == avMelhor) {
                    LocalDate dMelhor = melhor.getDataLancamento();
                    LocalDate dAtual = atual.getDataLancamento();

                    if (dMelhor == null && dAtual != null) {
                        melhor = atual;
                    } else if (dMelhor != null && dAtual != null && dAtual.isAfter(dMelhor)) {
                        melhor = atual;
                    }
                }
            }
        }

        return melhor;
    }

    public List<Jogo> buscarJogoPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        if (dataInicio == null || dataFim == null) {
            throw new ArgumentoInvalidoException("Datas não podem ser nulas.");
        }
        if (dataInicio.isAfter(dataFim)) {
            throw new ArgumentoInvalidoException("Data de início não pode ser maior que a data fim.");
        }

        List<Jogo> resultado = new ArrayList<>();

        for (Jogo j : jogos) {
            LocalDate data = j.getDataLancamento();
            if (data != null && ( !data.isBefore(dataInicio) && !data.isAfter(dataFim) )) {
                resultado.add(j);
            }
        }

        return resultado;
    }

    private boolean isNuloOuBranco(String s) {
        return s == null || s.trim().isEmpty();
    }
}