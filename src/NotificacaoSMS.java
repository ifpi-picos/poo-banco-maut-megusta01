public class NotificacaoSMS implements Notificacao {

    @Override
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("Enviando notificação por SMS");
        System.out.println("\nTipo: " + tipo);
        System.out.println("Valor: " + valor);
    }
}
