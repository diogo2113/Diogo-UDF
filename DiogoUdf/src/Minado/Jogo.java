package Minado;

public class Jogo {
    private Tabuleiro board;
    boolean terminar = false;
    boolean ganhou = false;
    int[] jogada;
    int rodada=0;
    
    public Jogo(){
        board = new Tabuleiro();
        Jogar(board);
        jogada = new int[2];
    }
    
    public void Jogar(Tabuleiro board){
        do{
            rodada++;
            System.out.println("Rodada "+rodada);
            board.exibe();
            terminar = board.setPosicao();
            
            if(!terminar){
                board.abrirVizinhas();
                terminar = board.ganhou();
            }
            
        }while(!terminar);
        
        if(!board.ganhou()){
            System.out.println("Havia uma mina ! Voc� perdeu!");
            board.exibeMinas();
        } else {
            System.out.println("Parab�ns, voc� deixou os 8 campos de minas livres em "+rodada+" rodadas");
            board.exibeMinas();
        }
    }
}