public class NotificacaoEmail implements Notificacao {
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("Enviando notificação por e-mail");
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: " + valor);
    }
}
