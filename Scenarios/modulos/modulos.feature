@modulos
Feature: verificar los modulos fuciones en - MANTISBT
  Como usuario de mantisbt
  quiero poder ver las funcionalidades modulos de mantisbt
  Para validar su funcionalidad

  Background:
    Given que el usuario abre el navegador y accede al sistema
    When el usuario ingresa el correo "Jgomez"
    And el usuario hace click en ingresar
    And el usuario ingresa la contrasena "Calidad#1234"
    And el usuario hace clic en el boton iniciar session
    Then el usuario debe ver el dashboard principal con el mensaje "smaller-75" y "Jgomez"

  @modulos @mantisbt @funcional
  Scenario Outline: quiero validar las funcionalidades de los modulos
    When el usuario verifica el modulo vista
    And el usuario verifica plan QA
    And el usuario verifica que pueda ver incidencias
    And el usuario verifica que pueda reportar incidencias
    And el usuario verifica que pueda registrar cambios
    And el usuario verifica que pueda ver la hoja de ruta
    And el usuario verifica que pueda ver los casos de regresion
    And el usuario verifica que pueda ver la Administracion
    And el usuario sale del sistema


    Examples:
      | user   | password     | mensaje    | usuario |
      | Jgomez | Calidad#1234 | smaller-75 | Jgomez  |
