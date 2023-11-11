package mainPersistencia;

import java.util.List;

import jakarta.persistence.TypedQuery;

import org.eclipse.persistence.indirection.IndirectList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.Usuario;