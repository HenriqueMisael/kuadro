package com.henriquemisael.kuadro.controller;

import com.henriquemisael.kuadro.controller.response.ErrorResponse;
import com.henriquemisael.kuadro.exception.MultilanguageException;
import com.henriquemisael.kuadro.exception.badrequest.BadRequestException;
import com.henriquemisael.kuadro.exception.notfound.NotFoundException;
import com.henriquemisael.kuadro.exception.preconditionfailed.PreconditionFailedException;
import com.henriquemisael.kuadro.message.Language;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {

    private final Language language;

    public ExceptionHandlers(Language language) {
        this.language = language;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handleBadRequestException(final BadRequestException ex) {
        return getErrorResponse(ex);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(final NotFoundException ex) {
        return getErrorResponse(ex);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(PreconditionFailedException.class)
    public ErrorResponse handlePreConditionFailedException(final PreconditionFailedException ex) {
        return getErrorResponse(ex);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResponse handleThrowable(final Throwable ex) {
        return new ErrorResponse("INTERNAL_SERVER_ERROR", ex.getMessage());
    }

    private ErrorResponse getErrorResponse(MultilanguageException ex) {
        return new ErrorResponse(ex.getClass().getSimpleName(), language.get(ex.getMessageKey(), ex.getArgs()));
    }
}
