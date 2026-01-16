package org.example.bankapp.validation;

public enum MessageErreurEnum {
    SOLDE_OBLIGATOIRE("SOLDE_OBLIGATOIRE"),
    SOLDE_POSITIF("SOLDE_POSITIF"),
    INVALID_JSON("INVALID_JSON");


    private final String  msg;

    MessageErreurEnum(String msg)
    {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
