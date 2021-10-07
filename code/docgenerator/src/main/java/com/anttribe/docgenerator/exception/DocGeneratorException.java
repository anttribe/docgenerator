package com.anttribe.docgenerator.exception;

/**
 * @author zhaoyong
 * @date 2021/10/6 0006
 */
public class DocGeneratorException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4357133041028366446L;

    public DocGeneratorException() {
        super();
    }

    public DocGeneratorException(String message) {
        super(message);
    }

    public DocGeneratorException(Throwable cause) {
        super(cause);
    }

    public DocGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    protected DocGeneratorException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
