package com.licitacion.api;

import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.licitacion.dto.ErrorMsj;

@ControllerAdvice()
public class ErrorHandler {

	//private static final Logger logger = Logger.getLogger(ErrorHandler.class);
	private Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
	 

	
	
	
//	/* Manejadores para los erres 4XX */
//
//	/**
//	 * Url no encontrada
//	 * 
//	 * @return HTTP 404
//	 */
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public ResponseEntity<ErrorMsj> handleUrlnotFound(NoHandlerFoundException ex) {
//
//		logger.error(HttpStatus.NOT_FOUND.value() + " - "+HttpStatus.NOT_FOUND.getReasonPhrase());
//		logger.error(ex.getMessage());
//		
//		ErrorMsj m = new ErrorMsj(HttpStatus.NOT_FOUND.value(), "Recurso no encontrado");
//		
//    	return new ResponseEntity<ErrorMsj>(m,HttpStatus.NOT_FOUND);
//	}
//	
//	/**
//	 * Recurso no encontrado. 
//	 * 
//	 * @return HTTP 404
//	 */
//	@ExceptionHandler(RecursoNoEncontradoException.class)
//	public ResponseEntity<ErrorMsj> resourseNotFound(RecursoNoEncontradoException ex) {
//		
//		logger.info(HttpStatus.NOT_FOUND.value() + " - "+ HttpStatus.NOT_FOUND.getReasonPhrase());
//		logger.info(ex.getMessage());
//		
//		ErrorMsj m = new ErrorMsj(HttpStatus.NOT_FOUND.value(), ex.getMessage());
//		
//    	return new ResponseEntity<ErrorMsj>(m,HttpStatus.NOT_FOUND);
//	}
//		
//	
//	/**
//	 * Manejadorno encontrado en merlin. 
//	 * 
//	 * @param ex
//	 * @return HTTP 404
//	 */
//	@ExceptionHandler(MerlinNotFoundException.class)
//	public ResponseEntity<ErrorMsj> handleValidations(MerlinNotFoundException ex) {
//
//		logger.warn(HttpStatus.NOT_FOUND.value()+ " - Validaciones Merlin:" +ex.getMessage());
//		
//		ErrorMsj m = new ErrorMsj(HttpStatus.NOT_FOUND.value(), "Merlin", ex.getMessage());
//		//m.setErrors(ex.getMessage());
//		return new ResponseEntity<ErrorMsj>(m, HttpStatus.NOT_FOUND);
//	}
//	
//
//		
//	/**
//	 * Recurso en conflicto.  
//	 * 
//	 * @return HTTP 409
//	 */
//	@ExceptionHandler(RecursoExistenteException.class)
//	public ResponseEntity<ErrorMsj> resoursoExistenteException(RecursoExistenteException ex) {
//		
//		logger.info(HttpStatus.CONFLICT.value() + " - "+ HttpStatus.CONFLICT.getReasonPhrase() + " - "  + ex.getValidaciones().toString());
//		
//		ErrorMsj m = new ErrorMsj(HttpStatus.CONFLICT.value(), "Conflicto");
//		
//		m.setErrors(ex.getValidaciones());				
//		
//    	return new ResponseEntity<ErrorMsj>(m,HttpStatus.CONFLICT);   	
//    	
//	}
//	
//	
//	/**
//	 * Manejador servicio Merlin caido. 
//	 * 
//	 * @param ex
//	 * @return HTTP 424
//	 */
//	@ExceptionHandler(MerlinHttpException.class)
//	public ResponseEntity<ErrorMsj> handleValidations(MerlinHttpException ex) {
//		
//		logger.warn(HttpStatus.FAILED_DEPENDENCY.value()+ " - Servicio Merlin caido:" + ex.getMessage());
//		
//		ErrorMsj m = new ErrorMsj(HttpStatus.FAILED_DEPENDENCY.value(), "Servicio Merlin caido", ex.getMessage());
//		//m.setErrors(ex.getMessage());
//		return new ResponseEntity<ErrorMsj>(m, HttpStatus.FAILED_DEPENDENCY);
//	}
//	
//
//	/**
//	 *  Validaciones
//	 * 
//	 * @return HTTP 422
//	 */
//	@ExceptionHandler(RivadaviaException.class)
//	public ResponseEntity<ErrorMsj> handleValidations(RivadaviaException ex) {
//
//		logger.info(HttpStatus.UNPROCESSABLE_ENTITY.value() + " - Validaciones: " +ex.getValidaciones().toString());
//		
//		ErrorMsj m = new ErrorMsj(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Validaciones");
//		
//		m.setErrors(ex.getValidaciones());
//		
//		return new ResponseEntity<ErrorMsj>(m, HttpStatus.UNPROCESSABLE_ENTITY);
//	}
//	
//	
//
//	
//	
//	
//	/**
//	 * Manejador para las excepciones de merlin
//	 * 
//	 * @param ex
//	 * @return 422
//	 */
//	@ExceptionHandler(MerlinException.class)
//	public ResponseEntity<ErrorMsj> handleValidations(MerlinException ex) {
//
//		logger.warn(HttpStatus.UNPROCESSABLE_ENTITY.value()+ " - Validaciones Merlin:" +ex.getMessage());
//		
//		ErrorMsj m = new ErrorMsj(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Merlin", ex.getMessage());
//		//m.setErrors(ex.getMessage());
//		return new ResponseEntity<ErrorMsj>(m, HttpStatus.UNPROCESSABLE_ENTITY);
//	}
//	
	

	/* Manejadores para los errores 5XX */

	/**
	 * Manejador para excepciones SQL
	 * 
	 * @return HTTP 500
	 */
	@ExceptionHandler({ SQLException.class, SQLDataException.class })
	public ResponseEntity<ErrorMsj> handleSQL(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		
		logger.error(HttpStatus.INTERNAL_SERVER_ERROR.value()+ " - "+ HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getStackTrace());
		//logger.error( ex.getStackTrace());
		
		ErrorMsj mensaje = new ErrorMsj(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Reintente en unos instantes");
		
		return new ResponseEntity<ErrorMsj>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	


	/**
	 * Manejador por default.
	 * 
	 * @return HTTP 500
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMsj> handleDefault(Exception ex, HttpServletRequest request,
			HttpServletResponse response) {
		
		logger.error(HttpStatus.INTERNAL_SERVER_ERROR.value()+ " - "+ HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getStackTrace());
		//logger.error( ex.getStackTrace());
		
		ErrorMsj mensaje = new ErrorMsj(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Reintente en unos instantes");
		
		return new ResponseEntity<ErrorMsj>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	
}
