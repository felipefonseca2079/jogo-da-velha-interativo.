class Tabuleiro {
    private char[][] casas = new char[3][3];

    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.casas[i][j] = ' ';
            }
        }
    }

    public boolean jogar(char simbolo, int linha, int coluna) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || this.casas[linha][coluna] != ' ') {
            return false;
        }
        this.casas[linha][coluna] = simbolo;
        return true;
    }

    public boolean acabouOJogo() {
        return todasAsCasasPreenchidas() || haUmVencedor();
    }

    public boolean todasAsCasasPreenchidas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.casas[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public boolean haUmVencedor() {
        // Linhas e Colunas
        for (int i = 0; i < 3; i++) {
            if (casas[i][0] != ' ' && casas[i][0] == casas[i][1] && casas[i][1] == casas[i][2]) return true;
            if (casas[0][i] != ' ' && casas[0][i] == casas[1][i] && casas[1][i] == casas[2][i]) return true;
        }
        // Diagonais
        if (casas[1][1] != ' ') {
            if (casas[0][0] == casas[1][1] && casas[1][1] == casas[2][2]) return true;
            if (casas[0][2] == casas[1][1] && casas[1][1] == casas[2][0]) return true;
        }
        return false;
    }

    public void mostrar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + this.casas[i][j] + "]");
            }
            System.out.println(" " + i);
        }
        System.out.println();
    }
    
}