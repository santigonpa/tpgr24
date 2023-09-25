package com.model;

public enum EstadoSesion {
	NO_LOGEADO,           // nunca intentó iniciar sesión
    SI_LOGEADO,     // tiene la sesión iniciada
    MAL_LOGEADO    // le erro a la sesión al menos una vez
}
