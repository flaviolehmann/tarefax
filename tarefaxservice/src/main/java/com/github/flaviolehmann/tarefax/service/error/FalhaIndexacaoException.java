package com.github.flaviolehmann.tarefax.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FalhaIndexacaoException extends RuntimeException {
}
