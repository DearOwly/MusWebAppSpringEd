package so.sonya.muswebapp2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerRest extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request
    ) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
          .getAllErrors()
          .forEach(error -> {
              String propertyName = getPropertyName(error);
              String errorMessage = error.getDefaultMessage();
              errors.put(propertyName, errorMessage);
          });

        String defaultDetail = "Validation failure.";
        ProblemDetail body = createProblemDetail(ex, status, defaultDetail, null, null, request);

        body.setProperties(Collections.singletonMap("errors", errors));

        return handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(
        HandlerMethodValidationException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request
    ) {
        Map<String, List<String>> errors = new HashMap<>();

        ex.getAllValidationResults()
          .forEach(result -> {
              MethodParameter methodParameter = result.getMethodParameter();

              String parameterName = getParameterName(methodParameter);

              List<String> errorMessages = result.getResolvableErrors()
                                                 .stream()
                                                 .map(MessageSourceResolvable::getDefaultMessage)
                                                 .toList();

              errors.put(parameterName, errorMessages);
          });

        String defaultDetail = "Validation failure.";
        ProblemDetail body = createProblemDetail(ex, status, defaultDetail, null, null, request);

        body.setProperties(Collections.singletonMap("errors", errors));

        return handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
        TypeMismatchException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request
    ) {
        String propertyName = getPropertyName(ex);
        Object[] args = {propertyName, ex.getValue()};
        String defaultDetail = "Failed to convert '" + args[0] + "' with value: '" + args[1] + "'";
        String messageCode = ErrorResponse.getDefaultDetailMessageCode(TypeMismatchException.class, null);
        ProblemDetail body = createProblemDetail(ex, status, defaultDetail, messageCode, args, request);

        return handleExceptionInternal(ex, body, headers, status, request);
    }

    private static String getParameterName(MethodParameter methodParameter) {
        String parameterName = "";

        if (methodParameter.hasParameterAnnotation(RequestParam.class)) {
            RequestParam requestParam = methodParameter.getParameterAnnotation(RequestParam.class);

            if (requestParam != null) {
                parameterName = requestParam.name();
            }
        }

        if (methodParameter.hasParameterAnnotation(PathVariable.class)) {
            PathVariable pathVariable = methodParameter.getParameterAnnotation(PathVariable.class);

            if (pathVariable != null) {
                parameterName = pathVariable.name();
            }
        }

        return parameterName.isBlank() ? methodParameter.getParameterName() : parameterName;
    }

    private static String getPropertyName(ObjectError error) {
        if (error instanceof FieldError fieldError) {
            return fieldError.getField();
        }

        return error.getObjectName();
    }

    private static String getPropertyName(TypeMismatchException ex) {
        if (ex instanceof MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
            MethodParameter methodParameter = methodArgumentTypeMismatchException.getParameter();
            return getParameterName(methodParameter);
        }

        return ex.getPropertyName();
    }
}
