package tech.ada.ecommerce.model.enums;

public enum StatusEnum {

    EM_ABERTO("Em aberto"),
    PGTO_APROVADO("Pagamento Aprovado"),
    PGTO_PROCESSAMENTO("Pagamento Processado"),
    PGTO_REJEITADO("Pagamento Rejeitado"),
    CANCELADA("Cancelada"),
    EM_TRANSPORTE("Em Transporte"),
    FINALIZADO("Finalizado");

    private String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
