#!/bin/env bash

main() {
  
  
  echo "Seleccione una opcion para compilar:"
  echo "- 1. Compilar todo -"
  echo "- 2. Compilar Estacion De Trabajo y Servidor Central -"
  echo "- 3. Compilar Servidor Web y Dispositivo Movil -"
  echo "- 4. Salir -"
  read -n 1 -p "Ingrese opcion: " mainmenuinput

  echo ""

  if [ "$mainmenuinput" = "1" ]; then
    compilarTodo
  elif [ "$mainmenuinput" = "2" ]; then
    compilarEstacionDeTrabajo
  elif [ "$mainmenuinput" = "3" ]; then
    compilarServidorWeb
  elif [ "$mainmenuinput" = "4" ]; then
    exit 
  else
    clear
    main
  fi

  echo ""
  echo ""
  
  read -n 1 -s -r -p "Presione cualquier tecla para continuar..."
}


compilarEstacionDeTrabajo(){
	
	echo "Compilando Estacion De Trabajo y Servidor Central..."
	cd estacion_de_trabajos
	mvn clean package install
	
}

compilarServidorWeb(){
	
	echo "Compilando el Servidor Web y el Dispositivo Movil..."
	cd servidor_web
	cd sitio_web_dinamico
	mvn clean package install
	
}

compilarTodo() {
  	
  	compilarEstacionDeTrabajo
  	compilarServidorWeb
  	
}

main