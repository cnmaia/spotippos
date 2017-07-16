package br.com.cmaia.controller.handler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;

import br.com.cmaia.exception.ResourceNotFoundException;
import br.com.cmaia.exception.ValidationException;
import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @Before
    public void setUp() {
        this.globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testHandleIllegalArgumentExceptionHttpStatusShouldBeBadRequest() {
        ResponseEntity responseEntity = this.globalExceptionHandler.handleIllegalArgumentException();

        assertNotNull(responseEntity);
        assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testHandleNumberFormatExceptionHttpStatusShouldBeBadRequest() {
        ResponseEntity responseEntity = this.globalExceptionHandler.handleNumberFormatException();

        assertNotNull(responseEntity);
        assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testHandleMethodNotSupportedExceptionHttpStatusShouldBeMethodNotAllowed() {
        ResponseEntity responseEntity = this.globalExceptionHandler.handleMethodNotSupported();

        assertNotNull(responseEntity);
        assertEquals(405, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testHandleMediaNotSupportedExceptionHttpStatusShouldBeUnsupportedMediaType() {
        ResponseEntity responseEntity = this.globalExceptionHandler.handleMediaNotSupported(new HttpMediaTypeNotSupportedException(""));

        assertNotNull(responseEntity);
        assertEquals(415, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testHandleResourceNotFoundExceptionHttpStatusShouldBeNotFound() {
        ResponseEntity responseEntity = this.globalExceptionHandler.handleResourceNotFound(new ResourceNotFoundException(""));

        assertNotNull(responseEntity);
        assertEquals(404, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testHandleValidationExceptionHttpStatusShouldBeBadRequest() {
        ResponseEntity responseEntity = this.globalExceptionHandler.handleValidationException(new ValidationException(""));

        assertNotNull(responseEntity);
        assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testHandleGenericExceptionHttpStatusShouldBeInternalServerError() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getRequestURI()).thenReturn(null);

        ResponseEntity responseEntity = this.globalExceptionHandler.handleGenericException(request, new Exception());

        assertNotNull(responseEntity);
        assertEquals(500, responseEntity.getStatusCodeValue());
    }
}