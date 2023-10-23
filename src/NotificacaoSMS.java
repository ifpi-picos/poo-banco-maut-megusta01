public class NotificacaoSMS implements Notificacao {
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("Enviando notificação por SMS");
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: " + valor);
    }
}
