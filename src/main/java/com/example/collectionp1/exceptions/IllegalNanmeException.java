package com.example.collectionp1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "В имени доджны быть только буквы")
public class IllegalNanmeException extends IllegalArgumentException {
}
